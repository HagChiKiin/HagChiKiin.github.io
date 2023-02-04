public class String_Character {
    public static void main(String[] args) {
        String str = "abc123";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.print((int) c + " "); // ép kieu cho Character đó sẽ ra trên bảng mã ASCII Table
        }
        System.out.println("------------");

        String str1 = "hello:world:hi:goodbye";
        System.out.println(str1.replace('l', (char) 3));
        System.out.println("----------------");
        System.out.println(Character.isDigit('9'));  // kiểm tra có phải số ko
        System.out.println(Character.isLetter('n'));  // kiểm tra có phải chữ ko
        System.out.println(('A' < 'B')); // so sánh
        System.out.println(('6' - 'B')); // trừ
        System.out.println(str1.split(""));

        // Khi sử dụng thuật toán so sánh thì su dụng equal
        // toán tử == so sánh oject lưu trữ . dữ liệu sẽ đc lấy trong string pool( khai báo trực tiếp)
        // new String thì sẽ tạo ra oject mới lưu trữ
    }
}

