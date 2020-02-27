package com.e.arunkumar_profile.model;

public class ExperienceModel {

    String company,location,duration,designation,description;

    public ExperienceModel(String company, String location, String duration, String designation, String description) {
        this.company = company;
        this.location = location;
        this.duration = duration;
        this.designation = designation;
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getDuration() {
        return duration;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDescription() {
        return description;
    }
}
