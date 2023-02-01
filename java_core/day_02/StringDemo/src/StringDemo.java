public class StringDemo {
    public static void main(String[] args) {
        // Khai báo kiểu literal  tạo ra biến lưu trong 1 bộ nhớ string poll
        String name = "Nguyễn Kiên";
        String name1 = "Nguyễn Kiên";
        // Khai báo kiểu Object ( new ) tạo ra nhiều bộ nhớ mới để lưu trữ giá trị- link đến các biến tạo ra
        String email = new String("emmangthai.dungkhaianhlabo@gmail.com");
        String email1 = new String("emmangthai.dungkhaianhlabo@gmail.com");
        System.out.println("name : " + name);
        System.out.println("email : " + email);

        // So sánh chuỗi
        // == so sánh địa chỉ bộ nhớ( thường được áp dụng với primative type(kiểu dữ liệu nguyên thủy))
        // equal so sánh về mặt kí tự
        System.out.println(name == name1); // true
        System.out.println(email == email1); // false

        // phương thức String
        String text = "Xin chào các bạn";
        String text1 = "Xin chào các bạn";
        String text2 = "Xin cHào Các Bạn";

        System.out.println("In hoa : " + text.toUpperCase());
        System.out.println("In thường : " + text.toLowerCase());
        System.out.println("Độ dài : " + text.length());
        System.out.println("Cắt chuỗi : " + text.substring(0,8));  // lấy đến vị trí 8
        System.out.println("vị trí 10 là ký tự : " + text.charAt(9));
        System.out.println("Ký tự đầu tiên : " + text.indexOf(15));
        System.out.println("So sánh : " + text.equals(text1));
        System.out.println("So sánh không phân biệt hoa thường : " + text.equalsIgnoreCase(text2));
    }
}
