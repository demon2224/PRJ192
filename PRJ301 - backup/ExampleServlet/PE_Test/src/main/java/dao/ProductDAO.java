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
import model.Product;
import utils.DBContext;

/**
 *
 * @author Admin
 */
public class ProductDAO extends DBContext {

    public ProductDAO() {
        super();
    }

    public List<Product> getAll() {
        List<Product> movieses = new ArrayList<>();
        String sql = "SELECT * FROM Product";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pro_id");
                String name = rs.getString("pro_name");
                int quantity = rs.getInt("pro_quan");
                long price = rs.getLong("pro_price");
                String des = rs.getString("pro_des");
                Product movies = new Product(id, name, quantity, price, des);
                movieses.add(movies);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieses;
    }

    public Product getAccountById(String id) {
        String sql = "SELECT * FROM Product WHERE pro_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("pro_name");
                int quantity = rs.getInt("pro_quan");
                long price = rs.getLong("pro_price");
                String des = rs.getString("pro_des");
                Product movies = new Product(id, name, quantity, price, des);
                return movies;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int insert(Product movies) {

        String sql = "INSERT INTO Product (pro_id, pro_name, pro_quan, pro_price, pro_des)"
                + "VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, movies.getpId());
            ps.setString(2, movies.getpName());
            ps.setInt(3, movies.getpQuan());
            ps.setLong(4, movies.getpPrice());
            ps.setString(5, movies.getpDes());
            int num = ps.executeUpdate();
            if (num > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }

    public int delete(String id) {
        String sql = "DELETE FROM Product WHERE pro_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
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

    public int update(Product movies) {
        String sql = "UPDATE Product SET pro_name = ?, pro_quan = ?, pro_price= ?, pro_des= ? WHERE pro_id= ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, movies.getpName());
            ps.setInt(2, movies.getpQuan());
            ps.setLong(3, movies.getpPrice());
            ps.setString(4, movies.getpDes());
            ps.setString(5, movies.getpId());

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
        ProductDAO td = new ProductDAO();
//        List<Movies> tikTokAwardses = td.getAll();
//        for (Movies tikTokAwards : tikTokAwardses) {
//            System.out.println(tikTokAwards);
//        }

//        int id = 1;
//        Movies account = td.getAccountById(id);
//        System.out.println(account);
//        int rs = ad.delete(id);
//        System.out.println(rs);
        int res = td.update(new Product("123", "IPhoneKha", 30, 1000000, "mew"));
        System.out.println(res);
//        int num = td.insert(new Product("123", "IPhone", 30, 1111110, "New"));
//        System.out.println(num);
//        int delete= td.delete(5);
//        System.out.println(delete);
    }
}
