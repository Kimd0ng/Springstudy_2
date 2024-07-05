package com.example.springstudy.service;

import com.example.springstudy.domain.OrderItem;
import com.example.springstudy.domain.Orders;
import com.example.springstudy.dto.response.CustomerHistoryDetailItemDto;
import com.example.springstudy.repository.OrderItemRepository;
import com.example.springstudy.repository.OrdersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {
    private final OrdersRepository ordersRepository;
    private final OrderItemRepository orderItemRepository;

    public Map<String,Object> customerHistoryDetail(Long orderId){

        Orders orders = ordersRepository.findById(orderId)
                .orElseThrow();
        //레파지토리의 orders로 제공해야 되서 orders를 만들어줘야됨
        System.out.println(orders);
        List<OrderItem> orderItemList = orderItemRepository.findByOrderId(orders);
        //orders를 이용해 그 주문안에 들어있는 orderitemlist를 가져옴

        Map<String, Object> result = new HashMap<>();

        result.put("selectHistoryDetail", orderItemList.stream()
                        .map(orderItem -> CustomerHistoryDetailItemDto.builder()
                                .itemId(orderItem.getItemId().getId())
                                .itemName(orderItem.getItemId().getItemName())
                                .imageUrl(orderItem.getItemId().getImageUrl())
                                .itemPrice(orderItem.getItemId().getItemPrice())
                                .itemAmount(orderItem.getOrderItemAmount())
                                .build()
                        )
                );
        //map에 list에 있는 itemdetail들을 넣음

        return result;
    }
}
