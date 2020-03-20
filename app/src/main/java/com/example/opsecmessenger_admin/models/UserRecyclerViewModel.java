package com.example.opsecmessenger_admin.models;

public class UserRecyclerViewModel {

    String name ;
    String shortDescription;

    public UserRecyclerViewModel(String name, String shortDescription) {
        this.name = name;
        this.shortDescription = shortDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}