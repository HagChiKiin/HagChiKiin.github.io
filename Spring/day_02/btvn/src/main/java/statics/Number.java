package statics;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Number {
    public int numberChoise(){
        int number ;
        do{
            try{
                number = new Scanner(System.in).nextInt();
                if(number>0){
                    break;
                }
                System.out.println("so luong nhap vao phai lon hon 0:");
            }catch (InputMismatchException ex){
                System.out.println("vui long nhap so :");
            }
        }while (true);
        return number;
    }
}
