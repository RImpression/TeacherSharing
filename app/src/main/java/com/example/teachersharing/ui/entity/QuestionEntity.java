package com.example.teachersharing.ui.entity;

/**
 * 教学问题
 */

public class QuestionEntity {
    private String id;
    private String userId;
    private String title;
    private String content;
    private String label;
    private String createDate;
    private String Praise;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getPraise() {
        return Praise;
    }

    public void setPraise(String praise) {
        Praise = praise;
    }
}
