package com.lucasfroque.springsecurityexample.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class TokenForm {
    String token;
}
