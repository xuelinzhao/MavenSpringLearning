package com.xuelinzhao.dao;

import com.xuelinzhao.entities.User;

import java.util.ArrayList;

/**
 * Created by zhaoxuelin on 2018/5/31.
 */

public interface UserDAO {
     void addUser(User user);
     User findByUsername(String username);
     ArrayList<User> findAllUsers();
}
