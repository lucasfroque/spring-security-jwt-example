package com.lucasfroque.springsecurityexample.repository;

import com.lucasfroque.springsecurityexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
