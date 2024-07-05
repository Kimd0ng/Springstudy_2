package com.example.springstudy.controller;

import com.example.springstudy.dto.response.ResponseDto;
import com.example.springstudy.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/history/detail/{orderId}")
    public ResponseDto<Map<String, Object>> customerHistoryDetail(
            @PathVariable Long orderId
    ){
        return new ResponseDto<>(customerService.customerHistoryDetail(orderId));
    }
}
