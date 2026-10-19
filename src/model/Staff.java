package model;

import java.time.LocalDateTime;

public class Staff extends User{
    public Staff(String id, LocalDateTime createdAt, String username, String passwordHash, String fullName, boolean status) {
        super(id, createdAt, username, passwordHash, fullName, Role.STAFF, status);
    }
}
