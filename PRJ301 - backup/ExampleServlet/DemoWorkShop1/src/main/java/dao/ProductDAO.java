/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import until.DBContext;

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
        String sql = "SELECT * FROM Product";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int pro_id = rs.getInt("pro_id");
                String pro_name = rs.getString("pro_name");
                long pro_price = rs.getLong("pro_price");
                int pro_quantity = rs.getInt("pro_quantity");
                String pro_description = rs.getString("pro_description");
                String cat_id = rs.getString("cat_id");
                Product product = new Product(pro_id, pro_name, pro_price, pro_quantity, pro_description, cat_id);
                products.add(product);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    
    public static void main(String[] args) {
        ProductDAO pd = new ProductDAO();
        List<Product> products = pd.getAll();
        for(Product product : products){
            System.out.println(product);
        }
    }
}
