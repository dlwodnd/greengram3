package com.green.greengram3.feed;

import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.mappers.FeedCommentMapper;
import com.green.greengram3.feed.mappers.FeedFavMapper;
import com.green.greengram3.feed.mappers.FeedMaeppr;
import com.green.greengram3.feed.mappers.FeedPicsMapper;
import com.green.greengram3.feed.models.dto.*;

import com.green.greengram3.feed.models.vo.FeedCommentSelVo;
import com.green.greengram3.feed.models.vo.FeedIfeedByPicsVo;
import com.green.greengram3.feed.models.vo.FeedSelVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class FeedService {
    private final FeedMaeppr MAPPER;
    private final FeedPicsMapper PIC_MAPPER;
    private final FeedFavMapper FAV_MAPPER;
    private final FeedCommentMapper COMMENT_MAPPER;

    public ResVo postFeed (FeedInsDto dto){
        if(dto.getPics().size() == 0){
            return new ResVo(0);
        }
        int feedAffectedRow = MAPPER.postingFeed(dto);
        int feedPicsAffectedRow = PIC_MAPPER.postingFeedPics(dto);
        return new ResVo(dto.getIfeed());
    }
    public List<FeedSelVo> selFeed(FeedSelDto dto){
        log.info("serviceDto : {}",dto);
        List<FeedSelVo> voList = MAPPER.selFeed(dto);
        FeedCommentSelDto fcDto = new FeedCommentSelDto();
        fcDto.setStartIdx(0);
        fcDto.setRowCount(Const.FEED_COMMENT_FIRST_CNT);
        for(FeedSelVo vo : voList){
            List<String> picList = PIC_MAPPER.selFeedPics(vo.getIfeed());
            vo.setPics(picList);


            fcDto.setIfeed(vo.getIfeed());
            List<FeedCommentSelVo> commentList = COMMENT_MAPPER.selFeedCommentAll(fcDto);
            if(commentList.size() == Const.FEED_COMMENT_FIRST_CNT){
                vo.setIsMoreComment(1);
                commentList.remove(3);
            }
            vo.setComments(commentList);
        }
        return voList;
    }
    public List<FeedSelVo> selFeed1(FeedSelDto dto){
        List<FeedSelVo> voList = MAPPER.selFeed(dto);
        List<Integer> ifeedList = new ArrayList<>();
        Map<Integer,FeedSelVo> feedMap = new HashMap<>();
        for(FeedSelVo vo : voList){
            ifeedList.add(vo.getIfeed());
            feedMap.put(vo.getIfeed(),vo);
        }
        if(ifeedList.size() > 0){
            List<FeedIfeedByPicsVo> ifeedByPicsVoList  = PIC_MAPPER.selIfeedByPics(ifeedList);
            for(FeedIfeedByPicsVo picsVo : ifeedByPicsVoList){
                FeedSelVo vo = feedMap.get(picsVo.getIfeed());
                if(vo.getPics() == null){
                    vo.setPics(new ArrayList<>());
                }
                vo.getPics().add(picsVo.getPic());
            }
            FeedCommentSelDto fdto = new FeedCommentSelDto();
            //fdto.setIfeedList(ifeedList);
            List<FeedCommentSelVo> feedCommentList = COMMENT_MAPPER.selFeedCommentAll(fdto);
            for(FeedCommentSelVo commentVo : feedCommentList){
                FeedSelVo vo = feedMap.get(commentVo.getIfeed());
                if(vo.getComments() == null){
                    vo.setComments(new ArrayList<>());
                }
                vo.getComments().add(commentVo);
                if(vo.getComments().size() == 4){
                    vo.setIsMoreComment(1);
                    vo.getComments().remove(3);
                }
            }

        }
        return voList;
    }
    public ResVo toggleFeedFav(FeedFavDto dto){
        int delFav = FAV_MAPPER.delFeedFav(dto);
        if (delFav == 0){
            FAV_MAPPER.insFeedFav(dto);
            return new ResVo(Const.FEED_FAV_ADD);
        }

        return new ResVo(Const.FEED_FAV_DEL);
    }
    public ResVo delFeed(FeedDelDto dto){
        int iuser = MAPPER.checkFeedIuser(dto);
        if(iuser == dto.getIuser()) {
            MAPPER.feedFavCommentPicsAll(dto);
            MAPPER.delFeed(dto);
            return new ResVo(Const.SUCCESS);
        }
        return new ResVo(Const.FAIL);
    }


}
