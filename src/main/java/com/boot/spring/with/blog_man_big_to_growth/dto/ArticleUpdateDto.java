package com.boot.spring.with.blog_man_big_to_growth.dto;

import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ToString
public class ArticleUpdateDto {
    @NotNull
    Long id;

    @NotBlank
    private String title;

    private String backgroundUrl;

    @NotBlank
    private String contents;

    public ArticleUpdateDto() {
    }

    public ArticleUpdateDto(@NotNull Long id, @NotBlank String title, String backgroundUrl, @NotBlank String contents) {
        this.id = id;
        this.title = title;
        this.backgroundUrl = backgroundUrl;
        this.contents = contents;
    }

    public Long getId() {
        return id;
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
