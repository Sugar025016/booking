package com.example.booking.model.response;

import com.example.booking.entity.Booking;

import java.sql.Date;

public class BookingResponse {
    private int bookingId;
    private String bookingName;
    private Date bookingStartDate;
    private Date bookingEndDate;

    public void setBooking(Booking booking) {
        this.bookingId=booking.getId();
        this.bookingName=booking.getName();
        this.bookingStartDate=booking.getStartDate();
        this.bookingEndDate=booking.getEndDate();
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }


    public int getBookingId() {
        return bookingId;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public Date getBookingStartDate() {
        return bookingStartDate;
    }

    public void setBookingStartDate(Date bookingStartDate) {
        this.bookingStartDate = bookingStartDate;
    }



    public Date getBookingEndDate() {
        return bookingEndDate;
    }

    public void setBookingEndDate(Date bookingEndDate) {
        this.bookingEndDate = bookingEndDate;
    }
}
