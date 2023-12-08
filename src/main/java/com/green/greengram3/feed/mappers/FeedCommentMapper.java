package com.green.greengram3.feed.mappers;

import com.green.greengram3.feed.models.dto.FeedCommentInsDto;
import com.green.greengram3.feed.models.dto.FeedCommentSelDto;
import com.green.greengram3.feed.models.dto.FeedDelCommentDto;
import com.green.greengram3.feed.models.dto.FeedDelDto;
import com.green.greengram3.feed.models.vo.FeedCommentSelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedCommentMapper {
    int insFeedComment (FeedCommentInsDto dto);

    List<FeedCommentSelVo> selFeedCommentAll(FeedCommentSelDto dto);

    int delFeedCommnet(FeedDelCommentDto dto);


}
