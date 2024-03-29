package com.lucasfroque.springsecurityexample.service.impl;

import com.lucasfroque.springsecurityexample.dto.request.UserRequestDto;
import com.lucasfroque.springsecurityexample.dto.response.UserResponseDto;
import com.lucasfroque.springsecurityexample.model.User;
import com.lucasfroque.springsecurityexample.repository.UserRepository;
import com.lucasfroque.springsecurityexample.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
        User user = userRequestDto.converterToUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        return new UserResponseDto(user);
    }

    @Override
    public UserResponseDto update(Long id, UserRequestDto userRequestDto) {
        User user = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        repository.save(user);
        return new UserResponseDto(user);
    }

    @Override
    public List<UserResponseDto> findAll() {
        return UserResponseDto.userListToResponseDtoList(repository.findAll());
    }

    @Override
    public UserResponseDto findById(Long id) {
        return new UserResponseDto(repository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found")));
    }

    @Override
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("User not found");
        }
    }
}
