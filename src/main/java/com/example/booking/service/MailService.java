package com.example.booking.service;



import com.example.booking.model.request.MailRequest;
import com.example.booking.model.response.MailResponse;

public interface MailService {

    MailResponse get(int id);

    String add(MailRequest mailRequest);

    String updata(MailRequest mailRequest);

    String delete(int id);




}
