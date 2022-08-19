package com.lucasfroque.springsecurityexample.dto.request;

import com.lucasfroque.springsecurityexample.model.User;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank @Size(min = 3)
    String name;
    @Email
    String email;
    @NotBlank @Size(min = 7)
    String password;

    public UserRequestDto(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public User converterToUser() {
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        return user;
    }
}
