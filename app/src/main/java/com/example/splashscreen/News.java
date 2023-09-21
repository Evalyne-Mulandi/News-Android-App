package com.example.splashscreen;

public class News {

    private String title = "";
    private String imageUrl = "";
    private String url = "";
    private String content = "";
    private String author = "";
    private String description = "";
    private String publishedAt = "";

    public News(String title, String imageUrl, String author, String content, String url, String publishedAt, String description) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.author = author;
        this.content = content;
        this.url = url;
        this.description = description;
        this.publishedAt = publishedAt;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String author) {
        this.description = description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    // set method : sets the date
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
