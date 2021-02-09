package workshop.refactor;

public class EmailInvalidException extends ArrayIndexOutOfBoundsException {
    public EmailInvalidException(String message) {
        super(message);
    }
}
