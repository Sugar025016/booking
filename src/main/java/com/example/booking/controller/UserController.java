package com.example.booking.controller;

import com.example.booking.model.request.UserRequest;
import com.example.booking.model.response.UserResponse;
import com.example.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/user")
public class UserController {

    @Autowired
    UserService userServiceImpl;

    @RequestMapping(value="/a", method= RequestMethod.GET)
    public String get(){

        return "Hello Security";
    }
    @RequestMapping(value="/get", method= RequestMethod.GET)
    public UserResponse get(int id){
        return userServiceImpl.get(id);
    }

    @RequestMapping(value="/updata", method= RequestMethod.PUT)
    public String updata(@Validated @RequestBody UserRequest userRequest){
        userServiceImpl.updata(userRequest);
        return userServiceImpl.updata(userRequest);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String add(@Validated @RequestBody  UserRequest userRequest)throws Exception{

    return userServiceImpl.add(userRequest);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @RequestMapping(value="/account", method= RequestMethod.POST)
    public Boolean account(@RequestBody  String account)throws Exception{

        return userServiceImpl.account(account);
    }

}
