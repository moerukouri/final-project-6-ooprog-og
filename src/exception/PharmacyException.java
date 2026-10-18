package exception;

public abstract class PharmacyException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "Error: The pharmacy system detected an error.";
    
    public PharmacyException() {
        super(DEFAULT_MESSAGE);
    }

    public PharmacyException(String message) {
        super(message);
    }

    public PharmacyException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public PharmacyException(String message, Throwable cause) {
        super(message, cause);
    }
}