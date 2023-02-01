package interface_demo;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
    IShape iShape = new Rectangle(4,5);
        System.out.println(iShape.getArea());
        System.out.println(iShape.getPerimeter());
    IShape iShape1 = new Square(5);
        System.out.println(iShape1.getArea());
        System.out.println(iShape1.getPerimeter());

        ArrayList<IShape> shapes = new ArrayList<>();
        shapes.add(iShape);
        shapes.add(iShape1);
        shapes.add(new Rectangle(5,2));
        shapes.add(new Square(7));
        System.out.println("Danh sách hình");
        for (IShape s : shapes
             ) {
            System.out.println(s.getArea());
            System.out.println(s.getPerimeter());
        }
        // In ra thông tin của hình vuông có trong ds + diện tích = chu vi
        System.out.println("Danh sách hình vuông"); // sẽ có 2 hình 5 vs 7
        for (IShape s : shapes
        ) {
            if(s instanceof Square){  // kiểm tra xem đối tượng này có phải là instance
                // của một class hay interface nào đó hay không? Kết quả trả về của toán tử
                // này sẽ là true nếu đối tượng đó là thể hiện của class mà các bạn đang check, ngược lại thì false
                System.out.println(s.getArea());
                System.out.println(s.getPerimeter());
            }
        }
        System.out.println(IShape.message);
        iShape1.sayHello();
        iShape.sayHello();
        IShape.hi(); // static dùng tên interface để gọi ( ten class)
            

    }
}
