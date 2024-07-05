package com.example.springstudy.domain;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String itemName;

    @Column(nullable = false)
    private Integer itemPrice;

    @Column(nullable = false)
    private Integer itemAmount;

    @Column(nullable = false, length = 100)
    private String imageUrl;

    @Column(nullable = false)
    private LocalDate updateAt;


    @OneToMany(mappedBy = "itemId", fetch = FetchType.LAZY)
    private List<UserItem> UserItemList;


    @Builder
    public Item(String itemName, Integer itemPrice, Integer itemAmount, String imageUrl, LocalDate updateAt){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemAmount = itemAmount;
        this.imageUrl = imageUrl;
        this.updateAt = updateAt;
    }
}
