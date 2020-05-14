package com.example.booking.service.Impl;

import com.example.booking.entity.MeetingRoom;
import com.example.booking.entity.User;
import com.example.booking.model.request.MeetingRoomRequest;
import com.example.booking.model.response.MeetingRoomResponse;
import com.example.booking.repository.IMeetingRoomRepository;
import com.example.booking.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MeetingRoomServiceImpl implements MeetingRoomService {
    @Autowired
    private IMeetingRoomRepository meetingRoomRepository;


    public MeetingRoomResponse get(int id) {
        System.out.println("進入了UserService的getUserId方法");
        int userId = 5;
        meetingRoomRepository.getOne(id);
        MeetingRoomResponse meetingRoomResponse = new MeetingRoomResponse();
        meetingRoomResponse.setBooking(meetingRoomRepository.getOne(id));

        return meetingRoomResponse;
    }

    public String add(MeetingRoomRequest meetingRoomRequest) {
        System.out.println("進入了meetingRoomService的add方法");

        User user = new User();
        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.add(meetingRoomRequest);

        meetingRoomRepository.save(meetingRoom);
        System.out.println("meetingRoomRepository");

        return meetingRoom.getName()+"新增成功";
    }

    public String updata(MeetingRoomRequest meetingRoomRequest) {

        System.out.println("進入了BookingService的updata方法");
        MeetingRoom meetingRoom = meetingRoomRepository.getOne(meetingRoomRequest.getId());


        meetingRoom.updata(meetingRoomRequest);
        meetingRoomRepository.save(meetingRoom);

        return "更新成功";
    }

    public String delete(int id) {

        System.out.println("進入了BookingService的updata方法");

        MeetingRoom meetingRoom = meetingRoomRepository.getOne(id);
        if (meetingRoom != null)
            meetingRoomRepository.delete(meetingRoom);


        return "刪除成功";
    }
}

