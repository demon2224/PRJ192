/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Account {

    private int _id;
    private String _username;
    private String _password;
    private String _fullname;

    public Account() {
        this._id = -1;
        this._username = "";
        this._password = "";
        this._fullname = "";
    }

    public Account(int _id, String _username, String _password, String _fullname) {
        this._id = _id;
        this._username = _username;
        this._password = _password;
        this._fullname = _fullname;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String _username) {
        this._username = _username;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public String getFullname() {
        return _fullname;
    }

    public void setFullname(String _fullname) {
        this._fullname = _fullname;
    }

    @Override
    public String toString() {
        return "Account{" + "_id=" + _id + ", _username=" + _username + ", _password=" + _password + ", _fullname=" + _fullname + '}';
    }
    
    
    
    public static boolean isEmpty(Account account) {
        return account.getId() < 0 && account.getUsername().isEmpty();
    }
}
