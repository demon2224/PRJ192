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
    private int release_year;
    private double rating;
    private boolean Is_rented;

    public Movies() {
    }

    public Movies(String title, String director, int release_year, double rating, boolean Is_rented) {
        this.title = title;
        this.director = director;
        this.release_year = release_year;
        this.rating = rating;
        this.Is_rented = Is_rented;
    }

    
    public Movies(int id, String title, String director, int release_year, double rating, boolean Is_rented) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.release_year = release_year;
        this.rating = rating;
        this.Is_rented = Is_rented;
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

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isIs_rented() {
        return Is_rented;
    }

    public void setIs_rented(boolean Is_rented) {
        this.Is_rented = Is_rented;
    }

    @Override
    public String toString() {
        return "movies{" + "id=" + id + ", title=" + title + ", director=" + director + ", release_year=" + release_year + ", rating=" + rating + ", Is_rented=" + Is_rented + '}';
    }

    
}
