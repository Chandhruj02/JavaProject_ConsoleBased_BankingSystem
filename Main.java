import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankStorage bank = new BankStorage();
        Scanner in = new Scanner(System.in);
        boolean isConnected = bank.checkBankConnection();
        if (isConnected) {
            while (true) {
                System.out.println("------------------------------------------------------");
                System.out.println("----------- Console Based - Banking System -----------");
                System.out.println("------------------------------------------------------");
                System.out.println("\nWelcome to Banking");
                System.out.println("1. New User Registration");
                System.out.println("2. Login with User ID");
                System.out.println("3. Exit");
                System.out.print("Enter your option: ");
                try {
                    int option = in.nextInt();
                    in.nextLine(); 
                    switch (option) {
                        case 1: {
                            newUser nu = new newUser();
                            ArrayList<Object> collectUserDetails = nu.generateNewUser();
                            boolean isInserted = bank.insertUserData(collectUserDetails);
                            if (isInserted) {
                                System.out.println("User data has been successfully saved in the database.");
                            } else {
                                System.out.println("Failed to save user data.");
                            }
                            System.out.println("Press any key to return to the main menu...");
                            in.nextLine();
                            break;
                        }
                        case 2: {
                            ExistingUser eu = new ExistingUser();
                            eu.getExistingUser();
                            break;
                        }
                        case 3: {
                            System.out.println("------------------------------------------------------");
                            System.out.println("--------------------- Thank You ----------------------");
                            System.out.println("------------------------------------------------------");
                            return; 
                        }
                        default: {
                            System.out.println("Sorry, Invalid Option");
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.");
                    in.nextLine(); 
                }
            }
        } else {
            System.out.println("--------------- Sorry, You are not Connected to Bank Database ---------------");
        }
        in.close();
    }
}
