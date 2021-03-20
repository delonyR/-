package com.Q.pojo;

import java.util.Date;

public class User {
    private int id;
    private int level;
    private Date birthday;
    private String nickname;
    private String psw;
    private String sex;
    private String email;

    public void setId(int id) {
        this.id = id;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPsw() {
        return psw;
    }

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }
}
