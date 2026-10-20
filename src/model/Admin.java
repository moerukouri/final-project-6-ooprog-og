package model;

import java.time.LocalDateTime;

public class Admin extends User{
    public Admin(String id, LocalDateTime createdAt, String username, String password, String fullName, boolean status) {
        super(id, createdAt, username, password, fullName, Role.ADMIN, status);
    }
}
