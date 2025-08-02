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
import model.TikTokAwards;
import utils.DBContext;

/**
 *
 * @author Admin
 */
public class TikTokAwardsDAO extends DBContext {

    public TikTokAwardsDAO() {
        super();
    }

    public List<TikTokAwards> getAll() {
        List<TikTokAwards> tikTokAwardses = new ArrayList<>();
        String sql = "SELECT * FROM TikTokAwards";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt("Id");
                String Name = rs.getString("Name");
                String Account = rs.getString("Account");
                String Category = rs.getString("Category");
                int Years = rs.getInt("Years");
                TikTokAwards tikTokAwards = new TikTokAwards(Id, Name, Account, Category, Years);
                tikTokAwardses.add(tikTokAwards);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tikTokAwardses;
    }

    public TikTokAwards getAccountById(int id) {
        String sql = "SELECT * FROM TikTokAwards WHERE ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String Name = rs.getString("Name");
                String Account = rs.getString("Account");
                String Category = rs.getString("Category");
                int Years = rs.getInt("Years");
                TikTokAwards tikTokAwards = new TikTokAwards(id, Name, Account, Category, Years);
                return tikTokAwards;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int update(int Id, String Name, String Account, String Category, int Years) {
        String sql = "update TikTokAwards set Name = ?, Account = ?, Category = ?, Years = ? where Id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Name);
            ps.setString(2, Account);
            ps.setString(3, Category);
            ps.setInt(4, Years);
            ps.setInt(5, Id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return 1; // Xoá thành công
            } else {
                return 0; // Không có hàng nào bị xoá
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        TikTokAwardsDAO td = new TikTokAwardsDAO();
//        List<TikTokAwards> tikTokAwardses = td.getAll();
//        for (TikTokAwards tikTokAwards : tikTokAwardses) {
//            System.out.println(tikTokAwards);
//        }

//        int id = 1;
//        TikTokAwards tikTokAwards = td.getAccountById(id);
//        if (tikTokAwards != null) {
//            System.out.println(tikTokAwards);
//        }
        int res = td.update(1, "Le Tuan Khang", "@letuankhang2002", "Entertainment", 2025);
        System.out.println(res);
    }
}
