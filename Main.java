import java.util.Scanner;

public class Main {
		public static void main(String[] args){
			BankStorage bs = new BankStorage();
			Scanner in = new Scanner(System.in);
			boolean isConnected = bs.checkBankConnection();
			if(isConnected) {
				System.out.print(" was successful!");
				System.out.println("------------------------------------------------------");
				System.out.println("----------- Console Based - Banking System -----------");
				System.out.println("------------------------------------------------------");
				System.out.println("\nWelcome to Banking");
				System.out.println("1. New User Registration");
				System.out.println("2. Login with User ID");
				System.out.println("3. Exit");
				System.out.println("Enter your option: ");
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
			}else {
				System.out.println("Sorry You are not Connected to Bank DataBase");
			}
			
			in.close();
		}

	}

