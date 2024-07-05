package com.example.springstudy.service;

import com.example.springstudy.domain.Orders;
import com.example.springstudy.repository.OrderItemRepository;
import com.example.springstudy.repository.OrdersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

        //orders를 이용해 그 주문안에 들어있는 orderitemlist를 가져옴

        Map<String, Object> result = new HashMap<>();

        //map에 list에 있는 itemdetail들을 넣음

        return result;
    }
}
