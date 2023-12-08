package com.green.greengram3.dm;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.dm.mappers.DmMapper;
import com.green.greengram3.dm.models.dto.DmMsgInsDto;
import com.green.greengram3.dm.models.dto.DmMsgSelDto;
import com.green.greengram3.dm.models.dto.DmSelDto;
import com.green.greengram3.dm.models.vo.DmMsgSelVo;
import com.green.greengram3.dm.models.vo.DmSelVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DmService {
    private final DmMapper DM_MAPPER;

    public List<DmMsgSelVo> getMsgAll(DmMsgSelDto dto){
        List<DmMsgSelVo> voList = DM_MAPPER.selDmMsgAll(dto);

        return DM_MAPPER.selDmMsgAll(dto);
    }
    public List<DmSelVo> getDmAll(DmSelDto dto){
        return DM_MAPPER.selDmAll(dto);
    }
    public ResVo postDmMsg(DmMsgInsDto dto){
        int result = DM_MAPPER.insDmMsg(dto);
        return new ResVo(result);
    }

}
