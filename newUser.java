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
			String userName = (String) userDetails.get(0);
			String phoneNumber = (String) userDetails.get(1);
			String userId = userName.substring(0,4)+phoneNumber.substring(6);
			userDetails.add(userId);
			Random ram=new Random();
			long accNumber = ram.nextLong(1000000,9999999);
			userDetails.add(accNumber);
			System.out.println("-------------------------------------------------------");
			System.out.println("--Your Account Number and UserId for Login is created--");
			System.out.println("-------------------------------------------------------\n");
			String passp = "^(?=.*[0-9])[a-zA-Z0-9]{8}$";
			Pattern passwordPattern = Pattern.compile(passp);
			while(true) {
					System.out.println("You Have to Set Password for furture Login Purpose");
					System.out.println("\nPassword Should\n-Must Contain 8 Characters\n-Must Contain atleast one Number\n-Should not Contain Characters");
					System.out.println("\nEnter new password: ");
					String password = in.next();
					Matcher passmatch = passwordPattern.matcher(password);
					if(passmatch.matches()) {
							userDetails.add(password);
							System.out.println("Your password has been successfully set!");
						break;
					}else {
						System.out.println("Invalid Password. (Password Must Contain 8 Characters includes Number not Symbols)");
					}
			}
			System.out.println("Your Account Creation is going to Finish!");
			while(true) {
				System.out.println("\nEnter Your Inital Deposite Amount (Above 500): ");
				int initalamount = in.nextInt();
				if(initalamount > 500) {
					System.out.println("Amount Added to your Account");
					userDetails.add(initalamount);
					break;
				}else {
					System.out.println("Invalid amount");
				}
			}
			System.out.println(userDetails);
			System.out.println("------------------------------------------------------");
			System.out.println("------------Successfully Account Created!-------------");
			System.out.println("------------------------------------------------------");
			System.out.println("Account Holder Details:");
			System.out.println("Name: "+userDetails.get(0));
			System.out.println("Phone Number: "+userDetails.get(1));
			System.out.println("DOB: "+userDetails.get(2));
			System.out.println("------------------------------------------------------");
			System.out.println(userDetails.get(0)+"'s Bank Account Details:");
			System.out.println("Account Type: "+userDetails.get(3));
			System.out.println("Account UserId: "+userDetails.get(4));
			System.out.println("Account Number: "+userDetails.get(5));
			System.out.println("Inital Amount Deposited: "+userDetails.get(7));
			System.out.println("------------------------------------------------------");
			System.out.println("Kindly Note this UserId for Furture Login\n(Account Number: "+userDetails.get(4)+")");
			System.out.println("------------------------------------------------------");
			in.close();
		return userDetails;
	}
}
