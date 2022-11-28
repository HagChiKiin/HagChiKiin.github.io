public class Scanner2 {
    public static void main(String[] args) {
        String text = "Xin Chào Các Bạn";
        String text1 = "hello";
        System.out.println(text);
        System.out.println("Chuỗi in hoa của chuỗi \"" + text +"\"" + " là:  " + text.toUpperCase());
        System.out.println("Chuỗi in thường của chuỗi \"" + text +"\"" + " là:  " + text.toLowerCase());
        System.out.println("Số ký tự của chuỗi \"" + text +"\"" + " là: " + text.length());
        System.out.println("Ký tự cuối cùng của chuỗi \"" + text +"\"" + " là: " + text.charAt(15));
        System.out.println("5 ký tự đầu tiên của chuỗi \"" + text +"\"" + " là: " + text.substring(0,5));

        System.out.println("Chuỗi \"" + text +"\"" + " có chứa chuỗi " + "\""+ text1 + "\"" + " hay không : " + text.contains(text1));



    }
}
