package exception_demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckCallstack {
    public static void main(String[] args) {
        methodThree();
    }
    public  static void methodOne() throws FileNotFoundException {
        System.out.println("One");
        File file = new File("text.txt");
        FileReader fileReader =new FileReader(file);

    }
    public static void methodTwo() throws FileNotFoundException{  // Nếu xử lý thì đặt câu lệnh try catch..
        System.out.println("Two"); // Nối không - thông báo bằng câu lệnh throws FileNotFoundException
        methodOne();
    }
    public static void methodThree() {  // Xử lý try catch ở đây
        System.out.println("Three");
        try {
            methodTwo();                                    // Xử lý ở phương thức nào cũng được
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
