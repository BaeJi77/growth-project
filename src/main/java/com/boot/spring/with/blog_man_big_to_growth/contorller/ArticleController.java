package com.boot.spring.with.blog_man_big_to_growth.contorller;

import com.boot.spring.with.blog_man_big_to_growth.dto.ArticleRequestDto;
import com.boot.spring.with.blog_man_big_to_growth.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/edit")
    public String findArticleAddingPage() {
        return "/article-edit";
    }

    @GetMapping("/{id}")
    public String findCertainArticle() {
        return "/article";
    }

    @PostMapping
    public String createArticle(@RequestBody ArticleRequestDto articleRequestDto) {
        articleService.createNewArticle(articleRequestDto);
        return "redirect:/";
    }
}
