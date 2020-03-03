package com.boot.spring.with.blog_man_big_to_growth.dto;

import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
public class ArticleResponseDto {
    @NotNull
    private Long id;

    private String title;

    private String backgroundUrl;

    private String contests;

    public ArticleResponseDto() {
    }

    public ArticleResponseDto(Long id, String title, String backgroundUrl, String contests) {
        this.id = id;
        this.title = title;
        this.backgroundUrl = backgroundUrl;
        this.contests = contests;
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

    public String getContests() {
        return contests;
    }
}
