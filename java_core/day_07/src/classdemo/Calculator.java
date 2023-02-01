package classdemo;

public class Calculator {
    public int number1;
    public int number2;

    public void printInfo(){
        System.out.println("In ra 2 số: "+number1+" , "+number2);
    }
    public  int addition(){
        return number1+number2;

    }
    public int subtract(){
        return number1-number2;

    }
    public int multi(){
        return number1*number2;
    }
    public double division(){
        double result = 0.0;
        try {
            return (double) number1 / number2;
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

}
