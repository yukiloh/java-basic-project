package com.example.jdbc.basicJDBC;

public class SqlData {
    private int id;
    private String name;
    private int sex;
    private int score;
    private int id2;
    private String sex2;
    private String password;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public String getSex2() {
        return sex2;
    }

    public void setSex2(String sex2) {
        this.sex2 = sex2;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SqlData(int id, String name, int sex, int score, int id2, String sex2, String password) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.score = score;
        this.id2 = id2;
        this.sex2 = sex2;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public SqlData() {
    }
}
