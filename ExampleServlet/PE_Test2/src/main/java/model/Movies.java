/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Movies {

    private int id;
    private String title;
    private String director;
    private int year;
    private double rating;
    private boolean rented;

    public Movies() {
    }

    public Movies(String title, String director, int year, double rating, boolean rented) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.rented = rented;
    }
    
    

    public Movies(int id, String title, String director, int year, double rating, boolean rented) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.rented = rented;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        return "Movies{" + "id=" + id + ", title=" + title + ", director=" + director + ", year=" + year + ", rating=" + rating + ", rented=" + rented + '}';
    }

    

}
