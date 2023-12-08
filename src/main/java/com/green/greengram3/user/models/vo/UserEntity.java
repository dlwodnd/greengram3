package com.green.greengram3.user.models.vo;

import lombok.Data;

@Data
public class UserEntity {
    private int result;
    private int iuser;
    private String upw;
    private String nm;
    private String pic;
    private String createdAt;
    private String updatedAt;
}
