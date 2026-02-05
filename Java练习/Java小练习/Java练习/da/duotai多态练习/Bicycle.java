package Java小练习.Java练习.da.duotai多态练习;

public class Bicycle extends Vehicle {
  public Bicycle() {
    super();
  }
  public Bicycle(String brand, double speed) {
    super(brand, speed);
  }

  public void move() {
    System.out.println(getBrand() + "的自行车以" + getSpeed() + "km/h的速度在移动");
  }
  public void ringBell() {
    System.out.println("叮铃铃...");
  }
}
