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
			in.close();
		return userDetails;
	}
}
