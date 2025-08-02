/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Job {
    private int id;
    private String title , comapany , location ;
    private Application application;

    public Job(int id, String title, String comapany, String location, Application application) {
        this.id = id;
        this.title = title;
        this.comapany = comapany;
        this.location = location;
        this.application = application;
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

    public String getComapany() {
        return comapany;
    }

    public void setComapany(String comapany) {
        this.comapany = comapany;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    @Override
    public String toString() {
        return "Job{" + "id=" + id + ", title=" + title + ", comapany=" + comapany + ", location=" + location + ", application=" + application + '}';
    }

    

   
    
}
