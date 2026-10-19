package model;

import java.time.LocalDateTime;

public class AuditEntry extends Entity {
    private final String userId;
    private final String username;
    private final String action;
    private final String targetId;
    private final String details;

    public AuditEntry(String id, LocalDateTime timestamp, String userId, String username, String action, String targetId, String details) {
        super(id, timestamp);
        this.userId = userId;
        this.username = username;
        this.action = action;
        this.targetId = targetId;
        this.details = details;
    }

    public String getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getAction() { return action; }
    public String getTargetId() { return targetId; }
    public String getDetails() { return details; }
}