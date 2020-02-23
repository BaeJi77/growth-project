package com.boot.spring.with.blog_man_big_to_growth.contorller;

import com.boot.spring.with.blog_man_big_to_growth.dto.ArticleRequestDto;
import com.boot.spring.with.blog_man_big_to_growth.model.Article;
import com.boot.spring.with.blog_man_big_to_growth.repository.ArticleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
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
        String title = articleRequestDto.getTitle();
        String backgroundUrl = articleRequestDto.getBackgroundUrl();
        String contents = articleRequestDto.getContents();

        Article article = new Article(title, backgroundUrl, contents);
        articleRepository.save(article);

        return "redirect:/";
    }
}
