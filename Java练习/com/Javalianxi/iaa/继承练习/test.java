package com.Javalianxi.iaa.继承练习;

public class test {
     public static void main(String[] args) {
        BachelorStudent b = new BachelorStudent("小王", 18, "2019001", "软件");
System.out.println("姓名："+b.getName()+"，年龄："+b.getAge()+"，学号："+b.getSno()+"，专业："+b.getMajor());
  b.attendLecture();
  b.study();
  b.eat();


}
}
