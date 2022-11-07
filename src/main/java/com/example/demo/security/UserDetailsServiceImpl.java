package com.example.demo.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String usernameToLoad) throws UsernameNotFoundException {
        User user = userService.findByUsername(usernameToLoad);
        if (user == null) {
            throw new UsernameNotFoundException("No user present with username: " + usernameToLoad);
        } else {
            String username = user.getUsername();
            String hashedPassword = user.getHashedPassword();
            List<GrantedAuthority> authorities = getAuthorities(user);
            return new SecurityUser(username, hashedPassword, authorities);
        }
    }

    private List<GrantedAuthority> getAuthorities(User user) {
        return user.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());

    }

}
