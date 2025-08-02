/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Category {

    private String cat_idString;
    private String cat_name;

    public Category() {
    }

    public Category(String cat_idString, String cat_name) {
        this.cat_idString = cat_idString;
        this.cat_name = cat_name;
    }

    public String getCat_idString() {
        return cat_idString;
    }

    public void setCat_idString(String cat_idString) {
        this.cat_idString = cat_idString;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    @Override
    public String toString() {
        return "Category{" + "cat_idString=" + cat_idString + ", cat_name=" + cat_name + '}';
    }

}
