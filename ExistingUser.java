import java.util.ArrayList;
import java.util.Scanner;

public class ExistingUser {
	Scanner in = new Scanner(System.in); 
	BankStorage bank = new BankStorage();
	
	ArrayList<Object> getExistingUser(){
			ArrayList<Object> userDetails = new ArrayList<>();
			System.out.println("-------------------------------------------------------");
			System.out.println("------------------- Existing User ---------------------");
			System.out.println("-------------------------------------------------------");
			System.out.println("Enter Your UserId:");
			String userId = in.next();
			System.out.println("Enter Your Password:");
			String password = in.next();
			userDetails = bank.fetchUserDetails(userId,password);
		return userDetails;
		
	}

}
