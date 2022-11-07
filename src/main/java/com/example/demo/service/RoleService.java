package com.example.demo.service;

import java.util.Objects;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;

@Service
public class RoleService extends AbstractService<Role, RoleRepository> {
    public Role USER;
    public Role ADMIN;

    @Autowired
    public RoleService(RoleRepository repository) {
        super(repository);
    }

    @PostConstruct
    protected void postConstruct() {
        USER = findByName("USER");
        Objects.requireNonNull(USER, "Role USER not found in DB.");

        ADMIN = findByName("ADMIN");
        Objects.requireNonNull(ADMIN, "Role TEAM_ADMIN not found in DB.");

    }

    public Role findByName(String name) {
        return repository.findByName(name);
    }
}
