import java.util.Scanner;

public class Introduce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên : ");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi : ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập giới tính : ");
        String gender = sc.nextLine();
        System.out.println("Nhập địa chỉ : ");
        String address = sc.nextLine();

        System.out.println("Xin chào các bạn, mình tên là "
                + name + ", năm nay mình "
                + age + " tuổi, "
                + "giới tính "
                + gender + ". Hiện tại mình đang sống và làm việc tại " + address);
    }
}
