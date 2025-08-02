/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Users;
import utils.DBContext;

/**
 *
 * @author Admin
 */
public class UsersDAO extends DBContext {

    public UsersDAO() {
        super();
    }

    public String hashMD5(String pass) {
        try {
            MessageDigest mes = MessageDigest.getInstance("MD5");
            byte[] messMD5 = mes.digest(pass.getBytes());
            StringBuilder str = new StringBuilder();
            for (byte b : messMD5) {
                //String ch = String.format("%.2f", 5 / 3);
                String ch = String.format("%02x", b);
                str.append(ch);
            }
            return str.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public Users verifyMD5(String username, String password) {
        Users users = new Users();
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, hashMD5(password));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                users.setId(rs.getInt("id"));
                users.setUsername(rs.getString("username"));
                users.setPassword(rs.getString("password"));
                return users;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void main(String[] args) {
        UsersDAO ad = new UsersDAO();
        Users users = ad.verifyMD5("admin", "123456");
        System.out.println(users.getId());
    }
}
