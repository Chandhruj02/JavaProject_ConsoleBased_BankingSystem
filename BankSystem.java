import java.util.Scanner;

public class BankSystem {

	public static void main(String[] args){
		System.out.println("------------------------------------------------------");
		System.out.println("----------- Console Based - Banking System -----------");
		System.out.println("------------------------------------------------------");
		System.out.println("\nWelcome to Banking");
		System.out.println("1. New User Registration");
		System.out.println("2. Login with User ID");
		System.out.println("3. Exit");
		System.out.println("Enter your option: ");
		Scanner in = new Scanner(System.in);
		int option = in.nextInt();
		switch(option) {
			case 1:{
					newUser nu = new newUser();
					nu.generateNewUser();
				break;
			}
			case 2:{
				System.out.println("under Construction");
				break;
			}
		}
		in.close();
	}

}
