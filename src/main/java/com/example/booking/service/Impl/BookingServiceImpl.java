package com.example.booking.service.Impl;

import com.example.booking.conf.ContextHolderHandler;
import com.example.booking.entity.Booking;
import com.example.booking.entity.Detail;
import com.example.booking.entity.User;
import com.example.booking.model.request.BookingUpdataRequest;
import com.example.booking.model.request.UserRequest;
import com.example.booking.model.response.BookingResponse;
import com.example.booking.repository.IBookingRepository;
import com.example.booking.repository.IDetailRepository;
import com.example.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    @Autowired
    private IBookingRepository bookingRepository;
    @Autowired
    private IDetailRepository detailRepository;



    public BookingResponse get(int id) {
        System.out.println("進入了UserService的getUserId方法");

        bookingRepository.getOne(id);
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBooking(bookingRepository.getOne(id));

        return bookingResponse;
    }

    public String add(BookingUpdataRequest bookingUpdataRequest) {
        System.out.println("進入了UserService的add方法");


        Booking booking = new Booking();
        booking.set(bookingUpdataRequest);
        bookingRepository.save(booking);


        return booking.getName() + "新增成功";
    }

    public String updata(BookingUpdataRequest bookingUpdataRequest) {

        System.out.println("進入了BookingService的updata方法");

        Booking booking = bookingRepository.getOne(bookingUpdataRequest.getId());
        if (booking.getId() != null) {
            throw new IllegalArgumentException("id不存在");
        }

        booking.set(bookingUpdataRequest);
        bookingRepository.save(booking);

        return booking.getName() + "更新成功";
    }

    public String delete(int id) {

        System.out.println("進入了BookingService的updata方法");

        Booking booking = bookingRepository.getOne(id);
        if (booking != null)
            bookingRepository.delete(booking);


        return "刪除成功";
    }
}

