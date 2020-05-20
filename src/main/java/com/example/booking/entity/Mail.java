package com.example.booking.entity;

import com.example.booking.model.request.MailUpdataRequest;
import com.example.booking.model.request.UserRequest;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

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
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="user_mail",joinColumns= {@JoinColumn(name="mail_id")},inverseJoinColumns= {@JoinColumn(name="user_id")})
    private List<User> users;


    public void set(MailUpdataRequest mailUpdataRequest) {
        this.setTitle(mailUpdataRequest.getTitle());
        this.setContent(mailUpdataRequest.getContent());
    }
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

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
