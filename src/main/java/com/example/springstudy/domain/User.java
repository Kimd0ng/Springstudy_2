package com.example.springstudy.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String loginId;

    @Column(nullable = false, length = 30)
    private String password;

    @Column(nullable = false, length = 30)
    private String nickname;

    @Column(nullable = true)
    private Integer point;

    @Column(nullable = false)
    private LocalDate createAt;

    @Column(nullable = false)
    private LocalDate updateAt;


    //manytoone의 참조 받은것과 연결
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<UserItem> UserItemList;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Orders> OrdersList;


    @Builder
    public User(String loginId, String password, String nickname, Integer point, LocalDate updateAt){
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.point = point;
        this.createAt = LocalDate.now();
        this.updateAt = updateAt;
    }

    public void updateName(String name){this.nickname = name;}
}
