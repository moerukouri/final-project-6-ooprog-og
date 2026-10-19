package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sale extends Entity{
    private final String staffId;
    private final String staffUsername;
    private final List<SaleItem> items;
    private final double totalAmount;

    private boolean voided;
    private String voidedBy;
    private String voidReason;
    private LocalDateTime voidedAt;

    public Sale(String id, LocalDateTime createdAt, String staffId, String staffUsername, List<SaleItem> items) {
        super(id, createdAt);
        this.staffId = staffId;
        this.staffUsername = staffUsername;
        this.items = new ArrayList<>(items);
        this.totalAmount = calculateTotal();
        this.voided = false;
    }

    private double calculateTotal() {
        double total = 0;
        for (SaleItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void markVoided(String voidedBy, String reason){
        restoreVoided(voidedBy, reason, LocalDateTime.now());
    }

    public void restoreVoided(String voidedBy, String reason, LocalDateTime voidedAt) {
        if (voided) {
            throw new IllegalStateException("Sale is already voided.");
        }
        this.voided = true;
        this.voidedBy = voidedBy;
        this.voidReason = reason;
        this.voidedAt = voidedAt;
    }

    public String getStaffId() { return staffId; }
    public String getStaffUsername() { return staffUsername; }
    public List<SaleItem> getItems() { return Collections.unmodifiableList(items); }
    public double getTotalAmount() { return totalAmount; }
    public boolean isVoided() { return voided; }
    public String getVoidedBy() { return voidedBy; }
    public String getVoidReason() { return voidReason; }
    public LocalDateTime getVoidedAt() { return voidedAt; }
}