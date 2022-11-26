import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        //Khởi tạo đối tượng scanner
        Scanner sc = new Scanner(System.in);  // sc là tên biến bất kỳ

        // Nhạp tên
        System.out.println("Nhập tên : ");
        String name = sc.nextLine();    //string name thì dùng .nextline  int thì dùng nextInt

        System.out.println("Nhập địa chỉ : ");
        String address = sc.nextLine();

        System.out.println("Nhập tuổi :");
        // Cách khắc phục trôi lẹnh
        // cách 1
        // int age = Integer.parseInt(sc.nextLine());  26 tuổi >> "26"
        // cách 2
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Nhập email : ");
        String email = sc.nextLine();
        //println : tự động xuống dòng
        // System.out.println("Tên tôi là : "+name+". Địa chỉ là : "+address+". Tuổi : "+age+ ". Email của tôi là : "+email);

        //print: ko xuống dòng
        System.out.print("tên : "+ name+"\n ");
        System.out.print("tuổi : "+age+"\n\t ");
        System.out.print("email : "+email+"\n\t\t ");
        System.out.print("địa chỉ : "+address+" \n ");

        //printf : in theo định dạng
        System.out.printf("Tên : %s\n", name);
        System.out.printf("Tuổi : %d\n", age);
        System.out.printf("Email : %s\n", email);
        System.out.printf("Địa chỉ : %s\n", address);

        System.out.println();
        System.out.printf("%-20s %-18s %-18s\n", "Họ tên", "Email", "Số điện thoại");   // dấu trừ là căn lề trái  20 là số ký tự
        System.out.printf("%-20s %-18s %-18d\n", "Bùi Văn Hiên", "hien@gmail.com", 25);
        System.out.printf("%-20s %-18s %-18d\n", "Nguyễn Thị Thu Hằng", "hien@gmail.com", 27);
        System.out.printf("%-20s %-18s %-18d\n", "Bùi Phương Loan", "hien@gmail.com", 18);


    }
}
