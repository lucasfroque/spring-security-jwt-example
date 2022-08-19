package com.lucasfroque.springsecurityexample.service;


import com.lucasfroque.springsecurityexample.dto.request.UserRequestDto;
import com.lucasfroque.springsecurityexample.dto.response.UserResponseDto;
import com.lucasfroque.springsecurityexample.model.User;

import java.util.List;

public interface UserService {

    UserResponseDto save(UserRequestDto userRequestDto);
    UserResponseDto update(Long id, UserRequestDto userRequestDto);
    List<UserResponseDto> findAll();
    UserResponseDto findById(Long id);
    void delete(Long id);
}
