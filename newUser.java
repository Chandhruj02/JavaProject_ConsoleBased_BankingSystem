import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class newUser {
	
	ArrayList<Object> generateNewUser(){
		ArrayList<Object> userDetails = new ArrayList<>();
		Scanner in = new Scanner(System.in); 
			String np = "^[A-Za-z]+$"; 
			Pattern namePattern = Pattern.compile(np);
			System.out.println("-------------------------------------------------------");
			System.out.println("----------------New User Regestritation----------------");
			System.out.println("-------------------------------------------------------");
			while(true) {
				System.out.println("Enter Your Full Name:");
				String name = in.next();
				Matcher namematch = namePattern.matcher(name);
				if(namematch.matches()) {
					userDetails.add(name);
					break;
				}
				else 
					System.out.println("Invalid name. Please enter letters only.");
			}  
			String pp = "^[0-9]{10}$";
			Pattern phonepatter = Pattern.compile(pp);
			while(true) {
				System.out.println("Enter Your Mobile number:");
				String phonenumber = in.next(); 
				Matcher phonematch = phonepatter.matcher(String.valueOf(phonenumber));
				if(phonematch.matches()) {
						userDetails.add(phonenumber);
					break;
				}
				else {
					System.out.println("Invalid Number. Please enter numbers only.");
				}
			}
			while (true) {
			    System.out.println("Enter Your Date of Birth (dd/MM/yyyy): ");
			    String dob = in.next();
			    if (dob.length() == 10 && dob.charAt(2) == '/' && dob.charAt(5) == '/') {
			        try {
			            int day = Integer.parseInt(dob.substring(0, 2));
			            int month = Integer.parseInt(dob.substring(3, 5));
			            int year = Integer.parseInt(dob.substring(6, 10));
			            if (day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >=1930) {	        
			                userDetails.add(dob); 
			                break; 
			            } else {
			                System.out.println("The date is not valid. Please enter a correct day and month.");
			            }
			        } catch (NumberFormatException e) {
			            System.out.println("The date contains invalid numbers.");
			        }
			    } else {
			        System.out.println("Please enter the date in DD/MM/YYYY format.");
			    }
			}
			while(true) {
				System.out.println("-------------- Choice your Account Type ---------------");
				System.out.println("1. Current Account\n2.Savings Account");
				System.out.println("Enter your option (1/2): ");
				int op = in.nextInt();
				if(op==1) {
						System.out.println("You selected ----> Current Account");
						userDetails.add("Current Account");
					break;
				}else if(op==2) {
						System.out.println("You selected ----> Savings Account");
						userDetails.add("Savings Account");
					break;
				}else {
					System.out.println("Invalid Choice. Please enter any one (1 or 2).");
				}
			}
			in.close();
		return userDetails;
	}
}
