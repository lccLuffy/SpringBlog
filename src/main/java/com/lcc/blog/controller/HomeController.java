package com.lcc.blog.controller;

import com.lcc.blog.model.Post;
import com.lcc.blog.model.form.UserForm;
import com.lcc.blog.service.PostService;
import com.lcc.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by lcc_luffy on 2016/7/23.
 */
@Controller
public class HomeController extends BaseController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String index(HttpServletRequest httpServletRequest, Model model, Pageable pageable) {
        Page<Post> posts = postService.getAllPosts(pageable);
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
    public String doRegister(@Valid UserForm userForm, BindingResult bindingResult) {
        logger.info(userForm.toString());
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                logger.info(fieldError.toString());
            }
            return "register";
        }
        if (userService.findByUsername(userForm.getUsername()) != null) {
            System.out.println("user-has-exist");
            return "register";
        }
        userService.createUser(userForm);
        return "redirect:/";
    }
}
