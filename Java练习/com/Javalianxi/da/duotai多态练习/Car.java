package com.Javalianxi.da.duotai多态练习;

public class Car extends Vehicle {
    public Car() {
        super();
    }

    public Car(String brand, double speed) {
        super(brand, speed);
    }

    public void move() {
        System.out.println(getBrand() + "的汽车以" + getSpeed() + "km/h的速度在移动");
    }

    public void hook() {
        System.out.println("嘟嘟嘟...");
    }
}
