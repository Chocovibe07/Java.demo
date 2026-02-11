package com.Javalianxi.studentsystem;


import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作:");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("3.忘记密码");
            System.out.println("4.退出");
            String choose = sc.next();
            switch (choose) {
                case "1" -> login(list);
                case "2" -> register(list);
                case "3" -> forgetPassword(list);
                case "4" -> {
                    System.out.println("退出");
                    System.exit(0);
                }
                default -> System.out.println("没有此选项");
            }
        }

    }

    private static void forgetPassword(ArrayList<User> list) {
         Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        boolean flag = contains(list, username);
        if (!flag) {
            System.out.println("用户名不存在,请先注册");
            return;
        }
        //输入手机号和身份证号
        System.out.println("请输入手机号");
        String phone = sc.next();
        System.out.println("请输入身份证号");
        String id = sc.next();

         //需要先把用户对象获取出来
        int index = findIndex(list, username);
        User u = list.get(index);
        //验证手机号和身份证号是否匹配
        if (!phone.equals(u.getPhone()) || !id.equals(u.getId())) {
            System.out.println("手机号或身份证号不匹配,不能修改密码");
            return;
        }
        String newPassword;
        while (true) {
            System.out.println("请输入新密码");
            newPassword = sc.next();
            System.out.println("请再次输入新密码");
            String againPassword = sc.next();
            if (!newPassword.equals(againPassword)) {
                System.out.println("两次输入的密码不一致");
                continue;
            }else{
                System.out.println("修改密码成功");
                break;
            }
        }
        //直接修改
         u.setPassword(newPassword);
        System.out.println("修改密码成功");
    }

    private static int findIndex(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
             if (list.get(i).getUsername().equals(username)) {
                 return i;
             }
        }
        return -1;
    }

    private static void register(ArrayList<User> list) {
        System.out.println("注册");
        Scanner sc = new Scanner(System.in);
        String username;
        String password;
        String id;
        String phone;
        //输入用户名
        while (true) {
            System.out.println("请输入用户名");
            username = sc.next();
            //先验证格式是否正确，在验证是否唯一
            boolean flag1 = checkUsername(username);
            if (!flag1) {
                System.out.println("用户名格式不正确,请重新输入");
                continue;
            }
            //验证用户名唯一
            boolean flag2 = contains(list, username);
            if (flag2) {
                System.out.println("用户名已存在,请重新输入");
            } else {
                System.out.println("用户名可用");
                break;
            }
        }


        //输入密码
        System.out.println("请输入要注册的密码");
        password = sc.next();
        System.out.println("请再次输入要注册的密码");
        String againPassword = sc.next();
        while (!password.equals(againPassword)) {
            System.out.println("两次输入的密码不一致，请重新输入");
            password = sc.next();
            againPassword = sc.next();
        }
        System.out.println("两次密码一致，进入下一步");

        //输入身份证号
        while (true) {
            System.out.println("请输入身份证号");
            id = sc.next();
            boolean flag = checkId(id);
            //验证是否满足要求
            if (flag) {
                System.out.println("身份证格式正确");
                break;
            } else {
                System.out.println("身份证格式不正确，请重新输入");
            }
        }

        //输入手机号
        while (true) {
            System.out.println("请输入手机号");
            phone = sc.next();
            boolean flag = checkPhone(phone);
            if (flag) {
                System.out.println("手机号格式正确");
                break;
            } else {
                System.out.println("手机号格式不正确");
            }
        }
        //创建用户对象
        User u = new User(username, password, id, phone);
        list.add(u);
        System.out.println("注册成功");

        //遍历集合
        printList(list);
    }

    private static void printList(ArrayList<User> list) {
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            System.out.println(u.getUsername() + " " + u.getPassword() + " " + u.getId() + " " + u.getPhone());
        }
    }

    private static boolean checkPhone(String phone) {
        /*长度为11位 不能以0为开头 必须都是数字*/
        if (phone.length() != 11) {
            System.out.println("手机号长度必须为11位");
            return false;
        }
        if (phone.charAt(0) == '0') {
            System.out.println("手机号不能以0开头");
            return false;
        }
        for (int i = 0; i < phone.length(); i++) {
            char c = phone.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                System.out.println("手机号必须都是数字");
                return false;
            }
        }
        return true;
    }

    private static boolean checkId(String id) {
        /* 长度为18位
		不能以0为开头
		前17位，必须都是数字
		最为一位可以是数字，也可以是大写X或小写x*/
        if (id.length() != 18) {
            System.out.println("身份证长度必须为18位");
            return false;
        }
        if (id.charAt(0) == '0') {
            System.out.println("身份证不能以0开头");
            return false;
        }
        /*id.startsWith("0")*/
        for (int i = 0; i < id.length() - 1; i++) {
            char c = id.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                System.out.println("身份证前17位必须都是数字");
                return false;
            }
        }
        char endChar = id.charAt(17);
        if (!(endChar >= '0' && endChar <= '9' || endChar == 'X' || endChar == 'x')) {
            System.out.println("身份证最后一位必须是数字或大写X或小写x");
            return false;
        }
        return true;
    }

    private static boolean contains(ArrayList<User> list, String username) {
        for (User u : list) {
            if (u.getUsername().equals(username)) {
                System.out.println("用户名已存在");
                return true;
            }
        }
        //当循环结束
        return false;
    }

    private static boolean checkUsername(String username) {
        //用户名须满足3-15位，只能是数字、字母，不可以纯数字
        System.out.println("验证用户名格式");
        int len = username.length();
        if (len < 3 || len > 15) {
            System.out.println("用户名长度必须在3-15位之间");
            return false;
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            char c = username.charAt(i);
            if (!(c >= '0' && c <= '9') && !(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z')) {
                System.out.println("用户名只能是数字加字母");
                return false;
            }
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                //用户名不能纯数字
                count++;
                break;
            }
        }
        return count > 0;
    }

    private static void login(ArrayList<User> list) {
        System.out.println("登录");
        Scanner sc = new Scanner(System.in);
        String username = null;
        String password = null;
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名");
            username = sc.next();
            //判断用户名是否存在
            boolean flag = contains(list, username);
            if (!flag) {
                System.out.println("用户名不存在,请先注册");
                return;
            }
            System.out.println("请输入密码");
            password = sc.next();

            while (true) {
                String rightCode = getCode();
                System.out.println("验证码是" + rightCode);
                System.out.println("请输入验证码");
                String code = sc.next();
                //验证码验证，忽略大小写
                if (!rightCode.equalsIgnoreCase(code)) {
                    System.out.println("验证码错误");
                } else {
                    System.out.println("验证码正确");
                    break;
                }
            }
            //验证密码和用户名是否匹配
            //封装思想
            User useInfo = new User(username, password, null, null);
            boolean result = checkUserInfo(list, useInfo);
            if (result) {
                System.out.println("登录成功");
                return;
            } else {
                System.out.println("用户名或密码错误");
                if (i == 2) {
                    System.out.println("三次登录失败，账号被锁定");
                    break;
                    //当前账号锁定
                } else {
                    System.out.println("登录失败，请重新登录，还剩下" + (2 - i) + "次机会");
                }
            }
        }

    }

    private static boolean checkUserInfo(ArrayList<User> list, User useInfo) {
        //遍历集合，判断是否存在
        for (User u : list) {
            if (u.getUsername().equals(useInfo.getUsername()) && u.getPassword().equals(useInfo.getPassword())) {
                 return true;
            }
        }
        return false;
    }

    //生成一个验证码
    private static String getCode() {
        //创建一个hi和添加所有大小写字母
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));
            list.add((char) ('A' + i));
        }
        StringBuilder sb = new StringBuilder();
        //随机抽取4个字符
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list.size());
            //利用索引获取字符
            char c = list.get(index);
            //添加到StringBuilder中
            sb.append(c);
        }
        //随机生成一个数字添加到末尾
        int num = r.nextInt(10);
        sb.append(num);

        //修改字符串的内容
        char[] arr = sb.toString().toCharArray();
        //把最后一个索引和随机索引交换
        int index = r.nextInt(arr.length);
        //最大索引和随机索引换
        char temp = arr[arr.length - 1];
        arr[arr.length - 1] = arr[index];
        arr[index] = temp;
        return new String(arr);
    }

}

