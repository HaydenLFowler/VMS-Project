package com.example.vms_project;

public class UserModel {

    private int id;
    private String name;
    private String staff_visitor;
    private String onSite;


    public UserModel(int id, String name, String staff_visitor, String onSite) {
        this.id = id;
        this.name = name;
        this.staff_visitor = staff_visitor;
        this.onSite = onSite;
    }


    //To list the records
    @Override
    public String toString() {
        return   " -- " + id +
                 " -- " +name +
                 " -- " +staff_visitor +
                 " -- " +onSite;
    }

    public int getId() {
        return id;
    }

    public String getOnSite() {
        return onSite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStaff_visitor() { return staff_visitor; }

    public void setStaff_visitor(String staff_visitor) { this.staff_visitor = staff_visitor; }


    public void setOnSite(String onSite) {
        this.onSite = onSite;
    }


}


