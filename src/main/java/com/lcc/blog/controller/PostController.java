package com.lcc.blog.controller;

import com.lcc.blog.model.form.PostForm;
import com.lcc.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by lcc_luffy on 2016/7/24.
 */
@Controller
public class PostController extends BaseController {

    @Autowired
    private PostService postService;

    @RequestMapping("post/{id}")
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
            return "post/create";
        }
        postService.createPost(postForm);
        return "redirect:/";
    }
}
