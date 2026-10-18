package exception;
import model.Role;

public class AccessDeniedException extends PharmacyException {
    public AccessDeniedException() {
        super("Error: You do not have permission to perform this action.");
    }

    public AccessDeniedException(String action) {
        super(String.format("Error: You do not have permission to perform %s.", action));
    }

    public AccessDeniedException(Role role, String action) {
        super(String.format("Error: %s is not authorized to perform %s", role, action));
    }
}
