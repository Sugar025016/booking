package com.example.booking.service;



import com.example.booking.model.request.BookingUpdataRequest;
import com.example.booking.model.request.MailUpdataRequest;
import com.example.booking.model.response.BookingResponse;
import com.example.booking.model.response.MailResponse;

public interface MailService {

    MailResponse get(int id);

    String add(MailUpdataRequest mailUpdataRequest);

    String updata(MailUpdataRequest mailUpdataRequest);

    String delete(int id);




}
