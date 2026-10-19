package model;
import java.time.LocalDateTime;

public abstract class Entity {
    private String id;
    private LocalDateTime createdAt;

    protected Entity(String id, LocalDateTime createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    public void setID(String id) {
        this.id = id;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getID() {
        return this.id;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }
}