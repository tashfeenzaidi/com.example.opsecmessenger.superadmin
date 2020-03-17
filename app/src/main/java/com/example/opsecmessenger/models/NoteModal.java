package com.example.opsecmessenger.models;

import java.lang.ref.SoftReference;

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
