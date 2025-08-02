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
public class Account {

    private String username, passwordString, fullnameString, genderString;
    private Date birthDay;
    private String department;

    public Account() {
        this.username = null;
    }

    public Account(String username, String passwordString, String fullnameString, String genderString, Date birthDay, String department) {
        this.username = username;
        this.passwordString = passwordString;
        this.fullnameString = fullnameString;
        this.genderString = genderString;
        this.birthDay = birthDay;
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordString() {
        return passwordString;
    }

    public void setPasswordString(String passwordString) {
        this.passwordString = passwordString;
    }

    public String getFullnameString() {
        return fullnameString;
    }

    public void setFullnameString(String fullnameString) {
        this.fullnameString = fullnameString;
    }

    public String getGenderString() {
        return genderString;
    }

    public void setGenderString(String genderString) {
        this.genderString = genderString;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", passwordString=" + passwordString + ", fullnameString=" + fullnameString + ", genderString=" + genderString + ", birthDay=" + birthDay + ", department=" + department + '}';
    }

}
