import java.util.Scanner;

public class Practice1_while {
    public static void main(String[] args) {
        boolean isQuit = false;
        while(!isQuit){
            Scanner sc = new Scanner(System.in);
            System.out.println("nhập vào số: ");
            int n = sc.nextInt();
            if( n!=0 ){
                System.out.println("Số vừa nhập là: "+n);
                isQuit = true;
            }else {
                System.out.println("số phải khác 0.Nhập lai: ");
            }
        }
    }
}
