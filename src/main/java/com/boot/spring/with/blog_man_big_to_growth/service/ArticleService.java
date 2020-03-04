package com.boot.spring.with.blog_man_big_to_growth.service;

import com.boot.spring.with.blog_man_big_to_growth.dto.ArticleRequestDto;
import com.boot.spring.with.blog_man_big_to_growth.dto.ArticleResponseDto;
import com.boot.spring.with.blog_man_big_to_growth.dto.ArticleUpdateDto;
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

    public ArticleResponseDto findOneArticleById (Long id) {
        Article article = articleRepository.findById(id).orElseThrow(NullPointerException::new);
        ArticleResponseDto articleResponseDto =
                new ArticleResponseDto(article.getId(), article.getTitle(), article.getBackgroundUrl(), article.getContents());
        log.info("{}", articleResponseDto);
        return articleResponseDto;
    }

    public void updateArticle (ArticleUpdateDto articleUpdateDto) {
        Article article = Article.builder()
                .id(articleUpdateDto.getId())
                .title(articleUpdateDto.getTitle())
                .contents(articleUpdateDto.getContents())
                .backgroundUrl(articleUpdateDto.getBackgroundUrl())
                .build();
        Article savedArticle = articleRepository.save(article);
        log.info("{}", savedArticle);
    }
}