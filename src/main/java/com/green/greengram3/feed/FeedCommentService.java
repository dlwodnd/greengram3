package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.mappers.FeedCommentMapper;
import com.green.greengram3.feed.models.dto.FeedCommentInsDto;
import com.green.greengram3.feed.models.dto.FeedCommentSelDto;
import com.green.greengram3.feed.models.dto.FeedDelCommentDto;
import com.green.greengram3.feed.models.vo.FeedCommentSelVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedCommentService {
    private final FeedCommentMapper COMMENT_MAPPER;
    public ResVo insFeedComment(FeedCommentInsDto dto){
        COMMENT_MAPPER.insFeedComment(dto);
        return new ResVo(dto.getIfeedComment());
    }
    public List<FeedCommentSelVo> feedCommentSelAll(FeedCommentSelDto dto){
        return COMMENT_MAPPER.selFeedCommentAll(dto);
    }
    public ResVo feedDelComment(FeedDelCommentDto dto){
        int result = COMMENT_MAPPER.delFeedCommnet(dto);
        return new ResVo(result);
    }
}
