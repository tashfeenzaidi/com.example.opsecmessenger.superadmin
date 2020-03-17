package com.example.opsecmessenger.models;

public class LanguageModel {

    int flagImage;
    String countryName;

    public LanguageModel(int flagImage, String countryName) {
        this.flagImage = flagImage;
        this.countryName = countryName;
    }

    public int getFlagImage() {
        return flagImage;
    }

    public String getCountryName() {
        return countryName;
    }

}
