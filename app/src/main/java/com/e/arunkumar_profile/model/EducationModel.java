package com.e.arunkumar_profile.model;

public class EducationModel {

    String college,location,dauration,designation;

    public EducationModel(String college, String location, String dauration, String designation) {
        this.college = college;
        this.location = location;
        this.dauration = dauration;
        this.designation = designation;
    }

    public String getCollege() {
        return college;
    }

    public String getLocation() {
        return location;
    }

    public String getDauration() {
        return dauration;
    }

    public String getDesignation() {
        return designation;
    }

}
