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

    public String toTextRow() {
        return String.join("|", getID(), getCreatedAt().toString(), username, passwordHash, fullName, role.name(), String.valueOf(status));
    }

    public static User fromTextRow(String row) {
        String[] parts = row.split("\\|");
        if (parts.length != 7) {
            return null;
        }

        Role role = Role.valueOf(parts[5]);
        return role.createUser(parts[0], LocalDateTime.parse(parts[1]), parts[2], parts[3], parts[4], Boolean.parseBoolean(parts[6]));
    }

    public void setAccountStatus(boolean status) { this.status = status; }
    public String getUsername() { return this.username; }
    public String getPasswordHash() { return this.passwordHash; }
    public String getFullName() { return this.fullName; }
    public Role getRole() { return this.role; }
    public boolean getAccountStatus() { return this.status; }
}