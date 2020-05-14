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
    @Column(name = "room_id")
    private int roomId;
    @Column(name = "add_date")
    private Date addDate;
    @Column(name = "star_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    //    @ManyToOne(cascade = CascadeType.MERGE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detail_id")
    private Detail detail;
//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name="meeting_room_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_room_id",referencedColumnName="id")
    private MeetingRoom meetingRoom;


    public void set(BookingUpdataRequest bookingUpdataRequest) {
        this.name = bookingUpdataRequest.getName();
        this.startDate = bookingUpdataRequest.getStartDate();
        this.endDate = bookingUpdataRequest.getEndDate();
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}

