/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Order {

    private String oId;
    private String username;
    private int oTotal;
    private Date oDate;
    private String oDes;

    public Order() {
    }

    public Order(String oId, String username, int oTotal, Date oDate, String oDes) {
        this.oId = oId;
        this.username = username;
        this.oTotal = oTotal;
        this.oDate = oDate;
        this.oDes = oDes;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getoTotal() {
        return oTotal;
    }

    public void setoTotal(int oTotal) {
        this.oTotal = oTotal;
    }

    public Date getoDate() {
        return oDate;
    }

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    public String getoDes() {
        return oDes;
    }

    public void setoDes(String oDes) {
        this.oDes = oDes;
    }

    @Override
    public String toString() {
        return "Order{" + "oId=" + oId + ", username=" + username + ", oTotal=" + oTotal + ", oDate=" + oDate + ", oDes=" + oDes + '}';
    }
    
    

}
