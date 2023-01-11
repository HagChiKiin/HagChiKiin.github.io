package backend.exception;

public class NotFoundException extends RuntimeException { // unchecked exception thừa kế từ lớp RuntimeException
    public NotFoundException(String message) {
        super(message);
    }
}