package com.example.booking.controller;

import com.example.booking.model.request.MeetingRoomRequest;
import com.example.booking.model.response.MeetingRoomResponse;
import com.example.booking.service.Impl.MeetingRoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/meetingRoom")
public class MeetingRoomController {

    @Autowired
    MeetingRoomServiceImpl meetingRoomServiceImpl;

    @RequestMapping(value="/a", method= RequestMethod.GET)
    public String get(){

        return "Hello Security";
    }
    @RequestMapping(value="/get", method= RequestMethod.GET)
    public MeetingRoomResponse get(int id){
        MeetingRoomResponse bookingResponse= meetingRoomServiceImpl.get(id);
        return bookingResponse;
    }

    @RequestMapping(value="/updata", method= RequestMethod.PUT)
    public String updata(@Validated @RequestBody MeetingRoomRequest meetingRoomRequest){
        meetingRoomServiceImpl.updata(meetingRoomRequest);
        return meetingRoomServiceImpl.updata(meetingRoomRequest);
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String add(@Validated @RequestBody MeetingRoomRequest meetingRoomRequest){

//        SecurityProperties.User
    return meetingRoomServiceImpl.add(meetingRoomRequest);
    }

    @RequestMapping(value="/delete", method= RequestMethod.DELETE)
    public String delete(@RequestBody int id){
//        bookingService.delete(id);
////        SecurityProperties.User
        return meetingRoomServiceImpl.delete(id);
    }


}
