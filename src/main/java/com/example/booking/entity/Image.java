package com.example.booking.entity;

import com.example.booking.model.request.MailRequest;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="auto_increment")
    @GenericGenerator(name = "auto_increment", strategy = "native")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "filePath")
    private String filePath;
    @Column(name = "fileNewName")
    private String fileNewName;

    public void set(String fileName,String filePath,String fileNewName) {
        this.name=fileName;
        this.filePath=filePath+fileNewName;
        this.fileNewName=fileNewName;
    }

    public String getFileNewName() {
        return fileNewName;
    }

    public void setFileNewName(String fileNewName) {
        this.fileNewName = fileNewName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
