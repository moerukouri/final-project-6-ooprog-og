package model;

import java.time.LocalDateTime;

public class Admin extends User{
    public Admin(String id, LocalDateTime createdAt, String username, String passwordHash, String fullName, boolean status) {
        super(id, createdAt, username, passwordHash, fullName, Role.ADMIN, status);
    }
}
