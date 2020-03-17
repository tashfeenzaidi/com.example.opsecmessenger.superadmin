package com.example.opsecmessenger.models;

public class ResellerModel {

    int keys, tokens, resellers,chatUsers;
    String name;
    String picUrl;


    public ResellerModel(int keys, int tokens, int resellers, int chatUsers, String name, String picUrl) {
        this.keys = keys;
        this.tokens = tokens;
        this.resellers = resellers;
        this.chatUsers = chatUsers;
        this.name = name;
        this.picUrl = picUrl;
    }

    public int getKeys() {
        return keys;
    }

    public int getTokens() {
        return tokens;
    }

    public int getResellers() {
        return resellers;
    }

    public int getChatUsers() {
        return chatUsers;
    }

    public String getName() {
        return name;
    }

    public String getPicUrl() {
        return picUrl;
    }
}