package com.example.javase.features.entity;

import java.util.Optional;

/**
 * @author yukiloh
 * @version 0.1
 * @date 2020/7/6 10:03
 */
public class User {

    private Integer id;
    private String username;

    public User() {
    }

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Optional<String> getOptionalUsername() {
        return Optional.ofNullable(username);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
