package com.example.demo.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

/**
 * We already use "User" in entity so lets use "SecurityUser" for "Spring Security User"
 */
public class SecurityUser extends org.springframework.security.core.userdetails.User {
    public SecurityUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public SecurityUser(String username,
                        String password,
                        boolean enabled,
                        boolean accountNonExpired,
                        boolean credentialsNonExpired,
                        boolean accountNonLocked,
                        Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
