package com.green.greengram3.feed.mappers;

import com.green.greengram3.feed.models.dto.FeedDelDto;
import com.green.greengram3.feed.models.dto.FeedInsDto;
import com.green.greengram3.feed.models.dto.FeedSelDto;

import com.green.greengram3.feed.models.vo.FeedSelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMaeppr {

    int postingFeed (FeedInsDto dto);
    List<FeedSelVo> selFeed (FeedSelDto dto);
    int delFeed(FeedDelDto dto);
    int checkFeedIuser(FeedDelDto dto);
    int feedFavCommentPicsAll(FeedDelDto dto);

}
