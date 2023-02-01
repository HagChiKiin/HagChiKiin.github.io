public class baitap1 {
    // Khai báo hằng số global
    public static final String EMAIL = "emmangthai.dungkhaianhlabo@gmail.com";
    public static void main(String[] args) {            //in ở trong này
        System.out.println("Xin chào các bạn");
        hello1("kien");
        hello2("cac");
        System.out.println(sumTwoNumber(3,4));
    }

    public static void hello1(String name) {            // viết thêm khai báo  hello1: phương thức

        System.out.println("Xin chào " + name);
    }

    public static void hello2(String cac2) {

        System.out.println("Xin chào \"" + cac2 + "\"");
    }


//        double sum = tong2so(3.5 , 8);
//        System.out.println(sum);
//
//        double data = binhPhuong(5.5);
//        System.out.println(data);
//
//       int the_ky = theKy(2022);
//        System.out.println(the_ky);
//
//        double data3 = bmi(70.5 ,1.68);
//        System.out.println(data3);


    public static double sumTwoNumber(double a, double b){
        return a + b;
    }
    public static double square(double c){
        return c * c;
    }
    public static int cenTuRy(double d) {
        double century = d / 100;
        return  (int) Math.ceil(century)  ;
    }
    public static double bmi(double h, double w){
        return h / (w*w);
    }
}

// phương thức nên có động từ
//        đặt tên nên có nghĩa + tên tếng anh
//public - kiểu dữ liệu trả về(int, string, double)- tên phương thức