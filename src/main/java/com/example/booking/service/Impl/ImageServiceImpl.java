package com.example.booking.service.Impl;

import com.example.booking.entity.Image;
import com.example.booking.entity.Mail;
import com.example.booking.model.request.ImageRequest;
import com.example.booking.model.response.BookingResponse;
import com.example.booking.model.response.ImageResponse;
import com.example.booking.repository.*;
import com.example.booking.service.ImageService;
import com.mysql.cj.util.LogUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;


@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    private IImageRepository imageRepository;

    private static final Logger logger = LogManager.getLogger(LogUtils.class);



    public ImageResponse get(int id) {

        logger.info("ImageService_GetImage");

        imageRepository.getOne(id);
        ImageResponse imageResponse = new ImageResponse();
        imageResponse.setMail(imageRepository.getOne(id));

        return imageResponse;
    }

    public String add(MultipartFile file) {
        logger.info("ImageService_AddImage");
        String fileName = file.getOriginalFilename();// 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));// 後綴名
        String fileNewName = UUID.randomUUID() + suffixName; //  新文件名
        addImage(file,fileNewName);

        Image image = new Image();
        String nginxFath="http://localhost:8088/upload/";
        image.set( fileName, nginxFath,fileNewName);
        imageRepository.save(image);

        return fileName + "新增成功";
    }

    public String updata(MultipartFile file,ImageRequest imageRequest) {
        logger.info("ImageService_UpdataImage");
        Optional<Image> optional = imageRepository.getMailById(imageRequest.getId());
        if (optional.isEmpty())
            throw new IllegalArgumentException("id不存在");
        Image image= optional.get();


        if (file.isEmpty()) {
            image.setName(imageRequest.getName());
        }else {
            deleteImage(image);
            String fileName = file.getOriginalFilename();// 文件名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));// 後綴名
            String fileNewName = UUID.randomUUID() + suffixName; //  新文件名
            addImage(file,fileNewName);
            String nginxFath="http://localhost:8088/upload/";
            image.set( fileName, nginxFath,fileNewName);
            imageRepository.save(image);
        }

//        booking.set(bookingUpdataRequest);
        imageRepository.save(image);

        return image.getName() + "更新成功";
    }


    public String delete(int id) {
        logger.info("ImageService_DeleteImage");
        Optional<Image> optional = imageRepository.getMailById(id);
        if (optional.isEmpty())
            return "找步道圖片";
        Image image= optional.get();
        deleteImage(image);
        imageRepository.delete(image);
        return "刪除成功";
    }


    public void addImage(MultipartFile file,String fileNewName) {
        logger.info("add_Image");

        String filePath = "D://images//";// 上傳後的路徑
        File dest = new File(filePath + fileNewName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public String deleteImage(Image image) {
        logger.info("delete_Image");
        try {
            String filePath = "D://images//";
            File file = new File(filePath+image.getFileNewName());

            if (file.delete()) {
                System.out.println(file.getName() + "is deleted");
            } else {
                System.out.println("Delete failed.");
            }
        } catch (Exception e) {
            System.out.println("Exception occured");
            e.printStackTrace();
        }



        return "刪除成功";
    }


}

