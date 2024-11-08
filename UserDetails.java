import java.util.LinkedList;

public class UserDetails {
	private String userName;
	private String phoneNumber;
	private String dob;
	private String accountType;
	private String userId;
	private long accountNumber;
	private String password;
	private double balance;
	private LinkedList<Double> deposite = new LinkedList<>();
	private LinkedList<Double> withdraw = new LinkedList<>();
	
		UserDetails(String userName, String phoneNumber, String dob, String accountType, 
	            String userId, long accountNumber, String password, double balance) {
	    this.userName = userName;
	    this.phoneNumber = phoneNumber;
	    this.dob = dob;
	    this.accountType = accountType;
	    this.userId = userId;
	    this.accountNumber = accountNumber;
	    this.password = password;
	    this.balance = balance;
	}

		public String getUserName() { return userName; }
		public String getPhoneNumber() { return phoneNumber; }
		public String getDob() { return dob; }
		public String getAccountType() { return accountType; }
		public String getUserId() { return userId; }
		public long getAccountNumber() { return accountNumber; }
		public String getPassword() { return password; }
		public double getBalance() { return balance; }
		public LinkedList<Double> getDeposite() { return deposite; }
		public LinkedList<Double> getWithdraw() { return withdraw; }

}
