package com.example.booking.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class BookingUpdataRequest {
    private Integer id;
    @NotEmpty(message = "name不能為空")
    private String name;
    @Future
    @NotNull(message = "startDate不能為空")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date startDate;
    @Future
    @NotNull(message = "endDate不能為空")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date endDate;
    @NotNull(message = "roomId不能為空")
    private int roomId;
    @NotNull(message = "userId不能為空")
    private int userId;

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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
