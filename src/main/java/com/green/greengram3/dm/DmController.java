package com.green.greengram3.dm;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.dm.models.dto.DmMsgInsDto;
import com.green.greengram3.dm.models.dto.DmMsgSelDto;
import com.green.greengram3.dm.models.dto.DmSelDto;
import com.green.greengram3.dm.models.vo.DmMsgSelVo;
import com.green.greengram3.dm.models.vo.DmSelVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dm")
@Slf4j
public class DmController {
    private final DmService DM_SERVICE;

    //방이 있는 것만
    @GetMapping("/msg")
    public List<DmMsgSelVo> getMsgAll(DmMsgSelDto dto){
        log.info("dto : {} ",dto);
        return DM_SERVICE.getMsgAll(dto);

    }
    @GetMapping
    public List<DmSelVo> getDmAll(DmSelDto dto){
        return DM_SERVICE.getDmAll(dto);
    }
    @PostMapping("/msg")
    public ResVo postDmMsg(@RequestBody DmMsgInsDto dto){
        return DM_SERVICE.postDmMsg(dto);
    }
}
