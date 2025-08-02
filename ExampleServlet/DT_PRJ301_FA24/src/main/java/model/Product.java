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

    private String pId;
    private String pName;
    private long pPrice;
    private int pQuan;
    private String pDes;
    private Category cat;

    public Product() {
    }

    public Product(String pId, String pName, long pPrice, int pQuan, String pDes, Category cat) {
        this.pId = pId;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pQuan = pQuan;
        this.pDes = pDes;
        this.cat = cat;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public long getpPrice() {
        return pPrice;
    }

    public void setpPrice(long pPrice) {
        this.pPrice = pPrice;
    }

    public int getpQuan() {
        return pQuan;
    }

    public void setpQuan(int pQuan) {
        this.pQuan = pQuan;
    }

    public String getpDes() {
        return pDes;
    }

    public void setpDes(String pDes) {
        this.pDes = pDes;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Product{" + "pId=" + pId + ", pName=" + pName + ", pPrice=" + pPrice + ", pQuan=" + pQuan + ", pDes=" + pDes + ", cat=" + cat + '}';
    }

    
}
