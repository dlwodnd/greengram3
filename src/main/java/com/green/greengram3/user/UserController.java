package com.green.greengram3.user;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.user.models.dto.*;
import com.green.greengram3.user.models.vo.UserInfoVo;
import com.green.greengram3.user.models.vo.UserSigninVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    private final UserService SERVICE;

    @PostMapping("/signup")
    @Operation(summary = "회원가입", description = "회원가입 처리",tags = "회원가입 처리")
    public ResVo userSignup(@RequestBody UserSignupDto dto){
        log.info("dto : {}",dto);
        return SERVICE.signup(dto);
    }
    @PostMapping("/signin")
    @Operation(summary = "로그인", description = "로그인 처리",tags = "로그인")
    public UserSigninVo userSingin(@RequestBody UserSigninDto dto){
        return SERVICE.userSignin(dto);
    }
    @GetMapping
    public UserInfoVo userInfo(UserInfoDto dto){
        log.info("infoDto : {}",dto);
        return SERVICE.targetUserInfo(dto);
    }
    @PostMapping("/follow")
    public ResVo toggleFollow(@RequestBody UserFollowDto dto){
        return SERVICE.toggleFollow(dto);
    }
    @PatchMapping("/pic")
    public ResVo patchUserPic(@RequestBody UserPatchPicDto dto){
        return SERVICE.patchPic(dto);
    }
}
