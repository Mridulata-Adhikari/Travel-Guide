package com.example.bottombar_navigation_with_fragment;

public class Trips {
    private String name;
    private String location;
    private String datefrom;


    public Trips() {
    }

    public Trips(String name, String location, String datefrom) {
        this.name = name;
        this.location= location;
        this.datefrom = datefrom;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(String datefrom) {
        this.datefrom = datefrom;
    }

}
