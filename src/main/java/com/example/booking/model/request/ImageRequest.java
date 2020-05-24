package com.example.booking.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ImageRequest {
    private Integer id;
    @NotEmpty(message = "name不能為空")
    private String name;

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
}
