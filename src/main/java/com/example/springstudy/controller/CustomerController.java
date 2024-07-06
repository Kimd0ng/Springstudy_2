package com.example.springstudy.controller;

import com.example.springstudy.dto.request.UserIdRequestDto;
import com.example.springstudy.dto.response.ResponseDto;
import com.example.springstudy.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/basket")
    public  ResponseDto<Map<String, Object>> customerBasket(
            @Valid @RequestBody UserIdRequestDto userIdRequestDto
    ){
        return new ResponseDto<>(customerService.customerBasket(userIdRequestDto));
    }

    @PostMapping("/history/detail/{orderId}")
    public ResponseDto<Map<String, Object>> customerHistoryDetail(
            @Valid @RequestBody UserIdRequestDto userIdRequestDto,
            @PathVariable Long orderId
    ){
        return new ResponseDto<>(customerService.customerHistoryDetail(orderId, userIdRequestDto));
    }
}
