package model;
import java.time.LocalDateTime;

public abstract class User extends Entity {
    private final String username;
    private final String passwordHash;
    private final String fullName;   
    private final Role role;
    private boolean status;

    protected User(String id, LocalDateTime createdAt, String username, String passwordHash, String fullName, Role role, boolean status) {
        super(id, createdAt);

        this.username = username;
        this.passwordHash = passwordHash;
        this.fullName = fullName;
        this.role = role;
        this.status = status;
    }

    public void setAccountStatus(boolean status) {
        this.status = status;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public String getFullName() {
        return this.fullName;
    }

    public Role getRole() {
        return this.role;
    }

    public boolean getAccountStatus() {
        return this.status;
    }
}