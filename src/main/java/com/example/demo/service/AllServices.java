package com.example.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.security.AuthenticatedUser;

@Service
public class AllServices {
    public final PasswordEncoder passwordEncoder;
    public final RoleService role;
    public final UserService user;
    public final AuthenticatedUser authenticatedUser;
    public AllServices(
            PasswordEncoder passwordEncoder,
            RoleService role,
            UserService user,
            AuthenticatedUser authenticatedUser
    ) {
        this.passwordEncoder = passwordEncoder;
        this.role = role;
        this.user = user;
        this.authenticatedUser = authenticatedUser;
    }
}
