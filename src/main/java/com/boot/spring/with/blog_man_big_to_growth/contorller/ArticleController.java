package com.boot.spring.with.blog_man_big_to_growth.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    @GetMapping("/edit")
    public String getCreateArticlePage() {
        return "/article-edit";
    }
}
