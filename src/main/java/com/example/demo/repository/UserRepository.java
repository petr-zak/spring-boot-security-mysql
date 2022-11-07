package com.example.demo.repository;

import com.example.demo.entity.User;

public interface UserRepository extends AbstractRepository<User> {
    User findByUsername(String username);
}