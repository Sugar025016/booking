package com.example.booking.service.Impl;

import com.example.booking.entity.Booking;
import com.example.booking.entity.Detail;
import com.example.booking.entity.MeetingRoom;
import com.example.booking.entity.User;
import com.example.booking.model.request.BookingUpdataRequest;
import com.example.booking.model.response.BookingResponse;
import com.example.booking.repository.IBookingRepository;
import com.example.booking.repository.IDetailRepository;
import com.example.booking.repository.IMeetingRoomRepository;
import com.example.booking.repository.IUserRepository;
import com.example.booking.service.BookingService;
import com.mysql.cj.util.LogUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private IBookingRepository bookingRepository;
    @Autowired
    private IDetailRepository detailRepository;
    @Autowired
    private IMeetingRoomRepository meetingRoomRepository;

    @Autowired
    JavaMailSender mailSender;

    private static final Logger logger = LogManager.getLogger(LogUtils.class);

    public BookingResponse get(int id) {
        logger.info("BookingService_GetBooking");

        System.out.println("進入了UserService的getUserId方法");

        bookingRepository.getOne(id);
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBooking(bookingRepository.getOne(id));


        return bookingResponse;
    }

    public String add(BookingUpdataRequest bookingUpdataRequest) {
        logger.info("BookingService_addBooking");

        System.out.println("進入了UserService的add方法");


        Booking booking = new Booking();
        Detail detail = detailRepository.getOne(bookingUpdataRequest.getUserId());
        MeetingRoom room = meetingRoomRepository.getOne(bookingUpdataRequest.getRoomId());
        booking.set(bookingUpdataRequest, detail, room);
//        booking.set(bookingUpdataRequest);
        bookingRepository.save(booking);
        sendToGmail();

        return booking.getName() + "新增成功";
    }

    public String updata(BookingUpdataRequest bookingUpdataRequest) {
        logger.info("BookingService_updataBooking");
        System.out.println("進入了BookingService的updata方法");

        Booking booking = bookingRepository.getBookingById(bookingUpdataRequest.getId());
        if (booking.getId() == null) {
            throw new IllegalArgumentException("id不存在");
        }
        Detail detail = detailRepository.getOne(bookingUpdataRequest.getUserId());
        MeetingRoom room = meetingRoomRepository.getOne(bookingUpdataRequest.getRoomId());
        booking.set(bookingUpdataRequest, detail, room);
        bookingRepository.save(booking);

        return booking.getName() + "更新成功";
    }

    public String delete(int id) {
        logger.info("BookingService_deleteBooking");
        System.out.println("進入了BookingService的updata方法");

        Booking booking = bookingRepository.getBookingById(id);
        if (booking != null)
            bookingRepository.delete(booking);


        return "刪除成功";
    }

    void sendToGmail() {
        logger.info("send_mail");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("springtestmail1111@gmail.com");
        message.setTo("<sugar025016@gmail.com>");
        message.setSubject("測試透過 Gmail 去發信");
        message.setText("org.springframework.Mail.SimpleMailMessage 透過 Gmail 發信。");

        try {
            mailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
        }


    }
}

