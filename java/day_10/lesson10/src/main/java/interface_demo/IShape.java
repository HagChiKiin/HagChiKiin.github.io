package interface_demo;

public interface IShape {
    String message = "shape"; // public, static: truy cập được dựa trên class, final: k thể thay đổi
    double getArea();
    double getPerimeter();
    default void sayHello(){
        System.out.println("Hello shape");
    }
    static void hi(){
        System.out.println("hi shape");
    }
}
