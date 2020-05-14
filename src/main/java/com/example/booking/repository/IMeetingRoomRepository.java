package com.example.booking.repository;

import com.example.booking.entity.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMeetingRoomRepository extends JpaRepository<MeetingRoom,Integer> {

    @Override
    public MeetingRoom getOne(Integer id);


}
