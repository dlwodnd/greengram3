package com.green.greengram3.feed.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class FeedCommentInsDto {
    @JsonIgnore
    private int ifeedComment;
    private int ifeed;
    private int iuser;
    private String comment;
}
