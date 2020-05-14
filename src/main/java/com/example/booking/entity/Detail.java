package com.example.booking.entity;

import com.example.booking.model.request.UserRequest;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * detail表
 **/
@Entity
@Table(name = "detail")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "auto_increment")
    @GenericGenerator(name = "auto_increment", strategy = "native")
    private int Id;
    @Column(name = "name")
    private String name;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "number")
    private String number;
    @Column(name = "email")
    private String email;
    @OneToOne(mappedBy = "detail")
    private User user;
//    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "booking",fetch=FetchType.LAZY)
    @OneToMany(mappedBy="detail", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<Booking> bookings;
    //omit gets and sets


    public void add(UserRequest userRequest) {

        java.sql.Date sqlDate = new java.sql.Date(userRequest.getBirthday().getTime());
        this.setBirthday(sqlDate);
        this.setEmail(userRequest.getEmail());
        this.setName(userRequest.getName());
        this.setNumber(userRequest.getNumber());
    }

    public void set(UserRequest userRequest) {
        java.sql.Date sqlDate = new java.sql.Date(userRequest.getBirthday().getTime());
        this.setBirthday(sqlDate);
        this.setEmail(userRequest.getEmail());
        this.setName(userRequest.getName());
        this.setNumber(userRequest.getNumber());
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
