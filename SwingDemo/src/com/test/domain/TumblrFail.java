package com.test.domain;

/**
 * Created by kevin on 2016/12/19.
 */
public class TumblrFail {
    private int id;
    private String failDom;
    private String failUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFailDom() {
        return failDom;
    }

    public void setFailDom(String failDom) {
        this.failDom = failDom;
    }

    public String getFailUrl() {
        return failUrl;
    }

    public void setFailUrl(String failUrl) {
        this.failUrl = failUrl;
    }

    @Override
    public String toString() {
        return "TumblrFail{" +
                "id=" + id +
                ", failDom='" + failDom + '\'' +
                ", failUrl='" + failUrl + '\'' +
                '}';
    }
}
