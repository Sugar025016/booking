package com.example.booking.service.Impl;

import com.example.booking.entity.Booking;
import com.example.booking.entity.Detail;
import com.example.booking.entity.Mail;
import com.example.booking.entity.MeetingRoom;
import com.example.booking.model.request.BookingUpdataRequest;
import com.example.booking.model.request.MailUpdataRequest;
import com.example.booking.model.response.BookingResponse;
import com.example.booking.model.response.MailResponse;
import com.example.booking.repository.*;
import com.example.booking.service.BookingService;
import com.example.booking.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MailServiceImpl implements MailService {
    @Autowired
    private IBookingRepository bookingRepository;
    @Autowired
    private IDetailRepository detailRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IMeetingRoomRepository meetingRoomRepository;
    @Autowired
    private IMailRepository mailRepository;

    @Autowired
    JavaMailSender mailSender;

    public MailResponse get(int id) {
        System.out.println("進入了UserService的getUserId方法");

        bookingRepository.getOne(id);
        MailResponse mailResponse = new MailResponse();
        mailResponse.setMail(mailRepository.getOne(id));

        return mailResponse;
    }

    public String add(MailUpdataRequest mailUpdataRequest) {

        Mail mail = new Mail();
        mail.set(mailUpdataRequest);
        mailRepository.save(mail);

        return mail.getTitle() + "新增成功";
    }

    public String updata(MailUpdataRequest mailUpdataRequest) {

        Mail mail= mailRepository.getMailById(mailUpdataRequest.getId());
        if (mail.getId() == null) {
            throw new IllegalArgumentException("id不存在");
        }
        mail.set(mailUpdataRequest);
//        booking.set(bookingUpdataRequest);
        mailRepository.save(mail);

        return mail.getTitle() + "更新成功";
    }

    public String delete(int id) {

        Mail mail = mailRepository.getOne(id);
        if (mail != null)
            mailRepository.delete(mail);


        return "刪除成功";
    }


}

