package com.green.greengram3.feed.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;
@Data
public class FeedInsDto {
    @JsonIgnore
    private int ifeed;
    private int iuser;
    private String contents;
    private String location;
    private List<String> pics;
}
