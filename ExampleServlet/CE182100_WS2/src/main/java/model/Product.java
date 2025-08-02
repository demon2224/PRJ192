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
    private String proId;
    private String proNameString;
    private long proPrice;
    private int proQuantity;
    private String proDescription;
    private Category cat;

    public Product() {
    }

    public Product(String proId, String proNameString, long proPrice, int proQuantity, String proDescription, Category cat) {
        this.proId = proId;
        this.proNameString = proNameString;
        this.proPrice = proPrice;
        this.proQuantity = proQuantity;
        this.proDescription = proDescription;
        this.cat = cat;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProNameString() {
        return proNameString;
    }

    public void setProNameString(String proNameString) {
        this.proNameString = proNameString;
    }

    public long getProPrice() {
        return proPrice;
    }

    public void setProPrice(long proPrice) {
        this.proPrice = proPrice;
    }

    public int getProQuantity() {
        return proQuantity;
    }

    public void setProQuantity(int proQuantity) {
        this.proQuantity = proQuantity;
    }

    public String getProDescription() {
        return proDescription;
    }

    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Product{" + "proId=" + proId + ", proNameString=" + proNameString + ", proPrice=" + proPrice + ", proQuantity=" + proQuantity + ", proDescription=" + proDescription + ", cat=" + cat + '}';
    }
    
    
}
