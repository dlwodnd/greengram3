package com.green.greengram3.feed.models.vo;

import lombok.Data;

import java.util.List;

@Data
public class FeedSelVo {
    private int ifeed;
    private String contents;
    private String location;
    private String createdAt;
    private int writerIuser;
    private String writerNm;
    private String writerPic;
    private List<String> pics;
    private int isFav;
    private List<FeedCommentSelVo> comments;
    private int isMoreComment;
}
