public class ForLoop {
    public static void main(String[] args) {
        // Thực hiện cv thực dậy lúc lúc 5h trong vòng 30 ngày
        // begin: Khoier tạo giá trị ban đầu cho vòng lặp
        // condition : Điều kiên để tiếp tục vòng lặp chạy
        // Step : Cập nhật giá trị sau mỗi lần lặp
//        for( int day = 1; day <=30 ; day++) {
//            if (day % 2 == 0) {
//                System.out.println("Ngày " + day + " Thức dậy lúc 5h");
//            }else {
//                System.out.println("Ngày " + day + " Thức dậy lúc 7h");
//            }
//        }
        // ví dụ 3 : thực hiện đến ngày 20 => Không dậy nữa
//        for( int day = 1; day <=30 ; day++) {
//            if (day ==20) {
//                System.out.println("nghỉ thôi. chán quá rồi");
//                break;// kết thúc vòng lặp
//            }
//            System.out.println("Ngày " + day + " Thức dậy lúc 5h");
//        }
        // ví dụ 4 : thực hiện công việc nhưng cuối tuần ko dậy nữa
//        for( int day = 1; day <=30 ; day++) {
//            if (day % 7 == 0) {
//                System.out.println("ngủ thêm ít nữa");
//                continue; // bỏ qua vòng lặp hiện tại, tăng giá trị day lên tiếp
//            }
//            System.out.println("Ngày " + day + " Thức dậy lúc 5h");
//        }
        // tính tổng tiền tiết kiệm trong 10 ngày... 100k /1 ngày
        int total = 0;
        // Đến ngày số 8, bạn rủ đi nhậu, lấy 500 000 trong tiết kiệm ra
        for (int day = 1; day <= 10; day++) {
            // totalMoney = totalMoney + 100000;
            if( day == 8){
                total -= 500000;
            }
            if ( day >=5){
                total += 200000;

            }else {
                total +=100000;
            }
        }
        System.out.println("Tổng tiền: " + total);

    }
}
