package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.TABLES;

@Entity
@Table(name = TABLES.ROLE.TABLE_NAME)
public class Role extends AbstractEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
