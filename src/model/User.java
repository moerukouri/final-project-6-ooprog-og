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
        if (parts.length >= 7) {
            String id = parts[0];
            LocalDateTime createdAt = LocalDateTime.parse(parts[1]);
            String username = parts[2];
            String passwordHash = parts[3];
            String fullName = parts[4];
            String roleStr = parts[5];
            boolean status = Boolean.parseBoolean(parts[6]);

            if ("ADMIN".equals(roleStr)) {
                return new Admin(id, createdAt, username, passwordHash, fullName, status);
            } else if ("STAFF".equals(roleStr)) {
                return new Staff(id, createdAt, username, passwordHash, fullName, status);
            }
        }
        return null;
    }

    public void setAccountStatus(boolean status) { this.status = status; }
    public String getUsername() { return this.username; }
    public String getPasswordHash() { return this.passwordHash; }
    public String getFullName() { return this.fullName; }
    public Role getRole() { return this.role; }
    public boolean getAccountStatus() { return this.status; }
}