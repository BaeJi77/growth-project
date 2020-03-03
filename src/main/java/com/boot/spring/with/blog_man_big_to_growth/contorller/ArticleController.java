package com.boot.spring.with.blog_man_big_to_growth.contorller;

import com.boot.spring.with.blog_man_big_to_growth.dto.ArticleRequestDto;
import com.boot.spring.with.blog_man_big_to_growth.dto.ArticleResponseDto;
import com.boot.spring.with.blog_man_big_to_growth.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
public class ArticleController {
    private final String PATH = "/articles";
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(PATH + "/edit")
    public String findArticleAddingPage() {
        return "/article-edit";
    }

    @GetMapping(PATH + "/{id}")
    public String findCertainArticle(@PathVariable Long id) {
        ArticleResponseDto articleResponseDto = articleService.findOneArticleById(id);
        return "/article";
    }

    @PostMapping(PATH)
    public String createArticle(@RequestBody @Valid ArticleRequestDto articleRequestDto) {
        log.info("{}", articleRequestDto);
        articleService.createNewArticle(articleRequestDto);
        return "redirect:/";
    }
}
