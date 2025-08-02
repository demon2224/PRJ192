/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Cows;
import utils.DBContext;

/**
 *
 * @author Admin
 */
public class CowsDAO extends DBContext {

    public CowsDAO() {
        super();
    }

    public List<Cows> getAll() {
        List<Cows> products = new ArrayList<>();
        String sql = "SELECT * FROM Cows";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Cows product = new Cows(rs.getInt("CowID"), rs.getString("Name"), rs.getString("Breed"), rs.getString("Farm"), rs.getInt("Age"), rs.getInt("Weight"), rs.getInt("MilkProduction"), rs.getString("HealthStatus"));
                products.add(product);
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
                Cows product = new Cows(rs.getInt("CowID"), rs.getString("Name"), rs.getString("Breed"), rs.getString("Farm"), rs.getInt("Age"), rs.getInt("Weight"), rs.getInt("MilkProduction"), rs.getString("HealthStatus"));
                return product;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int update(Cows product) {
        String sql = "UPDATE [dbo].[Cows]\n"
                + "   SET [Name] = ?\n"
                + "      ,[Breed] = ?\n"
                + "      ,[Farm] = ?\n"
                + "      ,[Age] = ?\n"
                + "      ,[Weight] = ?\n"
                + "      ,[MilkProduction] = ?\n"
                + "      ,[HealthStatus] = ?\n"
                + " WHERE CowID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setString(2, product.getBreed());
            ps.setString(3, product.getFarm());
            ps.setInt(4, product.getAge());
            ps.setInt(5, product.getWeight());
            ps.setInt(6, product.getMilkPro());
            ps.setString(7, product.getHealthStatus());
            ps.setInt(8, product.getCowID());

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
        CowsDAO td = new CowsDAO();
//        List<Cows> tikTokAwardses = td.getAll();
//        for (Cows tikTokAwards : tikTokAwardses) {
//            System.out.println(tikTokAwards);
//        }

//        int id = 1;
//        Cows account = td.getAccountById(id);
//        System.out.println(account);
////        int rs = ad.delete(id);
////        System.out.println(rs);
        int res = td.update(new Cows(2,"Daisy123" , "Jersey", "Gree  Farm", 3, 460, 18, "Healthy"));
        System.out.println(res);
//         int num = td.insert(new Cows(1, "abc", 10000, 10, "Chinane", new Category(1)));
//        System.out.println(num);
//        int delete= td.delete(7);
//        System.out.println(delete);
    }
}
