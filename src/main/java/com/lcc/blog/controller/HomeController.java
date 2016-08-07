package com.lcc.blog.controller;

import com.lcc.blog.model.Article;
import com.lcc.blog.model.form.UserForm;
import com.lcc.blog.service.ArticleService;
import com.lcc.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by lcc_luffy on 2016/7/23.
 */
@Controller
@SessionAttributes("userForm")
public class HomeController extends BaseController {

    @Autowired
    private ArticleService postService;

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String index(Model model, Pageable pageable) {
        Page<Article> posts = postService.getAllPosts(pageable);
        model.addAttribute("posts", posts);
        model.addAttribute("prev", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("hasPrev", pageable.hasPrevious());
        return "index";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(UserForm userForm) {
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String doRegister(Model model, RedirectAttributes redirectAttributes, @Valid UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("message", bindingResult.toString());
            return "redirect:/register";
        }
        if (userService.findByUsername(userForm.getUsername()) != null) {
            redirectAttributes.addFlashAttribute("message", "用户已存在");
            model.addAttribute("userForm", userForm);
            return "redirect:/register";
        }
        userService.createUser(userForm);
        redirectAttributes.addFlashAttribute("message", "注册成功");
        return "redirect:/";
    }

    @RequestMapping("admin")
    public String admin(Model model) {
        model.addAttribute("posts", postService.getAll());
        return "admin";
    }
}
