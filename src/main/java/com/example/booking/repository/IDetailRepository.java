package com.example.booking.repository;

import com.example.booking.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetailRepository extends JpaRepository<Detail,Integer> {

    @Override
    public Detail getOne(Integer id);

}
