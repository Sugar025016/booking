package com.example.booking.model.response;

import com.example.booking.entity.Image;
import com.example.booking.entity.Mail;

public class ImageResponse {
    private int id;
    private String name;
    private String filePath;

    public void setMail(Image image) {
        this.id=image.getId();
        this.name=image.getName();
        this.filePath=image.getFilePath();
    }

    public int getId() {
        return id;
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
