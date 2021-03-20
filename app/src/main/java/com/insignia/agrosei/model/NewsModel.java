package com.insignia.agrosei.model;

public class NewsModel {
    String content,publishedAt,title,url,urlToImage;


    public NewsModel() {
    }

    public NewsModel(String content, String publishedAt, String title, String url, String urlToImage) {
        this.content = content;
        this.publishedAt = publishedAt;
        this.title = title;
        this.url = url;
        this.urlToImage = urlToImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}
