package com.green.greengram3.feed.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.greengram3.common.Const;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@Schema(title = "피드 리스트")
public class FeedSelDto {
    @Schema(title = "페이지",defaultValue = "1")
    private int page;
    @Schema(title = "로그인한 유저pk")
    private int loginedIuser;
    @Schema(title = "프로필 주인유저pk",required = false)
    private int targetIuser;
    @Schema(title = "좋아요 Feed 리스트 여부", required = false)
    private int isFavList;

    @JsonIgnore
    private int startIdx;

    @JsonIgnore
    private int rowCount = Const.FEED_COUNT_PER_PAGE;

    public void setPage(int page){
        this.startIdx = (page-1) * this.rowCount;
    }
}
