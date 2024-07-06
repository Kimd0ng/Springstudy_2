package com.example.springstudy.service;

import com.example.springstudy.domain.OrderItem;
import com.example.springstudy.domain.Orders;
import com.example.springstudy.domain.User;
import com.example.springstudy.domain.UserItem;
import com.example.springstudy.dto.request.UserIdRequestDto;
import com.example.springstudy.dto.response.CustomerBasketDto;
import com.example.springstudy.dto.response.CustomerHistoryDetailItemDto;
import com.example.springstudy.repository.OrderItemRepository;
import com.example.springstudy.repository.OrdersRepository;
import com.example.springstudy.repository.UserItemRepository;
import com.example.springstudy.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final UserItemRepository userItemRepository;
    private final UserRepository userRepository;

    public Map<String, Object> customerBasket(UserIdRequestDto userIdRequestDto) {

        User user = userRepository.findById(userIdRequestDto.getUserId())
                .orElseThrow();
        List<UserItem> userItemList = userItemRepository.findByUserId(user);

        Map<String, Object> result = new HashMap<>();

        result.put("selectbasket", userItemList.stream()
                .map(userItem -> CustomerBasketDto.builder()
                        .basketId(userItem.getId())
                        .itemId(userItem.getItemId().getId())
                        .itemName(userItem.getItemId().getItemName())
                        .itemPrice(userItem.getItemId().getItemPrice())
                        .basketItemAmount(userItem.getBasketItemAmount())
                        .itemAmount(userItem.getItemId().getItemAmount())
                        .imageUrl(userItem.getItemId().getImageUrl())
                        .build()
                )
        );

        return result;
    }

    public Map<String,Object> customerHistoryDetail(Long orderId, UserIdRequestDto userIdRequestDto) {

        Orders orders = ordersRepository.findById(orderId)
                .orElseThrow();
        //레파지토리의 orders로 제공해야 되서 orders를 만들어줘야됨
        System.out.println(orders);

        if (userIdRequestDto.getUserId().equals(orders.getUserId().getId())) {

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
        } else {
            Map<String, Object> result = new HashMap<>();
            result.put("error", ResponseEntity.status(HttpStatus.FORBIDDEN).build());

            return result;
        }
    }
}
