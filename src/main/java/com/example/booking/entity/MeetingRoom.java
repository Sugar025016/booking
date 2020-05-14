package com.example.booking.entity;

import com.example.booking.model.request.MeetingRoomRequest;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "meeting_room")
public class MeetingRoom implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="auto_increment")
    @GenericGenerator(name = "auto_increment", strategy = "native")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "size")
    private int size;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public void updata(MeetingRoomRequest meetingRoomRequest) {
        this.name = meetingRoomRequest.getName();
        this.size = meetingRoomRequest.getSize();
    }
    public void add(MeetingRoomRequest meetingRoomRequest) {
        this.name = meetingRoomRequest.getName();
        this.size = meetingRoomRequest.getSize();
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


}

