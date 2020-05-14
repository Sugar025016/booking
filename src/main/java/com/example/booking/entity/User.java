package com.example.booking.entity;

import com.example.booking.model.request.UserRequest;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {
//    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="auto_increment")
    @GenericGenerator(name = "auto_increment", strategy = "native")
    private Integer id;
    @Column(name = "account")
    private String account;
    @Column(name = "password")
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id", referencedColumnName = "id")
    private Detail detail;


    public void set(UserRequest userRequest,Detail detail) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        this.account = userRequest.getAccount();
        this.password = encoder.encode(userRequest.getPassword());
//        this.password = userRequest.getPassword();
        this.setDetail(detail);
    }

    public void updata(UserRequest userRequest,Detail detail) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        this.account = userRequest.getAccount();
        this.password = encoder.encode(userRequest.getPassword());
//        this.password = userRequest.getPassword();
        this.setDetail(detail);
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

//omit gets and sets
}

