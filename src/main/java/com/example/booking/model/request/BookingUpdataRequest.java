package com.example.booking.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class BookingUpdataRequest {
    private Integer id;
    @NotEmpty(message = "name不能為空")
    private String name;
    @Future
    @NotEmpty(message = "startDate不能為空")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date startDate;
    @Future
    @NotEmpty(message = "endDate不能為空")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date endDate;
    @NotNull(message = "roomId不能為空")
    private Integer roomId;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
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
}
