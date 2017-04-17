package com.example.teachersharing.ui.entity;

public class NewsEntity {
    private int  wcmnid;
    private int wcmcid;
    private String title;
    private String contnet;
    private String pubtime;
    private String docpuburl;
    private String author;
    private String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getWcmnid() {
        return wcmnid;
    }

    public void setWcmnid(int wcmnid) {
        this.wcmnid = wcmnid;
    }

    public int getWcmcid() {
        return wcmcid;
    }

    public void setWcmcid(int wcmcid) {
        this.wcmcid = wcmcid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContnet() {
        return contnet;
    }

    public void setContnet(String contnet) {
        this.contnet = contnet;
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
    }

    public String getDocpuburl() {
        return docpuburl;
    }

    public void setDocpuburl(String docpuburl) {
        this.docpuburl = docpuburl;
    }
}
