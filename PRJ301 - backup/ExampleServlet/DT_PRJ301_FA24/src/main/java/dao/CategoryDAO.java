/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;
import utils.DBContext;

/**
 *
 * @author Admin
 */
public class CategoryDAO extends DBContext{
     public CategoryDAO() {
        super();
    }

    public List<Category> getAll() {
        List<Category> categorys = new ArrayList<>();
        String sql = "SELECT *  FROM category";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
      
                String catId = rs.getString("cat_id");
                String catName = rs.getString("cat_name");
                Category category = new Category(catId, catName);
                categorys.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categorys;
    }
    public static void main(String[] args) {
        CategoryDAO td = new CategoryDAO();
        List<Category> tikTokAwardses = td.getAll();
        for (Category tikTokAwards : tikTokAwardses) {
            System.out.println(tikTokAwards);
        }

//        int id = 1;
////        Movies account = td.getAccountById(id);
////        System.out.println(account);
////        int rs = ad.delete(id);
////        System.out.println(rs);
////        int res = td.update(new Movies(1, "Inception", "Christopher Nolan", 2010, 8.8, false));
////        System.out.println(res);
////         int num = td.insert(new Movies("abc", "abc1223", 2024, 8.9, true));
////        System.out.println(num);
//        int delete= td.delete(5);
//        System.out.println(delete);
    }
}
