package com.example.booking.service.Impl;

import com.example.booking.entity.MeetingRoom;
import com.example.booking.entity.User;
import com.example.booking.model.request.MeetingRoomRequest;
import com.example.booking.model.response.ImageResponse;
import com.example.booking.model.response.MeetingRoomResponse;
import com.example.booking.repository.IMeetingRoomRepository;
import com.example.booking.service.MeetingRoomService;
import com.mysql.cj.util.LogUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MeetingRoomServiceImpl implements MeetingRoomService {
    @Autowired
    private IMeetingRoomRepository meetingRoomRepository;

    private static final Logger logger = LogManager.getLogger(LogUtils.class);


    public MeetingRoomResponse get(int id) {
        logger.info("MeetingService_GetMeeting");
        meetingRoomRepository.getOne(id);
        MeetingRoomResponse meetingRoomResponse = new MeetingRoomResponse();
        meetingRoomResponse.setBooking(meetingRoomRepository.getOne(id));

        return meetingRoomResponse;
    }

    public String add(MeetingRoomRequest meetingRoomRequest) {

        logger.info("MeetingService_addMeeting");

        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.add(meetingRoomRequest);

        meetingRoomRepository.save(meetingRoom);
        System.out.println("meetingRoomRepository");

        return meetingRoom.getName()+"新增成功";
    }

    public String updata(MeetingRoomRequest meetingRoomRequest) {

        logger.info("MeetingService_updataMeeting");
        MeetingRoom meetingRoom = meetingRoomRepository.getOne(meetingRoomRequest.getId());


        meetingRoom.updata(meetingRoomRequest);
        meetingRoomRepository.save(meetingRoom);

        return "更新成功";
    }

    public String delete(int id) {

        logger.info("MeetingService_deleteMeeting");

        MeetingRoom meetingRoom = meetingRoomRepository.getOne(id);
        if (meetingRoom != null)
            meetingRoomRepository.delete(meetingRoom);


        return "刪除成功";
    }
}

