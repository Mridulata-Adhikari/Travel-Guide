package com.example.bottombar_navigation_with_fragment;

public class Profile {
    private String itemtitle;
    private String description;
    private String overviewimg;
    private String location;
    private String datefrom;
    private String dateto;
    private String category;
    private String tempcode;

    public Profile() {
    }


    public Profile(String itemtitle, String description, String overviewimg, String location, String datefrom, String tempcode, String dateto, String category)  {
        this.itemtitle = itemtitle;
        this.description = description;
        this.overviewimg = overviewimg;
        this.location = location;
        this.datefrom = datefrom;
        this.dateto = dateto;
        this.category = category;
        this.tempcode = tempcode;


    }

    public String getTempcode() {
        return tempcode;
    }

    public void setTempcode(String tempcode) {
        this.tempcode = tempcode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItemtitle() {
        return itemtitle;
    }

    public void setItemtitle(String itemtitle) {
        this.itemtitle = itemtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOverviewimg() {
        return overviewimg;
    }

    public void setOverviewimg(String overviewimg) {
        this.overviewimg = overviewimg;
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

    public String getDateto() {
        return dateto;
    }

    public void setDateto(String dateto) {
        this.dateto = dateto;
    }
}
