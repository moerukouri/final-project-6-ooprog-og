package util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import exception.FileStorageException;

public class FileHandler {
    public static boolean findID(String id, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.split("\\|")[0].equals(id)) {
                    return true;
                }
            }

            return false;
        } catch (IOException e) {
            throw new FileStorageException(OperationType.READ.getOperation(), filePath);
        }
    }

    public static void write(String input, String filePath, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) {
            writer.write(input);
            writer.newLine();
        } catch (IOException e) {
            throw new FileStorageException(OperationType.WRITE.getOperation(), filePath);
        }
    }

    public static void update(String lineToUpdate, String newLine, String filePath) {
        final ArrayList<String> lines = retrieve(filePath);

        for (String line : lines) {
            if (line.equals(lineToUpdate)) {
                line = lineToUpdate;
                break;
            }
        }

        for (String line : lines) {
            write(line, filePath, lines.indexOf(line) != 0);
        }
    }

    public static ArrayList<String> retrieve(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            final ArrayList<String> lines = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            return lines;
        } catch (IOException e) {
            throw new FileStorageException(OperationType.RETRIEVE.getOperation(), filePath);
        }
    }

    public static void delete(String lineToDelete, String filePath) {
        final ArrayList<String> lines = retrieve(filePath);

        for (String line : lines) {
            if (line.equals(lineToDelete)) {
                lines.remove(lineToDelete);
                break;
            }
        }

        for (String line : lines) {
            write(line, filePath, lines.indexOf(line) != 0);
        }
    }
}