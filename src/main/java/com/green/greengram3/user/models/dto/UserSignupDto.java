package com.green.greengram3.user.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "회원가입 입력 데이터")
public class UserSignupDto {
    @JsonIgnore
    private int iuser;
    @Schema(title = "유저 아이디")
    private String uid;
    @Schema(title = "유저 비밀번호")
    private String upw;
    @Schema(title = "유저 이름")
    private String nm;
    @Schema(title = "유저 프로필사진")
    private String pic;
}
