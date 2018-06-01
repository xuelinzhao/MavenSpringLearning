package com.xuelinzhao.entities;

/**
 * Created by zhaoxuelin on 2018/5/31.
 */
public class User {
    private String username;
    private String password;
    private Double property;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getProperty() {
        return property;
    }

    public void setProperty(Double property) {
        this.property = property;
    }

    public static User createUser(String username, String password, Double property){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setProperty(property);
        return user;
    }

    @Override
    public String toString(){
        return "Username: "+username+" Password:"+password+" Property:"+property;
    }
}
