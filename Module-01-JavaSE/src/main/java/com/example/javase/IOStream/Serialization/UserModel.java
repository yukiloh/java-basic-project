package com.example.javase.IOStream.Serialization;

import java.io.Serializable;

public class UserModel implements Serializable {
    private String username;
    private Integer userAge;    /* transient :瞬时关键词,该当的属性不会被序列化*/

    @Override
    public String toString() {
        return "UserModel{" +
                "username='" + username + '\'' +
                ", userAge=" + userAge +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}
