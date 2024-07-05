package com.example.springstudy.controller;

import com.example.springstudy.dto.request.UserIdRequestDto;
import com.example.springstudy.dto.request.UsernickNameUpdateRequestDto;
import com.example.springstudy.dto.response.ChangeNicknameDto;
import com.example.springstudy.dto.response.ResponseDto;
import com.example.springstudy.service.TopbarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topbar")
@RequiredArgsConstructor
public class TopbarController {

    private final TopbarService topbarService;

    @PostMapping("/username")
    public ResponseDto<String> topbarName(
            @Valid @RequestBody UserIdRequestDto userIdRequestDto
            //@RequestParam(name = "id") Long id
            ){
        return new ResponseDto<>(topbarService.topbarName(userIdRequestDto));
    }

    @PatchMapping("/updatename")
    public ResponseDto<ChangeNicknameDto> updateName(
            @Valid @RequestBody UsernickNameUpdateRequestDto usernickNameUpdateDto
            //@RequestParam(name = "id") Long id,
            //@RequestParam(name = "name") String nickname
            ){
        return new ResponseDto<>(topbarService.updateName(usernickNameUpdateDto));
    }
}
