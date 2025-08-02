/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Cows {

    private int cowID;
    private String name;
    private String breed;
    private String farm;
    private int age;
    private int weight;
    private int milkPro;
    private String healthStatus;

    public Cows() {
    }

    public Cows(int cowID, String name, String breed, String farm, int age, int weight, int milkPro, String healthStatus) {
        this.cowID = cowID;
        this.name = name;
        this.breed = breed;
        this.farm = farm;
        this.age = age;
        this.weight = weight;
        this.milkPro = milkPro;
        this.healthStatus = healthStatus;
    }

    public int getCowID() {
        return cowID;
    }

    public void setCowID(int cowID) {
        this.cowID = cowID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getFarm() {
        return farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMilkPro() {
        return milkPro;
    }

    public void setMilkPro(int milkPro) {
        this.milkPro = milkPro;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    @Override
    public String toString() {
        return "Cows{" + "cowID=" + cowID + ", name=" + name + ", breed=" + breed + ", farm=" + farm + ", age=" + age + ", weight=" + weight + ", milkPro=" + milkPro + ", healthStatus=" + healthStatus + '}';
    }
    
    
}
