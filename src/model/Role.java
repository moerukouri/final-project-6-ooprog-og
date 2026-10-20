package model;

import java.time.LocalDateTime;

public enum Role {
    ADMIN("Admin", Admin::new),
    STAFF("Staff", Staff::new);

    private final UserFactory factory;
    private final String label;

    Role(String label, UserFactory factory){
        this.label = label;
        this.factory = factory;
    }

    public User createUser(String id, LocalDateTime createdAt, String username, String password, String fullName, boolean status){
        return factory.create(id, createdAt, username, password, fullName, status);
    }

    public String getLabel() { return label; }
}