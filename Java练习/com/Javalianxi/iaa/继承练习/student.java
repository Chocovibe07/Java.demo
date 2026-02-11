package com.Javalianxi.iaa.继承练习;

public class student extends person {
    private String sno;

    public student() {
    }

    public student(String name, int age, String sno) {
        super(name, age);
        this.sno = sno;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public void study() {
        System.out.println("学习");
    }

    @Override
    public void show() {
        super.show();
        System.out.println("学号：" + sno);
    }
}
