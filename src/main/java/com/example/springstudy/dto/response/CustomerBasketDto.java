package com.example.springstudy.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerBasketDto {
    private Long basketId;
    private Long itemId;
    private String itemName;
    private String imageUrl;
    private Integer basketItemAmount;
    private Integer itemPrice;
    private Integer itemAmount;
}