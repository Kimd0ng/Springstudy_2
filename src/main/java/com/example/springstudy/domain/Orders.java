package com.example.springstudy.domain;

import com.example.springstudy.domain.enums.OrderState;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer totalAmount;

    @Column(nullable = false)
    private Integer totalPrice;

    @Column(nullable = false)
    private LocalDate createAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User userId;

    @OneToMany(mappedBy = "orderId", fetch = FetchType.LAZY)
    private List<OrderItem> OrderItemList;

    @Builder
    public Orders(Integer totalAmount, Integer totalPrice, OrderState orderState, User userId){
        this.totalAmount = totalAmount;
        this.totalPrice = totalPrice;
        this.createAt = LocalDate.now();
        this.orderState = orderState;
        this.userId = userId;
    }
}
