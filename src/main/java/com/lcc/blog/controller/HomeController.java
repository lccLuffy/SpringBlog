package com.lcc.blog.controller;

import com.lcc.blog.model.Post;
import com.lcc.blog.service.BlogUserDetails;
import com.lcc.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lcc_luffy on 2016/7/23.
 */
@Controller
public class HomeController extends BaseController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String index(Model model, Pageable pageable) {
        Page<Post> posts = postService.getAllPosts(pageable);
        model.addAttribute("posts", posts);
        return "index";
    }


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String authenticate(/*@RequestParam("username") String username, @RequestParam("password") String password*/) {
        logger.info("username + password");
        return "redirect:/";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {

        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String doRegister() {
        return "redirect:/";
    }
}
