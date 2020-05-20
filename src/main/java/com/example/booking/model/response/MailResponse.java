package com.example.booking.model.response;

import com.example.booking.entity.Booking;
import com.example.booking.entity.Mail;

import java.sql.Date;

public class MailResponse {
    private int id;
    private String title;
    private String content;

    public void setMail(Mail mail) {
        this.id=mail.getId();
        this.title=mail.getTitle();
        this.content=mail.getContent();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
