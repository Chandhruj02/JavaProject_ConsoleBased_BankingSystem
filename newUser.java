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
			in.close();
		return userDetails;
	}
}
