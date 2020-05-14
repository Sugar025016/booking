package com.example.booking.model.response;

import com.example.booking.entity.MeetingRoom;

public class MeetingRoomResponse {
    private int id;
    private String name;
    private int size;

    public void setBooking(MeetingRoom meetingRoom) {
        this.id=meetingRoom.getId();
        this.name=meetingRoom.getName();
        this.size=meetingRoom.getSize();
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
