package com.Javalianxi.studentsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();
        loop:
        while (true) {
            System.out.println("-----欢迎来到学生管理系统-----");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查询学生");
            System.out.println("5.退出");
            System.out.println("请输入你的选择：");
            String choose = sc.next();
            switch (choose) {
                case "1" -> addStudent(list);
                case "2" -> deleteStudent(list);
                case "3" -> updateStudent(list);
                case "4" -> queryStudent(list);
                case "5" -> {
                    System.out.println("退出");
                    break loop;
                }
                default -> System.out.println("没有此选项");
            }
        }
    }

    // 添加学生
    public static void addStudent(ArrayList<Student> list) {
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        String id = null;
        while (true) {
            System.out.println("请输入学生id：");
            id = sc.next();
            boolean flag = isExist(list, id);
            if (flag) {
                System.out.println("该id已存在,请重新输入");
            } else {
                s.setId(id);
                break;
            }
        }

        System.out.println("请输入学生姓名：");
        String name = sc.next();
        s.setName(name);

        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();
        s.setAge(age);

        System.out.println("请输入学生地址：");
        String address = sc.next();
        s.setAddress(address); // 修正 setId 为 setAddress

        list.add(s);
        System.out.println("添加学生成功");
    }

    // 删除学生
    public static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的id：");
        String id = sc.next();
        // 通过id获取索引的方法
        int index = getIndex(list, id);
        // 判断索引，如果是-1，说明没有找到该学生
        if (index != -1) {
            list.remove(index);
            System.out.println("id为:" + id + "的学生删除成功");
        } else {
            System.out.println("未找到该学生,删除失败");
        }
    }

    // 修改学生
    public static void updateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生id：");
        String id = sc.next();
        int index = getIndex(list, id);
        if (index != -1) {
            Student s = list.get(index);
            System.out.println(s.getId() + "\t\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getAddress());
            System.out.println("1.修改id");
            System.out.println("2.修改姓名");
            System.out.println("3.修改年龄");
            System.out.println("4.修改地址");
            System.out.println("请选择要修改的信息:");
            int num = sc.nextInt();
            switch (num) {
                case 1 -> {
                    System.out.println("请输入新的id：");
                    s.setId(sc.next());
                }
                case 2 -> {
                    System.out.println("请输入新的姓名：");
                    s.setName(sc.next());
                }
                case 3 -> {
                    System.out.println("请输入新的年龄：");
                    s.setAge(sc.nextInt());
                }
                case 4 -> {
                    System.out.println("请输入新的地址：");
                    s.setAddress(sc.next());
                }
            }
            System.out.println("修改成功");
        } else {
            System.out.println("未找到该学生");
        }
    }

    // 查询学生
    public static void queryStudent(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("没有该学生信息，请添加后再查询");
            return;
        }
        System.out.println("id\t\t姓名\t年龄\t地址");
        for (Student s : list) {
            System.out.println(s.getId() + "\t\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getAddress());
        }
    }

    // 判断输入的id是否在list集合中
    public static boolean isExist(ArrayList<Student> list, String id) {
        /*for (Student s : list) {
            if (s.getId().equals(id)) {
                return true;
            }
        }
        return false;*/
        return getIndex(list, id) >= 0;
    }

    // 通过id获取索引的方法
    public static int getIndex(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            if (s.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }


    //注册界面
    public static void Register() {
        System.out.println("请输入用户名");
        Scanner sc = new Scanner(System.in);
        String username = sc.next();

        System.out.println("请输入密码");
        String password = sc.next();
        System.out.println("请输入身份证号");
        String id = sc.next();
        System.out.println("请输入手机号");
        String phone = sc.next();
    }

    }
