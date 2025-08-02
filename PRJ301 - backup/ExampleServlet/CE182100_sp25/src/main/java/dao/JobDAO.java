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
import model.Application;
import model.Job;

import utils.DBContext;

/**
 *
 * @author Admin
 */
public class JobDAO extends DBContext {

    public JobDAO() {
        super();
    }

    public List<Job> getAll() {
        List<Job> products = new ArrayList<>();
        String sql = "SELECT j.*, a.status FROM job j JOIN application a ON j.job_id = a.job_id";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 int status = rs.getInt("status");
                Application a = new Application(status);
                Job product = new Job(rs.getInt("job_id"), rs.getString("job_title"), rs.getString("job_company"), rs.getString("job_location"), a);
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
//
//    public Job getAccountById(int id) {
//        String sql = "SELECT * FROM product WHERE pro_id = ?";
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                String proName = rs.getString("pro_name");
//                long proPrice = rs.getLong("pro_price");
//                int proQuantity = rs.getInt("pro_quantity");
//                String proDescription = rs.getString("pro_description");
//                int catId = rs.getInt("cat_id");
//                Category category = new Category(catId);
//                Job product = new Job(id, proName, proPrice, proQuantity, proDescription, category);
//                return product;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

//    public int update(Job product) {
//        String sql = "UPDATE product SET pro_name = ?, pro_price = ?,  pro_quantity = ?, pro_description = ?, cat_id = ? WHERE pro_id = ?";
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, product.getProNameString());
//            ps.setLong(2, product.getProPrice());
//            ps.setInt(3, product.getProQuantity());
//            ps.setString(4, product.getProDescription());
//            ps.setInt(5, product.getCat().getCatId());
//            ps.setInt(6, product.getProId());
//
//            int rowsAffected = ps.executeUpdate();
//            if (rowsAffected > 0) {
//                return 1; // Xoá thành công
//            } else {
//                return 0; // Không có hàng nào bị xoá
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
    public static void main(String[] args) {
        JobDAO td = new JobDAO();
        List<Job> tikTokAwardses = td.getAll();
        for (Job tikTokAwards : tikTokAwardses) {
            System.out.println(tikTokAwards);
        }

//        int id = 1;
//        Job account = td.getAccountById(id);
//        System.out.println(account);
////        int rs = ad.delete(id);
////        System.out.println(rs);
//        int res = td.update(new Job(6, "abc123", 10000, 10, "Chinane", new Category(2)));
//        System.out.println(res);
//         int num = td.insert(new Job(1, "abc", 10000, 10, "Chinane", new Category(1)));
//        System.out.println(num);
//        int delete= td.delete(7);
//        System.out.println(delete);
    }
}
