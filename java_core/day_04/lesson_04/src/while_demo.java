public class while_demo {
    public static void main(String[] args) {
//        for( int day = 1; day <=30 ; day++)

//        int day = 1;
//        while(day<=30){
//            System.out.println("Ngày "+day +" thức dậy lúc 5h" );
//            day++;
//        }
//        while(day<=30){
//            if (day % 2 == 0) {
//                System.out.println("Ngày " + day + " Thức dậy lúc 5h");
//            }else {
//                System.out.println("Ngày " + day + " Thức dậy lúc 7h");
//            }
//            day ++ ;
//        }
            int day = 31; // câu lệnh ít nhật thực hiện 1 lần khi ko thỏa mãn điều kiện ở while
        do{ // thực hiện
            if(day%2 ==0){
                System.out.println("Ngày " + day + " Thức dậy lúc 5h");
            }else {
                System.out.println("Ngày " + day + " Thức dậy lúc 7h");
            }
            day ++;
        }while(day<=30);
    }
}
