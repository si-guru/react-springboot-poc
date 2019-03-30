package com.react.springboot.poc.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.react.springboot.poc.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}