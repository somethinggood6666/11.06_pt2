package by.epam.shchemelev.exceptions;

public class UnknownParameterException extends Exception{
    public UnknownParameterException() {
        super();
    }

    public UnknownParameterException(String message) {
        super(message);
    }

    public UnknownParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownParameterException(Throwable cause) {
        super(cause);
    }
}
