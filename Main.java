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
                            ArrayList<Object> fetchedUserDetails = eu.getExistingUser();
                            if (fetchedUserDetails != null) {
                                System.out.println("------------------------------------------------------");
                                System.out.println("             Welcome Back! " + fetchedUserDetails.get(0) + "       ");
                                System.out.println("------------------------------------------------------");
                                System.out.println("Account Type: " + fetchedUserDetails.get(3));
                                System.out.println("Account Number: " + fetchedUserDetails.get(5));
                                System.out.println("------------------------------------------------------");

                                while (true) {
                                    System.out.println("1. Check Balance");
                                    System.out.println("2. Withdraw Amount");
                                    System.out.println("3. Deposit Amount");
                                    System.out.println("4. Logout");
                                    System.out.print("Enter your option: ");

                                    try {
                                        int option1 = in.nextInt();
                                        switch (option1) {
                                            case 1: {
                                                System.out.println("Your Current Account Balance: " + fetchedUserDetails.get(6));
                                                break;
                                            }
                                            case 2: {
                                                bank.withdrawAmount(); 
                                                break;
                                            }
                                            case 3: {
                                                bank.depositAmount(); 
                                                break;
                                            }
                                            case 4: {
                                                System.out.println("Logging out...");
                                                return;
                                            }
                                            default: {
                                                System.out.println("Sorry, Invalid Option");
                                                break;
                                            }
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Invalid input. Please enter a valid option.");
                                        in.nextLine(); 
                                    }
                                }
                            } else {
                                System.out.println("Authentication failed. Returning to the main menu...");
                            }
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
