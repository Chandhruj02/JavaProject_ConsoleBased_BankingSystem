import java.util.ArrayList;
import java.util.Scanner;

public class ExistingUser {
	Scanner in = new Scanner(System.in); 
	BankStorage bank = new BankStorage();
	
	void getExistingUser(){
			ArrayList<Object> fetchedUserDetails = new ArrayList<>();
			System.out.println("-------------------------------------------------------");
			System.out.println("------------------- Existing User ---------------------");
			System.out.println("-------------------------------------------------------");
			fetchedUserDetails = bank.fetchUserDetails();
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
	}

}
