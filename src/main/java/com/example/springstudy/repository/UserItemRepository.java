package com.example.springstudy.repository;

import com.example.springstudy.domain.User;
import com.example.springstudy.domain.UserItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserItemRepository extends JpaRepository<UserItem, Long> {
    List<UserItem> findByUserId(User userId);
}
