package com.amirahmed.eschoola.Models;

public class NewsItem {

    String imageURL;
    String title;
    String content;
    String date;

    public NewsItem(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
