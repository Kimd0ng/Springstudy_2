package com.example.springstudy.repository;

import com.example.springstudy.domain.OrderItem;
import com.example.springstudy.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(Orders orderId);  //List를 활용하기 위해 Orders 타입으로 넣어야됨
}
