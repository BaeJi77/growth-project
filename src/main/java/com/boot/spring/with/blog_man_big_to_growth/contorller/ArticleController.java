package com.boot.spring.with.blog_man_big_to_growth.contorller;

import com.boot.spring.with.blog_man_big_to_growth.dto.ArticleRequestDto;
import com.boot.spring.with.blog_man_big_to_growth.dto.ArticleResponseDto;
import com.boot.spring.with.blog_man_big_to_growth.dto.ArticleUpdateDto;
import com.boot.spring.with.blog_man_big_to_growth.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
public class ArticleController {
    private final String ARTICLES = "/articles";
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(ARTICLES + "/{id}")
    public String findCertainArticle(@PathVariable Long id) {
        ArticleResponseDto articleResponseDto = articleService.findOneArticleById(id);
        return "/article";
    }

    @GetMapping(ARTICLES + "/edit")
    public String findArticleAddingPage() {
        return "/article-edit";
    }



    @PostMapping(ARTICLES)
    public String createArticle(@RequestBody @Valid ArticleRequestDto articleRequestDto) {
        log.info("{}", articleRequestDto);
        articleService.createNewArticle(articleRequestDto);
        return "redirect:/";
    }

    @PutMapping(ARTICLES)
    public String updateArticle(@RequestBody @Valid ArticleUpdateDto articleUpdateDto) {
        log.info("input data: {}", articleUpdateDto);
        articleService.updateArticle(articleUpdateDto);
        return "redirect:/";
    }

    @DeleteMapping(ARTICLES + "/{id}")
    public String deleteArticle (@PathVariable Long id) {
        log.info("delete article id: {}", id);
        articleService.deleteArticle(id);
        return "/article";
    }
}
