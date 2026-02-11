package com.Javalianxi.da.duotai多态练习;

public class Vehicle {
    private String brand;
    private double speed;


    public Vehicle() {
    }

    public Vehicle(String brand, double speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public void move(){
        System.out.println(getBrand() + "以" + getSpeed() + "km/h的速度在移动");
    }
}
