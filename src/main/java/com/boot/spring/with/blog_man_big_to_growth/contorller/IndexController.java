package com.boot.spring.with.blog_man_big_to_growth.contorller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String indexPage() {
        return "/index";
    }
}
