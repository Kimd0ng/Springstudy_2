package com.example.springstudy.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChangeNicknameDto {
    private Long userId;
    private String nickname;
}
