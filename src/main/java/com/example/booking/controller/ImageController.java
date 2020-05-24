package com.example.booking.controller;

import com.example.booking.entity.Mail;
import com.example.booking.model.request.ImageRequest;
import com.example.booking.model.response.ImageResponse;
import com.example.booking.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/image")
public class ImageController {

    @Autowired
    ImageService imageServiceImpl;


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ImageResponse get(int id) {
        ImageResponse imageResponse = imageServiceImpl.get(id);
        return imageResponse;
    }

    @RequestMapping(value = "/file", method = RequestMethod.GET)
    public String file() {
        return "file";
    }

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String fileUpload(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            System.out.println("文件為空空");
        }

        return imageServiceImpl.add(file);


    }

    @RequestMapping(value="/updata", method= RequestMethod.POST)
    public String update(@RequestParam(value = "file") MultipartFile file,int id,String name){
        ImageRequest imageRequest = new ImageRequest();
        imageRequest.setId(id);
        imageRequest.setName(name);
//        SecurityProperties.User
    return imageServiceImpl.updata(file,imageRequest);
    }

    @RequestMapping(value="/delete", method= RequestMethod.DELETE)
    public String delete( int id){
        return imageServiceImpl.delete(id);
    }


}
