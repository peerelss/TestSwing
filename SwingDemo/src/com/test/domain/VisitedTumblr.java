package com.test.domain;

import java.util.Date;

/**
 * Created by kevin on 2016/12/19.
 */
public class VisitedTumblr {
    private int id;
    private String domName;
    private Date visitTime;
    private int beginPage;
    private int endPage;

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

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    @Override
    public String toString() {
        return "VisitedTumblr{" +
                "id=" + id +
                ", domName='" + domName + '\'' +
                ", visitTime=" + visitTime +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                '}';
    }
}
