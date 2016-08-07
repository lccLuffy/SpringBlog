package com.lcc.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lcc_luffy on 2016/8/7.
 */
@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String create() {
        logger.info("nice category");
        return "category/create";
    }
}
