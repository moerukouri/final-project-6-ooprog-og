package model;

import java.time.LocalDateTime;

public interface UserFactory {
    User create(String id, LocalDateTime createdAt, String username, String password, String fullName, boolean status);
}
