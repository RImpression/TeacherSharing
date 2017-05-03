package com.example.teachersharing.ui.entity;


public class NoteEntity {

    private String id;
    private String userId;
    private String noteSortId;

    public String getNoteSortId() {
        return noteSortId;
    }

    public void setNoteSortId(String noteSortId) {
        this.noteSortId = noteSortId;
    }

    private String title;
    private String content;
    private String createDate;
    private String click;

    public Boolean getPublicity() {
        return publicity;
    }

    public void setPublicity(Boolean publicity) {
        this.publicity = publicity;
    }

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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public Boolean getUp() {
        return up;
    }

    public void setUp(Boolean up) {
        this.up = up;
    }

    private Boolean publicity;
    private Boolean up;
}
