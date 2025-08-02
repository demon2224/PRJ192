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
import until.DBContext;

/**
 *
 * @author Admin
 */
public class CategoryDAO extends DBContext {

    public CategoryDAO() {
        super();
    }

    public List<Category> getAll() {
        List<Category> categorys = new ArrayList<>();
        String sql = "SELECT * FROM Category";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cat_id = rs.getString("cat_id");
                String cat_name = rs.getString("cat_name");
                Category category = new Category(cat_id, cat_name);
                categorys.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categorys;
    }
    public static void main(String[] args) {
        CategoryDAO cd = new CategoryDAO();
        List<Category> categorys = cd.getAll();
        for(Category category : categorys){
            System.out.println(category);
        }
    }
}
