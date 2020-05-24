package com.example.booking.controller;

import com.example.booking.model.request.MailRequest;
import com.example.booking.model.response.MailResponse;
import com.example.booking.service.Impl.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/mail")
public class MailController {

    @Autowired
    MailServiceImpl mailServiceImpl;


    @RequestMapping(value="/get", method= RequestMethod.GET)
    public MailResponse get(int id){
        MailResponse mailResponse= mailServiceImpl.get(id);
        return mailResponse;
    }

    @RequestMapping(value="/updata", method= RequestMethod.PUT)
    public String updata(@Validated @RequestBody MailRequest mailRequest)throws Exception{

        return mailServiceImpl.updata(mailRequest);
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String add(@Validated @RequestBody MailRequest mailRequest){

//        SecurityProperties.User
    return mailServiceImpl.add(mailRequest);
    }

    @RequestMapping(value="/delete", method= RequestMethod.DELETE)
    public String delete( int id){
        return mailServiceImpl.delete(id);
    }


}
