package com.example.demo.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Component
public class AuthenticatedUser {

    private final UserService userService;

    @Autowired
    public AuthenticatedUser(UserService userService) {
        this.userService = userService;
    }

    private Optional<Authentication> getAuthentication() {
        SecurityContext context = SecurityContextHolder.getContext();
        return Optional.ofNullable(context.getAuthentication())
                .filter(authentication -> !(authentication instanceof AnonymousAuthenticationToken));
    }

    public User getUser() {
        return get().orElse(null);
    }

    public Optional<User> get() {
        return getAuthentication().map(authentication -> userService.findByUsername(authentication.getName()));
    }

    public void logout() {
        User user = getUser();

        // Navigate frontend to /logout

        // SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        // logoutHandler.logout(currentHttpRequest, null, null);
    }

}
