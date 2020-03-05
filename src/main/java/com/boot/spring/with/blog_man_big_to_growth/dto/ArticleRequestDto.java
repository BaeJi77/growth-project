package com.boot.spring.with.blog_man_big_to_growth.dto;

import com.boot.spring.with.blog_man_big_to_growth.model.Article;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
public class ArticleRequestDto {
    @NotBlank
    private String title;

    private String backgroundUrl;

    @NotBlank
    private String contents;

    public ArticleRequestDto() {
    }

    public ArticleRequestDto(String title, String backgroundUrl, String contents) {
        this.title = title;
        this.backgroundUrl = backgroundUrl;
        this.contents = contents;
    }

    public Article makeArticle () {
        return Article.builder()
                .title(this.title)
                .contents(this.contents)
                .backgroundUrl(this.backgroundUrl)
                .build();
    }


    public String getTitle() {
        return title;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public String getContents() {
        return contents;
    }
}