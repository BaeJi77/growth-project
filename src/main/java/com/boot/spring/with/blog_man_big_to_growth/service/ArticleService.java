package com.boot.spring.with.blog_man_big_to_growth.service;

import com.boot.spring.with.blog_man_big_to_growth.dto.ArticleRequestDto;
import com.boot.spring.with.blog_man_big_to_growth.dto.ArticleResponseDto;
import com.boot.spring.with.blog_man_big_to_growth.model.Article;
import com.boot.spring.with.blog_man_big_to_growth.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleResponseDto createNewArticle (ArticleRequestDto articleRequestDto) {
        Article savedArticle = articleRepository.save(articleRequestDto.makeArticle());
        log.info("{}", savedArticle);

        return articleToArticleResponseDto(savedArticle);
    }

    public ArticleResponseDto findOneArticleById (Long id) {
        Article foundArticle = articleRepository.findById(id).orElseThrow(NullPointerException::new);
        ArticleResponseDto articleResponseDto = articleToArticleResponseDto(foundArticle);

        log.info("{}", articleResponseDto);
        return articleResponseDto;
    }

    @Transactional
    public ArticleResponseDto updateArticle (Long id, ArticleRequestDto articleRequestDto) {
        Article foundArticle = articleRepository.findById(id).orElseThrow(NullPointerException::new);
        foundArticle.update(articleRequestDto.getTitle(), articleRequestDto.getBackgroundUrl(), articleRequestDto.getContents());
        log.info("{}", foundArticle);
        return articleToArticleResponseDto(foundArticle);
    }

    public void deleteArticle (Long articleId) {
        articleRepository.deleteById(articleId);
    }

    private ArticleResponseDto articleToArticleResponseDto (Article article) {
        return ArticleResponseDto.builder()
                .id(article.getId())
                .contests(article.getContents())
                .backgroundUrl(article.getBackgroundUrl())
                .title(article.getTitle())
                .build();
    }
}