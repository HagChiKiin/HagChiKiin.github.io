public class Main {
    public  String globalVar = "Global variable";
    // phạm vi global  khai báo bên ngoài method

    // phạm vi method : khai báo bên trong method
    // phạm vi block: khai báo bên trong {}

    public static void main(String[] args) {

        // Khai báo biến
        String firstName;
        String lastName;
        String email = "emmangthai.dungkhaianhlabo@gmail.com";
        //gán giá trị
        firstName = "Nguyễn";
        lastName = "Kiên";
        double canNang = 60.5;
        String fullName = firstName + " " + lastName;
        int age = 29;
        String address = "Đông Anh";

        System.out.println("họ : " + firstName);
        System.out.println("tên : " + lastName);
        System.out.println("họ và tên : "+ fullName);
        System.out.println("Xin chào, tôi tên là " + fullName +" "+".Năm nay tôi "+ age + " tuổi. Quê tôi ở "+ address );

        boolean isExist = true;
        boolean isMarried = false;
        char character = 'A';
        char characterB= 66;
        System.out.println(character);
        System.out.println(characterB);

    // ép kiểu
        //ép kiểu ngầm định: từ nhỏ sang lớn
        int number = 10;
        long numberOne = number;
        //ép kiểu tường minh : từ lớn về nhỏ
        short numberTwo = (short) number;
    }

}