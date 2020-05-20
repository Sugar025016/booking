package com.example.booking.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MeetingRoomRequest {
    private int id;
    @NotEmpty(message = "name不能為空")
    private String name;
    @NotNull(message = "size不能為空")
    private int size;


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
