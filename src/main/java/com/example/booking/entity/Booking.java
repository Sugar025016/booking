package com.example.booking.entity;

import com.example.booking.model.request.BookingUpdataRequest;
import com.example.booking.model.request.UserRequest;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "booking")
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "auto_increment")
    @GenericGenerator(name = "auto_increment", strategy = "native")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "add_date")
    private java.util.Date addDate;
    @Column(name = "star_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
//        @ManyToOne(cascade = CascadeType.MERGE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detail_id")
    private Detail detail;
//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name="meeting_room_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_room_id",referencedColumnName="id")
    private MeetingRoom meetingRoom;


    //    public void set(BookingUpdataRequest bookingUpdataRequest) {
    public void set(BookingUpdataRequest bookingUpdataRequest, Detail detail, MeetingRoom meetingRoom) {
        this.name = bookingUpdataRequest.getName();
        Date startDate = new Date(bookingUpdataRequest.getStartDate().getTime());
        Date endDate = new Date(bookingUpdataRequest.getEndDate().getTime());
        this.startDate = startDate;
        this.endDate = endDate;
        this.detail=detail;
        this.meetingRoom=meetingRoom;

        Date date = new Date(new java.util.Date().getTime());
        this.addDate = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.Date getAddDate() {
        return addDate;
    }

    public void setAddDate(java.util.Date addDate) {
        this.addDate = addDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoom = meetingRoom;
    }
}

