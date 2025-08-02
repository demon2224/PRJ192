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
import model.Movies;
import utils.DBContext;

/**
 *
 * @author Admin
 */
public class MoviesDAO extends DBContext {

    public MoviesDAO() {
        super();
    }

    public List<Movies> getAll() {
        List<Movies> products = new ArrayList<>();
        String sql = "SELECT * FROM Movies";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movies product = new Movies(rs.getInt("id"), rs.getString("title"), rs.getString("director"), rs.getInt("release_year"), rs.getDouble("rating"), rs.getBoolean("Is_rented"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public Movies getAccountById(int id) {
        String sql = "SELECT * FROM movies WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Movies product = new Movies(rs.getInt("id"), rs.getString("title"), rs.getString("director"), rs.getInt("release_year"), rs.getDouble("rating"), rs.getBoolean("Is_rented"));
                return product;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int insert(Movies product) {
        String sql = "INSERT [dbo].[movies] ([title], [director], [release_year], [rating], [Is_rented])"
                + "VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getTitle());
            ps.setString(2, product.getDirector());
            ps.setInt(3, product.getYear());
            ps.setDouble(4, product.getRating());
            ps.setBoolean(5, product.isRented());
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

    public int delete(int id) {
        String sql = "DELETE FROM movies WHERE id = ?";
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

    public int update(Movies product) {
        String sql = "UPDATE [dbo].[movies]\n"
                + "   SET [title] = ?\n"
                + "      ,[director] = ?\n"
                + "      ,[release_year] = ?\n"
                + "      ,[rating] = ?\n"
                + "      ,[Is_rented] = ? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getTitle());
            ps.setString(2, product.getDirector());
            ps.setInt(3, product.getYear());
            ps.setDouble(4, product.getRating());
            ps.setBoolean(5, product.isRented());
            ps.setInt(6, product.getId());

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
        MoviesDAO td = new MoviesDAO();
//        List<Movies> tikTokAwardses = td.getAll();
//        for (Movies tikTokAwards : tikTokAwardses) {
//            System.out.println(tikTokAwards);
//        }

        int id = 9;
//        Movies account = td.getAccountById(id);
//        System.out.println(account);
        int rs = td.delete(id);
        System.out.println(rs);
//        int res = td.update(new Movies(6, "abc123", 10000, 10, "Chinane", new Category(2)));
//        System.out.println(res);
//        int num = td.insert(new Movies("abc", "abc", 2015, 8.9, true));
//        System.out.println(num);
//        int delete= td.delete(7);
//        System.out.println(delete);
    }
}
