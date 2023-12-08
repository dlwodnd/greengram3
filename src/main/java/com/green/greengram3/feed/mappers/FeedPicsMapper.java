package com.green.greengram3.feed.mappers;

import com.green.greengram3.feed.models.dto.FeedDelDto;
import com.green.greengram3.feed.models.dto.FeedInsDto;
import com.green.greengram3.feed.models.vo.FeedIfeedByPicsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedPicsMapper {
    int postingFeedPics (FeedInsDto dto);
    List<String> selFeedPics(int ifeed);
    List<FeedIfeedByPicsVo> selIfeedByPics(List<Integer> ifeedList);

}
