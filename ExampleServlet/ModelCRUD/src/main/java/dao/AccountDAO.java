/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import until.DBContext;

/**
 *
 * @author Admin
 */
public class AccountDAO extends DBContext {

    public AccountDAO() {
        super();
    }

    public List<Account> getAll() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT id, username, password, fullname FROM account";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String fullname = rs.getString("fullname");
                // Tạo đối tượng Account và thêm vào danh sách
                Account account = new Account(id, username, password, fullname);
                accounts.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public int insert(String username, String password, String fullname) {
        String sqlGetMaxId = "select max(id) as maxId from account";
        try {
            PreparedStatement psGetMaxId = conn.prepareStatement(sqlGetMaxId);
            ResultSet rsMaxId = psGetMaxId.executeQuery();
            if (rsMaxId.next()) {
                int nextId = rsMaxId.getInt("maxId") + 1;
                String sql = "INSERT INTO account(id, username, password, fullname) "
                        + "values(?, ?, ?, ?)";
                try {
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, nextId);
                    ps.setString(2, username);
                    ps.setString(3, password);
                    ps.setString(4, fullname);
                    int num = ps.executeUpdate();
                    if (num > 0) {
                        return 1;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }

    public Account getAccountById(int id) {
        String sql = "SELECT * FROM account WHERE ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String fullname = rs.getString("fullname");
                Account account = new Account(id, username, password, fullname);
                return account;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public int delete(int id) {
        String sql = "DELETE FROM account WHERE ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate(); // Trả về số hàng bị ảnh hưởng
            if (rowsAffected > 0) {
                return 1; // Xoá thành công
            } else {
                return 0; // Không có hàng nào bị xoá
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

    public int update(int id, String username, String password, String fullName) {
        String sql = "update Account set username = ?, password = ?, fullname = ? where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullName);
            ps.setInt(4, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return 1; // Xoá thành công
            } else {
                return 0; // Không có hàng nào bị xoá
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public static void main(String[] args) {
        AccountDAO ad = new AccountDAO();

//        List<Account> list = ad.getAll();
//        if (list != null) {
//            for (Account account : list) {
//                System.out.println(account);
//            }
//        }
//        int num = ad.insert("User11", "password11", "Nguyen Van Toan");
//        System.out.println(num);
//        int id = 10;
//        Account account = ad.getAccountById(id);
//        if (account != null) {
//            System.out.println(account);
//        }
//        
//        int id = 12;
//        int rs = ad.delete(id);
//        System.out.println(rs);
        int res = ad.update(7, "Admin7", "Admin7", "Nguyen Van 7");
        System.out.println(res);
    }

}
