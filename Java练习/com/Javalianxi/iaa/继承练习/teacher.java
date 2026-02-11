package com.Javalianxi.iaa.继承练习;

public class teacher extends person {
    private String tno;

    public teacher() {
    }

    public teacher(String name, int age, String tno) {
        super(name, age);
        this.tno = tno;
    }

    public void teach() {
        System.out.println("教学");
    }

    @Override
    public void show() {
        super.show();
        System.out.println("工号：" + tno);
    }

}
