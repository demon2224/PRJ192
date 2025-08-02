/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public Account verifyMD5(String username, String password) {
        Account account = new Account();
        String sql = "SELECT * FROM Account WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, hashMD5(password));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setFullname(rs.getString("fullname"));
                account.setFullname(rs.getString("fullname"));
                account.setGender(rs.getString("gender"));
                account.setBirthday(rs.getDate("birthday"));
                account.setDepartment(rs.getString("department"));
                return account;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    public static void main(String[] args) {
        AccountDAO ad = new AccountDAO();
        Account users = ad.verifyMD5("admin", "1234356");
        System.out.println(users.getFullname());
    }
}
