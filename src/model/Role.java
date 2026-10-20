package model;

import java.time.LocalDateTime;

public enum Role {
    ADMIN(Admin::new),
    STAFF(Staff::new);

    private final UserFactory factory;

    Role(UserFactory factory){
        this.factory = factory;
    }

    public User createUser(String id, LocalDateTime createdAt, String username, String passwordHash, String fullName, boolean status){
        return factory.create(id, createdAt, username, passwordHash, fullName, status);
    }
}