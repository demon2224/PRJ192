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
    private String id, username;
    private int  total;
    private Date  date;
    private String  desString;

    public Order() {
    }

    public Order(String id, String username, int total, Date date, String desString) {
        this.id = id;
        this.username = username;
        this.total = total;
        this.date = date;
        this.desString = desString;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDesString() {
        return desString;
    }

    public void setDesString(String desString) {
        this.desString = desString;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", username=" + username + ", total=" + total + ", date=" + date + ", desString=" + desString + '}';
    }
    
    
}
