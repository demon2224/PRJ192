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
import model.Order;
import utils.DBContext;

/**
 *
 * @author Admin
 */
public class OrderDAO extends DBContext {

    public OrderDAO() {
        super();
    }

    public List<Order> getAll() {
        List<Order> products = new ArrayList<>();
        String sql = "SELECT * FROM  [dbo].[Order]";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order product = new Order(rs.getString("order_id"), rs.getString("username"), rs.getInt("order_total"), rs.getDate("order_date"), rs.getString("order_des"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public Order getAccountById(String id) {
        String sql = "SELECT * FROM [dbo].[Order] WHERE order_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Order product = new Order(rs.getString("order_id"), rs.getString("username"), rs.getInt("order_total"), rs.getDate("order_date"), rs.getString("order_des"));
                return product;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int insert(Order product) {
        String sql = "INSERT INTO [dbo].[Order]\n"
                + "           ([order_id]\n"
                + "           ,[username]\n"
                + "           ,[order_total]\n"
                + "           ,[order_date]\n"
                + "           ,[order_des])"
                + "VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getUsername());;
            ps.setInt(3, product.getTotal());
            ps.setDate(4, product.getDate());
            ps.setString(5, product.getDesString());

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
        String sql = "DELETE FROM [dbo].[Order] WHERE order_id = ?";
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

    public int update(Order product) {
        String sql = "UPDATE [dbo].[Order]\n"
                + "   SET [username] = ?\n "
                + "      ,[order_total] = ?\n"
                + "      ,[order_date] = ?\n"
                + "      ,[order_des] = ? WHERE order_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getUsername());;
            ps.setInt(2, product.getTotal());
            ps.setDate(3, product.getDate());
            ps.setString(4, product.getDesString());
            ps.setString(5, product.getId());

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
        OrderDAO td = new OrderDAO();
//        List<Order> tikTokAwardses = td.getAll();
//        for (Order tikTokAwards : tikTokAwardses) {
//            System.out.println(tikTokAwards);
//        }

//        int id = 1;
        Order account = td.getAccountById("1");
        System.out.println(account);
////        int rs = ad.delete(id);
////        System.out.println(rs);
//        int res = td.update(new Order(6, "abc123", 10000, 10, "Chinane", new Category(2)));
//        System.out.println(res);
//        java.sql.Date date = java.sql.Date.valueOf("2004-11-28");
//        int num = td.insert(new Order("2", "abc", 10, date, "abc"));
//        System.out.println(num);
//        int delete= td.delete(7);
//        System.out.println(delete);
    }
}
