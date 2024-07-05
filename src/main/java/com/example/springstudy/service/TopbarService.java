package com.example.springstudy.service;

import com.example.springstudy.domain.User;
import com.example.springstudy.dto.request.UserIdRequestDto;
import com.example.springstudy.dto.request.UsernickNameUpdateRequestDto;
import com.example.springstudy.dto.response.ChangeNicknameDto;
import com.example.springstudy.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class TopbarService {

    private final UserRepository userRepository;

    public String topbarName(UserIdRequestDto userIdRequestDto){
        //System.out.println(userIdRequestDto.getUserId());
        User user = userRepository.findById(userIdRequestDto.getUserId())
                .orElseThrow();

        return user.getNickname();
    }

    public ChangeNicknameDto updateName(UsernickNameUpdateRequestDto usernickNameUpdateDto){
        User user = userRepository.findById(usernickNameUpdateDto.getId())
                .orElseThrow();

        //id를 이용해 user를 가져와서 새로운 name으로 update
        user.updateName(usernickNameUpdateDto.getNickName());
        //userRepository.save(user);

//        //update가 잘 되었는지 확인하기 위해 id로 user를 다시 불러옴
//        User user1 = userRepository.findByNickname(usernickNameUpdateDto.getNickName())
//                .orElseThrow();

        //새롭게 불러온 user의 값을 return
        ChangeNicknameDto changeNickname = ChangeNicknameDto.builder()
                .userId(user.getId())
                .nickname(user.getNickname())
                .build();

        return changeNickname;
    }
}
