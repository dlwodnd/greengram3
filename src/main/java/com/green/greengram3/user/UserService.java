package com.green.greengram3.user;

import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.user.mappers.UserMapper;
import com.green.greengram3.user.models.dto.*;

import com.green.greengram3.user.models.vo.UserEntity;
import com.green.greengram3.user.models.vo.UserInfoVo;
import com.green.greengram3.user.models.vo.UserSigninVo;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper MAPPER;

    public ResVo signup(UserSignupDto dto){
        String pw = BCrypt.hashpw(dto.getUpw(),BCrypt.gensalt());
        dto.setUpw(pw);
        MAPPER.userSignup(dto);
        return new ResVo(dto.getIuser());
    }
    public UserSigninVo userSignin(UserSigninDto dto){
        //성공 : 1 ,아이디없음 :2 ,비밀번호 틀림 : 3
        UserSigninVo vo = new UserSigninVo();
        UserSelDto sDto = new UserSelDto();
        sDto.setUid(dto.getUid());
        vo.setResult(Const.LOGIN_DIFF_UPW);
        UserEntity uEntity = MAPPER.selUser(sDto);
        if (uEntity == null){
            vo.setResult(Const.LOGIN_NO_UID);
            return vo;
        }
        if (BCrypt.checkpw(dto.getUpw(),uEntity.getUpw())){
            vo.setResult(Const.SUCCESS);
            vo.setNm(uEntity.getNm());
            vo.setPic(uEntity.getPic());
            vo.setIuser(uEntity.getIuser());
            return vo;
        }

        return vo;
    }
    public UserInfoVo targetUserInfo(UserInfoDto dto){
        UserInfoVo vo = MAPPER.userInfo(dto);
        return vo;
    }
    public ResVo toggleFollow(UserFollowDto dto){
        int result = MAPPER.delFollow(dto);
        if(result == 0){
            MAPPER.insFollow(dto);
            return new ResVo(1);
        }

        return new ResVo(0);
    }
    public ResVo patchPic(UserPatchPicDto dto){
        int result = MAPPER.updUserPic(dto);
        return new ResVo(result);
    }
}
