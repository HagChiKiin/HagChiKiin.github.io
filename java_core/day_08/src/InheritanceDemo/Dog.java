package InheritanceDemo;

public class Dog extends Animal{
    private String color;
    private int legs;

    public Dog() {
    }

    public Dog(String name, String color, int legs) {
        super(name);
        this.color = color;
        this.legs = legs;
    }

    // Định nghĩa phương thức của lớp con
    public void display() {
        System.out.println("My name is " + this.getName()+" màu "+color+" "+legs+" chân");
    }

    @Override   // ghi đè phương thức của lớp cha
    public void eat() {
        super.eat();// gọi phương thức của lớp cha
        System.out.println("Chó ăn c*c");// logic của lớp con
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }
}
