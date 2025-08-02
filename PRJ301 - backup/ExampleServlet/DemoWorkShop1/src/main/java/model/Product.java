/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Product {

    private int pro_id;
    private String pro_name;
    private long pro_price;
    private int pro_quantity;
    private String pro_description;
    private String cat_id;

    public Product() {
    }

    public Product(int pro_id, String pro_name, long pro_price, int pro_quantity, String pro_description, String cat_id) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.pro_price = pro_price;
        this.pro_quantity = pro_quantity;
        this.pro_description = pro_description;
        this.cat_id = cat_id;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public long getPro_price() {
        return pro_price;
    }

    public void setPro_price(long pro_price) {
        this.pro_price = pro_price;
    }

    public int getPro_quantity() {
        return pro_quantity;
    }

    public void setPro_quantity(int pro_quantity) {
        this.pro_quantity = pro_quantity;
    }

    public String getPro_description() {
        return pro_description;
    }

    public void setPro_description(String pro_description) {
        this.pro_description = pro_description;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    @Override
    public String toString() {
        return "Product{" + "pro_id=" + pro_id + ", pro_name=" + pro_name + ", pro_price=" + pro_price + ", pro_quantity=" + pro_quantity + ", pro_description=" + pro_description + ", cat_id=" + cat_id + '}';
    }

}
