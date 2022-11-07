package com.example.demo.repository;

import com.example.demo.entity.Role;

public interface RoleRepository extends AbstractRepository<Role> {
    Role findByName(String name);
}