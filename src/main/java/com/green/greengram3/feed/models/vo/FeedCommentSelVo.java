package com.green.greengram3.feed.models.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FeedCommentSelVo {
    @JsonIgnore
    @Schema(hidden = true)
    private int ifeed;
    private int ifeedComment;
    private int writerIuser;
    private String writerNm;
    private String writerPic;
    private String comment;
    private String createdAt;

}
