package com.example.springboottemplate.users.v1.repository;

import com.example.springboottemplate.users.v1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
