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
			userDetails = bank.fetchUserDetails();
			if(userDetails != null && !userDetails.isEmpty()) {
				return userDetails;
			}
		return null;
		
	}

}
