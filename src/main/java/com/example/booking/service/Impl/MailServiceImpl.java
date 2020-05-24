package com.example.booking.service.Impl;

import com.example.booking.entity.Mail;
import com.example.booking.model.request.MailRequest;
import com.example.booking.model.response.MailResponse;
import com.example.booking.repository.*;
import com.example.booking.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
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

    public String add(MailRequest mailRequest) {

        Mail mail = new Mail();
        mail.set(mailRequest);
        mailRepository.save(mail);

        return mail.getTitle() + "新增成功";
    }

    public String updata(MailRequest mailRequest) {

        Mail mail= mailRepository.getMailById(mailRequest.getId());
        if (mail.getId() == null) {
            throw new IllegalArgumentException("id不存在");
        }
        mail.set(mailRequest);
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

