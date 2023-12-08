package com.green.greengram3.dm.mappers;

import com.green.greengram3.dm.models.dto.DmMsgInsDto;
import com.green.greengram3.dm.models.dto.DmMsgSelDto;
import com.green.greengram3.dm.models.dto.DmSelDto;
import com.green.greengram3.dm.models.dto.DmUserInsDto;
import com.green.greengram3.dm.models.vo.DmMsgSelVo;
import com.green.greengram3.dm.models.vo.DmSelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmMapper {
    List<DmMsgSelVo> selDmMsgAll(DmMsgSelDto dto);
    int insDm(DmUserInsDto dto);
    int insDmUser(DmUserInsDto dto);
    List<DmSelVo> selDmAll(DmSelDto dto);
    int insDmMsg(DmMsgInsDto dto);
}
