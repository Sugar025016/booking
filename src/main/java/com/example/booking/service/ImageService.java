package com.example.booking.service;



import com.example.booking.model.request.ImageRequest;
import com.example.booking.model.response.ImageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface ImageService {

    ImageResponse get(int id);

    String add(MultipartFile file);

    String updata(MultipartFile file, ImageRequest imageRequest);

    String delete(int id);




}
