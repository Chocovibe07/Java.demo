package Java小练习.Java练习.da.duotai多态练习;




public class test {
    public static void main(String[] args) {
        Person p = new Person("小明", 20,"女");
        System.out.println(p.getName() + "的年龄是" + p.getAge() + "，性别是" + p.getGender());
        Vehicle b = new Bicycle("凤凰牌", 15.0);
        p.drive(b);
        Vehicle c = new Car("宝马", 120.0);
        p.drive(c);




    }
}
