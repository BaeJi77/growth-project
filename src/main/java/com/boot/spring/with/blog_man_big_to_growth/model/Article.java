package com.boot.spring.with.blog_man_big_to_growth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public Article(String title, String backgroundUrl, String contents) {
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
