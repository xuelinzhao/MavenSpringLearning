package com.xuelinzhao.dao;

import com.xuelinzhao.entities.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by zhaoxuelin on 2018/5/31.
 */

public class UserDAOImp implements UserDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addUser(User user){
        String sql = "INSERT INTO User(username,password,property) VALUES(?,?,?)";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setDouble(3, user.getProperty());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    @Override
    public void findByUsername(String username) {
        String sql = "SELECT * FROM User WHERE username = ?";
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            User user = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = user.createUser(rs.getString("username"),
                        rs.getString("password"),
                        rs.getDouble("property"));
            }
            System.out.println(user.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public ArrayList<User> findAllUsers() {
        ArrayList<User> userList = new ArrayList<User>();
        String sql = "SELECT * FROM User";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            User user = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = user.createUser(rs.getString("username"),
                        rs.getString("password"),
                        rs.getDouble("property"));
                System.out.println(user.toString());
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        return  userList;
    }

}
