package com.example.springstudy.repository;


import com.example.springstudy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //@Query("select u.nickname from User u where u.id = :id") 이렇게 사용해도 되지만 간단하니까 findby를 활용
    Optional<User> findById(Long id);

    Optional<User> findByNickname(String nickname);
}