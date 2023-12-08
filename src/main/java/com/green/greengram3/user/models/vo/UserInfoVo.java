package com.green.greengram3.user.models.vo;

import lombok.Data;

@Data
public class UserInfoVo {
    private int feedCnt;//작성한 총 게시글
    private int favCnt;//받은 총 좋아요 수
    private String nm;
    private String createdAt;//가입날짜
    private String pic;
    private int follower;
    private int following;
    private int followState;
    //1 - loginedIuser 가 targetIuser를 팔로우한 상황
    //2 - targetIuser가 loginedIuser를 팔로우한 상황
    //3 - 둘다 팔로우 한 상황
}
