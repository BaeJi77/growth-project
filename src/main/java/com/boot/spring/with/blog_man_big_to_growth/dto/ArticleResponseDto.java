package com.boot.spring.with.blog_man_big_to_growth.dto;

import lombok.Builder;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@ToString
public class ArticleResponseDto {
    @NotNull
    private Long id;

    private String title;

    private String backgroundUrl;

    private String contests;

    public ArticleResponseDto() {
    }

    @Builder
    public ArticleResponseDto(Long id, String title, String backgroundUrl, String contests) {
        this.id = id;
        this.title = title;
        this.backgroundUrl = backgroundUrl;
        this.contests = contests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleResponseDto that = (ArticleResponseDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(backgroundUrl, that.backgroundUrl) &&
                Objects.equals(contests, that.contests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, backgroundUrl, contests);
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
