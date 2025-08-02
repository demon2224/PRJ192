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
import model.Category;
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
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.pro_id, p.pro_name, p.pro_price, p.pro_quantity, p.pro_description, "
                + "c.cat_id, c.cat_name FROM product p "
                + "JOIN category c ON p.cat_id = c.cat_id";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String proID = rs.getString("pro_id");
                String proName = rs.getString("pro_name");
                long proPrice = rs.getLong("pro_price");
                int proQuantity = rs.getInt("pro_quantity");
                String proDescription = rs.getString("pro_description");
                String catId = rs.getString("cat_id");
                String catName = rs.getString("cat_name");
                Category category = new Category(catId, catName);
                Product product = new Product(proID, proName, proPrice, proQuantity, proDescription, category);
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getAccountById(String id) {
        String sql = "SELECT * FROM product WHERE pro_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String proName = rs.getString("pro_name");
                long proPrice = rs.getLong("pro_price");
                int proQuantity = rs.getInt("pro_quantity");
                String proDescription = rs.getString("pro_description");
                String catId = rs.getString("cat_id");
                Category category = new Category(catId);
                Product product = new Product(id, proName, proPrice, proQuantity, proDescription, category);
                return product;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int insert(Product  product) {
        String sql = "INSERT INTO product (pro_id,  pro_name, pro_price,  pro_quantity, pro_description, cat_id)"
                + "VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getProId());
            ps.setString(2, product.getProNameString());
            ps.setLong(3, product.getProPrice());
            ps.setInt(4, product.getProQuantity());
            ps.setString(5, product.getProDescription());
            ps.setString(6, product.getCat().getCatId());
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
        String sql = "DELETE FROM product WHERE pro_id = ?";
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

    public int update(Product product) {
        String sql = "UPDATE product SET pro_name = ?, pro_price = ?,  pro_quantity = ?, pro_description = ?, cat_id = ? WHERE pro_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getProNameString());
            ps.setLong(2, product.getProPrice());
            ps.setInt(3, product.getProQuantity());
            ps.setString(4, product.getProDescription());
            ps.setString(5, product.getCat().getCatId());
            ps.setString(6, product.getProId());

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
//        List<Product> tikTokAwardses = td.getAll();
//        for (Product tikTokAwards : tikTokAwardses) {
//            System.out.println(tikTokAwards);
//        }

//        int id = 1;
//        Product account = td.getAccountById(id);
//        System.out.println(account);
////        int rs = ad.delete(id);
////        System.out.println(rs);
        int res = td.update(new Product("6", "abc123", 10000, 10, "Chinane", new Category("2")));
        System.out.println(res);
//         int num = td.insert(new Product(1, "abc", 10000, 10, "Chinane", new Category(1)));
//        System.out.println(num);
//        int delete= td.delete(7);
//        System.out.println(delete);
    }
}
