package com.insignia.agrosei.model;

public class MoreModel {
    String ImgUrl;
    String heading;
    String sub;

    public MoreModel(String imgUrl, String heading, String sub) {
        ImgUrl = imgUrl;
        this.heading = heading;
        this.sub = sub;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }
}
