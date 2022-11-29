public class Switch_Case_Demo {
    public static void main(String[] args) {
        int money = 10000;

        switch (money) {
            case 12000:
            case 15000:
            case 18000:{
                System.out.println("Cà phê sữa"); // bỏ break sẽ đi thẳng đến trường hợp dưới và k in ra
                break;
            }
            case 10000: {
                System.out.println("Cà phê đá");  // bỏ break sẽ in ra cafeda và tiếp tục đi xuống
                break;
            }
            case 8000: {
                System.out.println("String dâu"); // bỏ break sẽ in ra và tiếp tục đi xuống..
                break;
            }
            case 2000: {
                System.out.println("Trà đá");
                break;
            }
            default: {
                System.out.println("Không có đồ uống phù hợp");
                break;
            }
        }

    }
}
