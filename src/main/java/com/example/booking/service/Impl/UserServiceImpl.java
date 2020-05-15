package com.example.booking.service.Impl;

import com.example.booking.conf.ContextHolderHandler;
import com.example.booking.entity.Detail;
import com.example.booking.entity.User;
import com.example.booking.model.request.UserRequest;
import com.example.booking.model.response.UserResponse;
import com.example.booking.repository.IDetailRepository;
import com.example.booking.repository.IUserRepository;
import com.example.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IDetailRepository detailRepository;

    public UserResponse get(int id) {
        UserResponse userResponse = new UserResponse();
        String Cid = ContextHolderHandler.getName();
        System.out.println("account:" + Cid);
        Optional<User> byAccount = userRepository.findByAccount(Cid);
        if (byAccount.isPresent()) {
            User user = byAccount.get();
            if (user.getId() == id) {
                userResponse.setUser(user);
            } else {
                throw new IllegalArgumentException("輸入錯誤");
            }
        } else {
            throw new IllegalArgumentException("帳號有誤請從新登入");
        }


        return userResponse;
    }

    public String add(UserRequest userRequest) {

        String Cid = ContextHolderHandler.getName();
        Optional<User> byAccount = userRepository.findByAccount(Cid);
        if (byAccount.isPresent())
            throw new IllegalArgumentException("你已經登入");
        System.out.println("進入了UserService的add方法");
        User user = new User();
        Detail detail = new Detail();
        detail.add(userRequest);
        if (userRepository.existsByAccount(userRequest.getAccount())) {
            throw new IllegalArgumentException("帳號重複");
        }
        System.out.println(userRequest.getAccount());
        System.out.println(detail.getBirthday());
        detailRepository.save(detail);
        System.out.println("detail");

        user.set(userRequest, detail);
        userRepository.save(user);
        return detail.getName() + "新增成功";
    }

    public String updata(UserRequest userRequest) {

        System.out.println("進入了UserService的add方法");
        User user = userRepository.getOne(userRequest.getId());

        Detail detail = user.getDetail();
        detail.set(userRequest);
        user.updata(userRequest, detail);
        userRepository.save(user);
        return detail.getName() + "修改成功";
    }

    public Boolean account(String account) {

        return userRepository.existsByAccount(account);
    }
}

