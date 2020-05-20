package com.example.booking.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "mail")
public class Mail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="auto_increment")
    @GenericGenerator(name = "auto_increment", strategy = "native")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
