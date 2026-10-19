package util;

public enum FilePath {
    USERS_PATH("data/users.txt"),
    SALES_PATH("data/sales.txt"),
    MEDICINE_PATH("data/medicine.txt");

    private final String filePath;
    private FilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return this.filePath;
    }
}