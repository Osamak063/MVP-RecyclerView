package com.example.osamakhalid.mvprecyclerview.model;

/**
 * Created by Osama Khalid on 12/19/2018.
 */

public class User {
    int photoId;
    String name,email;

    public User(int photoId, String name, String email) {
        this.photoId = photoId;
        this.name = name;
        this.email = email;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
