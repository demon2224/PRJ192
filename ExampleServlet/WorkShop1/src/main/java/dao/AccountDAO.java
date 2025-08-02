/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import utils.DBContext;

/**
 *
 * @author Admin
 */
public class AccountDAO extends DBContext {

    public AccountDAO() {
        super();
    }

    public Account verify(String user, String pass) {
        Account acc = new Account();
        String sql = "SELECT * FROM account WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                acc.setId(rs.getInt("id"));
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                acc.setFullname(rs.getString("fullname"));
                return acc;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
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
    
    public Account verifyMD5(String user, String pass) {
        Account acc = new Account();
        String sql = "SELECT * FROM account WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, hashMD5(pass));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                acc.setId(rs.getInt("id"));
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                acc.setFullname(rs.getString("fullname"));
                return acc;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }

    public static void main(String[] args) {
        AccountDAO ad = new AccountDAO();
//        Account account = ad.verify("user2", "password2");
//        System.out.println(account.getId());

        String pass = "password2";
        System.out.println(ad.hashMD5(pass));
    }

}
