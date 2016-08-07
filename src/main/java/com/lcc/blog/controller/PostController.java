package com.lcc.blog.controller;

import com.lcc.blog.model.Article;
import com.lcc.blog.model.form.PostForm;
import com.lcc.blog.service.PostService;
import org.markdownj.MarkdownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

/**
 * Created by lcc_luffy on 2016/7/24.
 */
@Controller
public class PostController extends BaseController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "post/{id}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable("id") Long id) {
        model.addAttribute("post", postService.getPost(id));
        return "post/show";
    }

    @RequestMapping(value = "post", method = RequestMethod.GET)
    public String create() {
        return "post/create";
    }

    @RequestMapping(value = "post", method = RequestMethod.POST)
    public String doCreate(@Valid PostForm postForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:post";
        }
        postService.createPost(postForm);
        return "redirect:/";
    }

    @RequestMapping(value = "post/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) {
        postService.deleteOne(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
    public String uploadFile() {
        return "post/uploadFile";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String dpUploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        if (!file.isEmpty()) {
            if (!file.getOriginalFilename().endsWith(".md")) {
                redirectAttributes.addFlashAttribute("message", "文件名要以.md结尾");
                return "redirect:/uploadFile";
            }
            System.out.println(file.getName());
            String md = new String(file.getBytes());
            MarkdownProcessor markdownProcessor = new MarkdownProcessor();
            String html = markdownProcessor.markdown(md);
            redirectAttributes.addFlashAttribute("message", "上传成功");
            String fileName = file.getOriginalFilename();

            Article post = new Article();
            post.setTitle(fileName.substring(0, fileName.length() - 3));
            post.setHtmlContent(html);
            post.setContent(md);
            postService.save(post);

            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("message", "文件为空");
        }
        return "redirect:/uploadFile";
    }
}
