package com.example.springstudy.repository;

import com.example.springstudy.domain.OrderItem;
import com.example.springstudy.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(Orders orderId);  //List를 활용하기 위해 Orders 타입으로 넣어야됨
    //처음에 orderid를 이용해 select를 진행했는데 이렇게 하니까 order를 이용해서 하라고 나옴
}
