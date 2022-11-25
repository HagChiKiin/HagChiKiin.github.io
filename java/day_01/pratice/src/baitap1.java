public class baitap1 {
    public static void main(String[] args) {
        System.out.println("Xin chào các bạn");

        String name = "mọi người";
        System.out.println("Xin chào "+ name);
        System.out.println("Xin chào \"" + name + "\"");
        double sum = tong2so(3.5 , 8);
        System.out.println(sum);

        double data = binhPhuong(5.5);
        System.out.println(data);

       int the_ky = theKy(2022);
        System.out.println(the_ky);

        double data3 = bmi(70.5 ,1.68);
        System.out.println(data3);

    }
    public static double tong2so(double a, double b){
        return a + b;
    }
    public static double binhPhuong(double c){
        return c * c;
    }
    public static int theKy(double d) {
        double century = d / 100;
        return  (int) Math.ceil(century)  ;
    }
    public static double bmi(double a, double b){
        return a / (b*b);
    }
}
