public class IFELSE_demo {
    public static void main(String[] args) {
//        toán tử   && - và , || - hoặc , ! - phủ định
        int hour = 20;
        if (hour < 12) {
            System.out.println("Good morning!");
        } else if ( hour>=12 && hour<18){
            System.out.println("Good afternoon");
        } else {
            System.out.println("Good evening");
        }



        boolean troiDep = true ;
        boolean coTien  = true;
        if(!troiDep && coTien){
            System.out.println("Đi chơi");
        } else {
            System.out.println(" Ở nhà ngủ");
        }
        if(!troiDep || coTien){
            System.out.println("Đi nhà nghỉ");
        }
        // Toán tử 3 ngôi
        String message = (troiDep && coTien) ? "Đi chơi" : "Ở nhà ngủ";
        System.out.println(message);

        int number = -1;
        String text = number > 0 ? "Số dương"
                : number == 0 ? "Số không" : "Số âm" ;
        System.out.println(text);
    }
}
