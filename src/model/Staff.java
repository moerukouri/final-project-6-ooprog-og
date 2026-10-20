package model;

import java.time.LocalDateTime;

public class Staff extends User{
    public Staff(String id, LocalDateTime createdAt, String username, String password, String fullName, boolean status) {
        super(id, createdAt, username, password, fullName, Role.STAFF, status);
    }
}
