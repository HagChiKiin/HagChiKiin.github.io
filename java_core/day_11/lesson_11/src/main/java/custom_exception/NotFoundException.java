package custom_exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) { // thông báo nguyên nhân lỗi là gì
        super(message);
    }

}
