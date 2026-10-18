package model;
import java.time.LocalDateTime;

public abstract class Entity {
    private String id;
    private LocalDateTime createdAt;

    protected Entity(String id, LocalDateTime createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    protected String getID() {
        return this.id;
    }
    protected LocalDateTime getCreatedAt() {
        return this.createdAt;
    }
}