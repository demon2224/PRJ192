/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class TikTokAwards {
    private int Id;
    private String name;
    private String Account;
    private String Category;
    private int Years;

    public TikTokAwards() {
    }

    public TikTokAwards(int Id, String name, String Account, String Category, int Years) {
        this.Id = Id;
        this.name = name;
        this.Account = Account;
        this.Category = Category;
        this.Years = Years;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String Account) {
        this.Account = Account;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public int getYears() {
        return Years;
    }

    public void setYears(int Years) {
        this.Years = Years;
    }

    @Override
    public String toString() {
        return "TikTokAwards{" + "Id=" + Id + ", name=" + name + ", Account=" + Account + ", Category=" + Category + ", Years=" + Years + '}';
    }
    
    
    
    
}
