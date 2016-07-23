package com.lcc.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lcc_luffy on 2016/7/23.
 */
@Controller
public class HomeController extends BaseController{
    @RequestMapping("/")
    public String index(Model model)
    {
        return "index";
    }

}
