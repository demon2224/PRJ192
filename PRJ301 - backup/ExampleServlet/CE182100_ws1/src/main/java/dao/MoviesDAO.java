/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.sun.org.apache.xpath.internal.operations.Mod;
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
        List<Movies> movieses = new ArrayList<>();
        String sql = "SELECT * FROM movies";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String director = rs.getString("director");
                int release_year = rs.getInt("release_year");
                double rating = rs.getDouble("rating");
                boolean Is_rented = rs.getBoolean("Is_rented");
                Movies movies = new Movies(id, title, director, release_year, rating, Is_rented);
                movieses.add(movies);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieses;
    }

    public Movies getAccountById(int id) {
        String sql = "SELECT * FROM movies WHERE ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String title = rs.getString("title");
                String director = rs.getString("director");
                int release_year = rs.getInt("release_year");
                double rating = rs.getDouble("rating");
                boolean Is_rented = rs.getBoolean("Is_rented");
                Movies movies = new Movies(id, title, director, release_year, rating, Is_rented);
                return movies;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int insert(Movies movies) {
        String sqlGetMaxId = "SELECT MAX(ID) AS maxId FROM movies";
        try {
            PreparedStatement psGetMaxId = conn.prepareStatement(sqlGetMaxId);
            ResultSet rsMaxId = psGetMaxId.executeQuery();
            if (rsMaxId.next()) {
                int nextId = rsMaxId.getInt("maxId") + 1;
                String sql = "INSERT INTO movies (id, title, director, release_year, rating,Is_rented)"
                        + "VALUES(?, ?, ?, ?, ?, ?)";
                try {
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, nextId);
                    ps.setString(2, movies.getTitle());
                    ps.setString(3, movies.getDirector());
                    ps.setInt(4, movies.getRelease_year());
                    ps.setDouble(5, movies.getRating());
                    ps.setBoolean(6, movies.isIs_rented());
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

    public int delete(int id) {
        String sql = "DELETE FROM movies WHERE ID = ?";
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

    public int update(Movies movies) {
        String sql = "UPDATE movies SET title = ?, director = ?, release_year = ?, rating = ?, Is_rented = ?  where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, movies.getTitle());
            ps.setString(2, movies.getDirector());
            ps.setInt(3, movies.getRelease_year());
            ps.setDouble(4, movies.getRating());
            ps.setBoolean(5, movies.isIs_rented());
            ps.setInt(6, movies.getId());

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

        int id = 1;
//        Movies account = td.getAccountById(id);
//        System.out.println(account);
//        int rs = ad.delete(id);
//        System.out.println(rs);
//        int res = td.update(new Movies(1, "Inception", "Christopher Nolan", 2010, 8.8, false));
//        System.out.println(res);
//         int num = td.insert(new Movies("abc", "abc1223", 2024, 8.9, true));
//        System.out.println(num);
        int delete= td.delete(5);
        System.out.println(delete);
    }
}
