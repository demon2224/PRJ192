/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Applicant;

import utils.DBContext;

/**
 *
 * @author Admin
 */
public class ApplicantDAO extends DBContext {

    public ApplicantDAO() {
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

    public Applicant verifyMD5(String username, String password) {
        Applicant users = new Applicant();
        String sql = "SELECT * FROM applicant WHERE applicant_account = ? AND applicant_password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, hashMD5(password));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                users.setId(rs.getInt("applicant_id"));
                users.setAccountString(rs.getString("applicant_account"));
                users.setPassword(rs.getString("applicant_password"));
                users.setName(rs.getString("applicant_name"));
                users.setEmail(rs.getString("applicant_email"));

                return users;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void main(String[] args) {
        ApplicantDAO ad = new ApplicantDAO();
        Applicant users = ad.verifyMD5("saul", "12346");
        System.out.println(users.getId());
    }
}
