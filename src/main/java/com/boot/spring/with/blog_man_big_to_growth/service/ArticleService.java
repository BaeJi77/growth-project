package com.boot.spring.with.blog_man_big_to_growth.service;

import com.boot.spring.with.blog_man_big_to_growth.dto.ArticleRequestDto;
import com.boot.spring.with.blog_man_big_to_growth.model.Article;
import com.boot.spring.with.blog_man_big_to_growth.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void createNewArticle (ArticleRequestDto articleRequestDto) {
        String title = articleRequestDto.getTitle();
        String backgroundUrl = articleRequestDto.getBackgroundUrl();
        String contents = articleRequestDto.getContents();

        Article article = new Article(title, backgroundUrl, contents);
        Article savedArticle = articleRepository.save(article);
    }
}
