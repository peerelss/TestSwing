package com.test.domain;

/**
 * Created by kevin on 2016/12/19.
 */
public class TumblrDom {
    private int id;
    private String domName;
    private String tag;
    private String level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomName() {
        return domName;
    }

    public void setDomName(String domName) {
        this.domName = domName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "TumblrDom{" +
                "id=" + id +
                ", domName='" + domName + '\'' +
                ", tag='" + tag + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
