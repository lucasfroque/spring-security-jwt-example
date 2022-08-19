package com.lucasfroque.springsecurityexample.dto.response;

import com.lucasfroque.springsecurityexample.model.User;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserResponseDto {
    Long id;
    String name;
    String email;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public static List<UserResponseDto> userListToResponseDtoList(List<User> user) {
       return user.stream().map(UserResponseDto::new).collect(Collectors.toList());
    }
}
