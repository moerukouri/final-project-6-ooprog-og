package ui; 

import java.util.ArrayList;
import model.User;

public class UserInterface {
    private static final short TEXT_PADDING = 3;
    private UserInterface() {} // Prevents Instantiation
    
    public static void displayAdminMenu() {
        displayTitle("ADMIN MENU");
        
        System.out.println("1. Manage Accounts");
        System.out.println("2. Manage Inventory");
        System.out.println("3. View All Sales");
        System.out.println("4. View Own Sales");
        System.out.println("5. Record Transaction");
        System.out.println("6. Logout");
    }

    public static void displayStaffMenu() {
        displayTitle("STAFF MENU");

        System.out.println("1. Record Transaction");
        System.out.println("2. View All Medicine");
        System.out.println("3. Search Medicine");
        System.out.println("4. View Own Sales");
        System.out.println("5. Logout");
    }

    public static void displayAccountsMenu() {
        displayTitle("MANAGE ACCOUNTS");

        System.out.println("1. View All Accounts");
        System.out.println("2. Add Account");
        System.out.println("3. Modify Account");
        System.out.println("4. Delete Account");
        System.out.println("5. Back");
    }

    public static void displayInventoryMenu() {
        displayTitle("MANAGE INVENTORY");

        System.out.println("1. View All Medicine");
        System.out.println("2. Search Medicine");
        System.out.println("3. Update Stock of Medicine");
        System.out.println("4. Back");
    }

    public static void displayTitle(String title) {
        System.out.println();
        System.out.println("=".repeat(TEXT_PADDING * 2 + title.length()));
        System.out.println(" ".repeat(TEXT_PADDING) + title + " ".repeat(TEXT_PADDING));
        System.out.println("=".repeat(TEXT_PADDING * 2 + title.length()));
        System.out.println();
    }

    public static void displayFeedback(String feedback) {
        String[] parts = feedback.split("\n");
        int longestElement = getLongestElementLength(parts);
        
        System.out.println();
        System.out.println("-".repeat(longestElement));
        
        for (String part : parts) {
            System.out.println(part + " ".repeat(longestElement - part.length()));
        }
        
        System.out.println("-".repeat(longestElement));
        System.out.println();
    }

    public static void displayAccountTable(ArrayList<User> users) {
        String[] fields = {"USER ID", "USERNAME", "FULL NAME", "ROLE", "STATUS"};
        
        int idLength = fields[0].length();
        int usernameLength = fields[1].length();
        int fullNameLength = fields[2].length(); 
        int roleLength = fields[3].length();
        int statusLength = fields[4].length();
        
        for (User user : users) {
            idLength = Math.max(idLength, user.getID().length());
            usernameLength = Math.max(usernameLength, user.getUsername().length());
            fullNameLength = Math.max(fullNameLength, user.getFullName().length());
            roleLength = Math.max(roleLength, user.getRole().toString().length());
            statusLength = Math.max(statusLength, String.valueOf(user.getAccountStatus()).length());
        }

        int totalLength = idLength + usernameLength + fullNameLength + roleLength + statusLength;
        System.out.println("=".repeat(totalLength + 16));

        System.out.print(String.format("| %-" + idLength + "s |", fields[0]));
        System.out.print(String.format(" %-" + usernameLength + "s |", fields[1]));
        System.out.print(String.format(" %-" + fullNameLength + "s |", fields[2]));
        System.out.print(String.format(" %-" + roleLength + "s |", fields[3]));
        System.out.print(String.format(" %-" + statusLength + "s |", fields[4]));

        System.out.println("=".repeat(totalLength + 16));

        for (User user : users) {
            System.out.print(String.format("| %-" + idLength + "s |", user.getID()));
            System.out.print(String.format(" %-" + usernameLength + "s |", user.getUsername()));
            System.out.print(String.format(" %-" + fullNameLength + "s |", user.getFullName()));
            System.out.print(String.format(" %-" + roleLength + "s |", user.getRole().toString().length()));
            System.out.print(String.format(" %-" + statusLength + "s |", String.valueOf(user.getAccountStatus()).length()));
        }

        System.out.println("=".repeat(totalLength + 16));
    }

    private static int getLongestElementLength(String[] parts) {
        int longestLength = -1;

        for (String part : parts) {
            longestLength = Math.max(longestLength, part.length());
        }

        return longestLength;
    }
}
