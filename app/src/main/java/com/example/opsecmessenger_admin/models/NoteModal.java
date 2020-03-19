package com.example.opsecmessenger_admin.models;

public class NoteModal {

    String date;
    String title;
    String note;

    public NoteModal(String date, String title, String note) {
        this.date = date;
        this.title = title;
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }
}
