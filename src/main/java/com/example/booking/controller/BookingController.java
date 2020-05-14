package com.example.booking.controller;

import com.example.booking.model.request.BookingUpdataRequest;
import com.example.booking.model.response.BookingResponse;
import com.example.booking.service.Impl.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/booking")
public class BookingController {

    @Autowired
    BookingServiceImpl bookingServiceImpl;

    @RequestMapping(value="/a", method= RequestMethod.GET)
    public String get(){

        return "Hello Security";
    }
    @RequestMapping(value="/get", method= RequestMethod.GET)
    public BookingResponse get(int id){
        BookingResponse bookingResponse= bookingServiceImpl.get(id);
        return bookingResponse;
    }

    @RequestMapping(value="/updata", method= RequestMethod.PUT)
    public String updata(@Validated @RequestBody BookingUpdataRequest bookingUpdataRequest)throws Exception{
        bookingServiceImpl.updata(bookingUpdataRequest);
        return bookingServiceImpl.updata(bookingUpdataRequest);
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String add(@Validated @RequestBody BookingUpdataRequest bookingUpdataRequest){

//        SecurityProperties.User
    return bookingServiceImpl.add(bookingUpdataRequest);
    }

    @RequestMapping(value="/delete", method= RequestMethod.DELETE)
    public String delete(@RequestBody int id){
        return bookingServiceImpl.delete(id);
    }


}
