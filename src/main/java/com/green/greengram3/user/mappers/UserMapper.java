package com.green.greengram3.user.mappers;

import com.green.greengram3.user.models.dto.*;

import com.green.greengram3.user.models.vo.UserEntity;
import com.green.greengram3.user.models.vo.UserInfoVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int userSignup (UserSignupDto dto);

    UserEntity selUser(UserSelDto dto);

    UserInfoVo userInfo(UserInfoDto dto);
    int updUserPic(UserPatchPicDto dto);
    int delFollow (UserFollowDto dto);
    int insFollow (UserFollowDto dto);

    UserInfoVo selFollow(UserInfoDto dto);
}
