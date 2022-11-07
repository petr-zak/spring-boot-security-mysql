package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.demo.TABLES;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = TABLES.USER.TABLE_NAME)
public class User extends AbstractEntity {

    private String username;
    @JsonIgnore
    private String hashedPassword;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = TABLES.USER_ROLE.TABLE_NAME,
            joinColumns = @JoinColumn(name = "fk_user"),
            inverseJoinColumns = @JoinColumn(name = "fk_role")
    )
    private Set<Role> roles = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
