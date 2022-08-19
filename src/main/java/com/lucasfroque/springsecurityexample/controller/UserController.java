package com.lucasfroque.springsecurityexample.controller;

import com.lucasfroque.springsecurityexample.dto.request.UserRequestDto;
import com.lucasfroque.springsecurityexample.dto.response.UserResponseDto;
import com.lucasfroque.springsecurityexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<UserResponseDto> save(@RequestBody @Valid UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = service.save(userRequestDto);
        return ResponseEntity.ok(userResponseDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long id, @RequestBody @Valid UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = service.update(id, userRequestDto);
        return ResponseEntity.ok(userResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
