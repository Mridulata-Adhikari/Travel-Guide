package com.example.bottombar_navigation_with_fragment;

public class Tripsss {
    private String nameoflocationtobeadded;

    private String descriptionoflocationtobeadded;
    private String overviewimgoflocationtobeadded;


    public Tripsss () {
    }

    public Tripsss(String name, String datefrom) {
        this.nameoflocationtobeadded = nameoflocationtobeadded;

        this.descriptionoflocationtobeadded = descriptionoflocationtobeadded;
        this.overviewimgoflocationtobeadded = overviewimgoflocationtobeadded;

    }

    public String getName() {
        return nameoflocationtobeadded;
    }

    public void setName(String name) {
        this.nameoflocationtobeadded = nameoflocationtobeadded;
    }


    public String getDescription() {
        return descriptionoflocationtobeadded;
    }
    public void setDescription(String descriptionoflocationtobeadded) {
        this.descriptionoflocationtobeadded = descriptionoflocationtobeadded;
    }

    public String getOverviewimg() {
        return overviewimgoflocationtobeadded;
    }

    public void setOverviewimg(String overviewimg) {
        this.overviewimgoflocationtobeadded = overviewimgoflocationtobeadded;
    }

}
