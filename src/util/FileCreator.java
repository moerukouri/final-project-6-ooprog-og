package util;
import exception.FileStorageException;
import java.io.File;
import java.io.IOException;

public class FileCreator {
    private FileCreator() {} 
    private final FileCreator INSTANCE = new FileCreator();

    private static final String usersPath = FilePath.USERS_PATH.getFilePath();
    private static final String salesPath = FilePath.SALES_PATH.getFilePath();
    private static final String medicinePath = FilePath.MEDICINE_PATH.getFilePath();
    private static final String auditPath = FilePath.AUDIT_PATH.getFilePath();

    private final File usersFile = new File(usersPath);
    private final File salesFile = new File(salesPath);
    private final File medicineFile = new File(medicinePath);


    public FileCreator getInstance() {
        return INSTANCE;
    }

    public void createUsersFile() {
        try {
            if (usersFile.createNewFile()) {
                
            }
        } catch (IOException e) {
            throw new FileStorageException(OperationType.CREATE.getOperation(), usersPath);
        }
    }

    public void createSalesFile() {
        try {
            if (salesFile.createNewFile()) {

            }
        } catch (IOException e) {
            throw new FileStorageException(OperationType.CREATE.getOperation(), salesPath);
        }
    }

    public void createMedicineFile() {
        try {
            if (medicineFile.createNewFile()) {

            }
        } catch (IOException e) {
            throw new FileStorageException(OperationType.CREATE.getOperation(), medicinePath);
        }
    }
}