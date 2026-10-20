package model;

import java.time.LocalDateTime;

public interface UserFactory {
    User create(String id, LocalDateTime createdAt, String username, String passwordHash, String fullName, boolean status);
}
