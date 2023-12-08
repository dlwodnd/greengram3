package com.green.greengram3.feed.mappers;

import com.green.greengram3.feed.models.dto.FeedDelDto;
import com.green.greengram3.feed.models.dto.FeedFavDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedFavMapper {
    int delFeedFav(FeedFavDto dto);
    int insFeedFav(FeedFavDto dto);

}
