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
import model.Cows;
import utils.DBContext;

/**
 *
 * @author Admin
 */
public class CowDAO extends DBContext {

    public CowDAO() {
        super();
    }

    public List<Cows> getAll() {
        List<Cows> products = new ArrayList<>();
        String sql = "SELECT * FROM Cows";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("cowID");
                String name = rs.getString("Name");
                String breed = rs.getString("Breed");
                String farm = rs.getString("Farm");
                int age = rs.getInt("Age");
                int weight = rs.getInt("Weight");
                int milk = rs.getInt("MilkProduction");
                String heal = rs.getString("HealthStatus");

                Cows cows = new Cows(id, name, breed, farm, age, weight, milk, heal);
                products.add(cows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public Cows getAccountById(int id) {
        String sql = "SELECT * FROM Cows WHERE CowID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("Name");
                String breed = rs.getString("Breed");
                String farm = rs.getString("Farm");
                int age = rs.getInt("Age");
                int weight = rs.getInt("Weight");
                int milk = rs.getInt("MilkProduction");
                String heal = rs.getString("HealthStatus");

                Cows cows = new Cows(id, name, breed, farm, age, weight, milk, heal);
                return cows;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int update(Cows product) {
        String sql = "UPDATE Cows SET Name = ?, Breed = ?, Farm = ?, Age = ?, Weight = ?,  MilkProduction = ? , HealthStatus = ? WHERE CowID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setString(2, product.getBreed());
            ps.setString(3, product.getFarm());
            ps.setInt(4, product.getAge());
            ps.setInt(5, product.getWeight());
            ps.setInt(6, product.getMilkProduction());
            ps.setString(7, product.getHealthStatus());
            ps.setInt(8, product.getCowId());

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
        CowDAO td = new CowDAO();
//        List<Cows> tikTokAwardses = td.getAll();
//        for (Cows tikTokAwards : tikTokAwardses) {
//            System.out.println(tikTokAwards);
//        }

        int id = 1;
       Cows account = td.getAccountById(id);
        System.out.println(account);
////        int rs = ad.delete(id);
////        System.out.println(rs);
//        int res = td.update(new Product(6, "abc123", 10000, 10, "Chinane", new Category(2)));
//        System.out.println(res);
//         int num = td.insert(new Product(1, "abc", 10000, 10, "Chinane", new Category(1)));
//        System.out.println(num);
//        int delete= td.delete(7);
//        System.out.println(delete);
    }
}
