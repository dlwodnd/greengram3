package com.green.greengram3.dm.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.greengram3.common.Const;
import lombok.Data;

@Data
public class DmSelDto {
    private int loginedIuser;
    private int page;
    @JsonIgnore
    private int startIdx;
    @JsonIgnore
    private int rowCount = Const.FEED_COUNT_PER_PAGE;

    public void setPage(int page){
        this.startIdx = (page - 1) * this.rowCount;
    }
}
