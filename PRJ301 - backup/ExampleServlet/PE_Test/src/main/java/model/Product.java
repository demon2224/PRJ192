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
    private int pQuan;
    private long pPrice;
    private String pDes;

    public Product() {
    }

    public Product(String pId, String pName, int pQuan, long pPrice, String pDes) {
        this.pId = pId;
        this.pName = pName;
        this.pQuan = pQuan;
        this.pPrice = pPrice;
        this.pDes = pDes;
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

    public int getpQuan() {
        return pQuan;
    }

    public void setpQuan(int pQuan) {
        this.pQuan = pQuan;
    }

    public long getpPrice() {
        return pPrice;
    }

    public void setpPrice(long pPrice) {
        this.pPrice = pPrice;
    }

    public String getpDes() {
        return pDes;
    }

    public void setpDes(String pDes) {
        this.pDes = pDes;
    }

    @Override
    public String toString() {
        return "Product{" + "pId=" + pId + ", pName=" + pName + ", pQuan=" + pQuan + ", pPrice=" + pPrice + ", pDes=" + pDes + '}';
    }

}
