package com.Javalianxi.iaa.继承练习;

public class majorteacher extends teacher {
    private String mno;
    public majorteacher() {
    }
    public majorteacher(String name, int age, String tno, String mno) {
        super(name, age, tno);
        this.mno = mno;
    }
    public void show() {
        super.show();
        System.out.println("编号：" + mno);
    }
    public void teach() {
        System.out.println("教专业课");
    }

}
