package com.example.booking.repository;

import com.example.booking.entity.Image;
import com.example.booking.entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IImageRepository extends JpaRepository<Image, Integer> {

    @Override
    Image getOne(Integer id);


    Optional<Image> getMailById(Integer id);


}
