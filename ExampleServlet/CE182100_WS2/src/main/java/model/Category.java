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
    private String catId;
    private String catName;
    private String catDescription;

    public Category() {
    }

    public Category(String catId) {
        this.catId = catId;
    }

    public Category(String catId, String catName) {
        this.catId = catId;
        this.catName = catName;
    }
    
    public Category(String catId, String catName, String catDescription) {
        this.catId = catId;
        this.catName = catName;
        this.catDescription = catDescription;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    @Override
    public String toString() {
        return "Category{" + "catId=" + catId + ", catName=" + catName + ", catDescription=" + catDescription + '}';
    }
    
    
}
