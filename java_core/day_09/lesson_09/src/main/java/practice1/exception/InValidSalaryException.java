package practice1.exception;

public class InValidSalaryException extends RuntimeException{
    public InValidSalaryException(String message){
        super(message);
    }
}
