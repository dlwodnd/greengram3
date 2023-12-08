package com.green.greengram3.dm.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class DmMsgInsDto {
    private int idm;
    @JsonIgnore
    private int seq;
    private int loginedIuser;
    private String msg;
}