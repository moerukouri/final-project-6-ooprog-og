package util;

public enum OperationType {
    READ("read"),
    WRITE("write"),
    RETRIEVE("retrieve"),
    CREATE("create");

    private final String operation;
    private OperationType(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return this.operation;
    }
}