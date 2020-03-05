package com.boot.spring.with.blog_man_big_to_growth.model;

import lombok.Builder;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ToString
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String backgroundUrl;

    private String contents;

    public Article() {
    }

    @Builder
    public Article(String title, String backgroundUrl, String contents) {
        this.title = title;
        this.backgroundUrl = backgroundUrl;
        this.contents = contents;
    }

    // 여기서 굳이 request dto를 넣어서 작업을 하지 않는 것은 request에서 내려온 데이터를 domain 레벨까지 사용하는 것은 좋지 않기 때문
    public void update (String title, String backgroundUrl, String contents) {
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
