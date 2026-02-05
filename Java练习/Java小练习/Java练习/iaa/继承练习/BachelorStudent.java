package Java小练习.Java练习.iaa.继承练习;

public class BachelorStudent extends student {
    private String major;

    public BachelorStudent() {
    }

    public BachelorStudent(String name, int age, String sno, String major) {
        super(name, age, sno);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void attendLecture() {
        System.out.println("正在攻读本科内容");
    }

    @Override
    public void show() {
        super.show();
        System.out.println("专业：" + major);
    }

    @Override
    public void sleep() {
        System.out.println("本科生睡觉时间较晚");
    }
}
