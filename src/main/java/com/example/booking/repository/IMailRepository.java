package com.example.booking.repository;

import com.example.booking.entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMailRepository extends JpaRepository<Mail, Integer> {

    @Override
    Mail getOne(Integer id);


    Mail getMailById(Integer id);


}
