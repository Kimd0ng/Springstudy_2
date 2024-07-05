package com.example.springstudy.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class UserItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Integer basketItemAmount;

    //fetch lazy를 해주어야 조회를 할때 원하는 값을 불러오는 순간에 불러오게 해줌
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item itemId;

    @Builder
    public UserItem(Integer basketItemAmount, User userId, Item itemId){
        this.basketItemAmount = basketItemAmount;
        this.userId = userId;
        this.itemId = itemId;
    }
}
