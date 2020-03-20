package com.example.opsecmessenger_admin.models;

public class LicenseKeysModel {

    String license_key;
    boolean status;

    public LicenseKeysModel(String license_key, boolean status) {
        this.license_key = license_key;
        this.status = status;
    }

    public String getLicense_key() {
        return license_key;
    }

    public boolean isStatus() {
        return status;
    }
}
