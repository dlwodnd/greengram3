package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.models.dto.FeedCommentInsDto;
import com.green.greengram3.feed.models.dto.FeedCommentSelDto;
import com.green.greengram3.feed.models.dto.FeedDelCommentDto;
import com.green.greengram3.feed.models.vo.FeedCommentSelVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed/comment")
public class FeedCommentController {
    private final FeedCommentService COMMENT_SERVICE;

    @PostMapping
    public ResVo insFeedComment(@RequestBody FeedCommentInsDto dto){
        return COMMENT_SERVICE.insFeedComment(dto);
    }
    @GetMapping
    public List<FeedCommentSelVo> feedCommentList(int ifeed){
        FeedCommentSelDto dto = new FeedCommentSelDto();
        /*dto.setIfeedList(new ArrayList<>());
        dto.getIfeedList().add(ifeed);*/
        dto.setIfeed(ifeed);
        dto.setStartIdx(3);
        dto.setRowCount(99999);
        return COMMENT_SERVICE.feedCommentSelAll(dto);
    }
    @DeleteMapping
    public ResVo feedDelComment(FeedDelCommentDto dto){
        return COMMENT_SERVICE.feedDelComment(dto);
    }
}
