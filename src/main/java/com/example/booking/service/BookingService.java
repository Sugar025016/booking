package com.example.booking.service;



import com.example.booking.model.request.BookingUpdataRequest;
import com.example.booking.model.request.MeetingRoomRequest;
import com.example.booking.model.response.BookingResponse;
import com.example.booking.model.response.MeetingRoomResponse;

public interface BookingService {

    BookingResponse get(int id);

    String add(BookingUpdataRequest bookingUpdataRequest);

    String updata(BookingUpdataRequest bookingUpdataRequest);

    String delete(int id);




}
