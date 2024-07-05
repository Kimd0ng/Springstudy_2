package com.example.springstudy.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsernickNameUpdateRequestDto {
    private Long id;
    private String nickName;
}
