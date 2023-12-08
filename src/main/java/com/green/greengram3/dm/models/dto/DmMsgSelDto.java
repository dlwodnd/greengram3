package com.green.greengram3.dm.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.greengram3.common.Const;
import lombok.Data;

@Data
public class DmMsgSelDto {
    private int idm;
    private int page;

    @JsonIgnore
    private int rowCount = Const.FEED_COUNT_PER_PAGE;
    @JsonIgnore
    private int startIdx;

    public void setPage(int page){
        this.startIdx = (page - 1) * this.rowCount;
    }
}
