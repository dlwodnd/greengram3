package com.green.greengram3.feed;

import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.models.dto.FeedDelDto;
import com.green.greengram3.feed.models.dto.FeedFavDto;
import com.green.greengram3.feed.models.dto.FeedInsDto;
import com.green.greengram3.feed.models.dto.FeedSelDto;
import com.green.greengram3.feed.models.vo.FeedSelVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/feed")
@Tag(name = "피드API",description = "피드 관련 처리")
public class FeedController {
    private final FeedService SERVICE;

    @PostMapping
    public ResVo insFeed(@RequestBody FeedInsDto dto){
        return SERVICE.postFeed(dto);
    }
    @GetMapping
    public List<FeedSelVo> selFeeds(FeedSelDto dto){
        log.info("dto {}",dto);
        return SERVICE.selFeed(dto);
    }
    @GetMapping("/fav")
    public ResVo toggleFeedFav (FeedFavDto dto){
        return SERVICE.toggleFeedFav(dto);
    }
    @DeleteMapping
    public ResVo delFeed(FeedDelDto dto){
        log.info("dto : {} ", dto);
        return SERVICE.delFeed(dto);
    }



}
