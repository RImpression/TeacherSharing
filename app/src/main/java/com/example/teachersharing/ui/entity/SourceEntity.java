package com.example.teachersharing.ui.entity;

/**
 * 资源
 */
public class SourceEntity {

    private String id;
    private String userId;
    private String name;
    private String description;
    private String type;
    private String url;
    private String createDate;
    private String parise;
    private Boolean publicity;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getParise() {
        return parise;
    }

    public void setParise(String parise) {
        this.parise = parise;
    }

    public Boolean getPublicity() {
        return publicity;
    }

    public void setPublicity(Boolean publicity) {
        this.publicity = publicity;
    }
}
