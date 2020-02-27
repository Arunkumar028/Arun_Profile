package com.e.arunkumar_profile.model;

public class ProjectModel {

    String name;
    int image;
    String description,url;

    public ProjectModel(String name, int image, String description, String url) {
        this.name = name;
        this.image = image;
        this.description=description;
        this.url=url;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

}
