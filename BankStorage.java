import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BankStorage {
    
	Scanner in = new Scanner(System.in);
	
    public boolean checkBankConnection() {
        String jdbcUrl = "!"; 
        String username = "!";                    
        String password = "!";    
        boolean isConnected = false;
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connection to the Bank Database (Oracle Database) was successful!");
            isConnected = true;
        } catch (Exception e) {
            System.err.println("Error occurred while connecting to the Bank Database:");
            e.printStackTrace();
        }
        return isConnected;
    }
    
    public boolean insertUserData(ArrayList<Object> userDetails) {
         
        String jdbcUrl = "!"; 
        String username = "!";                    
        String password = "!";   
        boolean isInserted = false;

        String sql = "INSERT INTO UserAccount (userName, phoneNumber, dob, accountType, userId, accountNumber, password, balance, salary) "
                   + "VALUES (?, ?, TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, (String) userDetails.get(0));  // userName
            preparedStatement.setString(2, (String) userDetails.get(1));  // phoneNumber
            preparedStatement.setString(3, (String) userDetails.get(2));  // dob (converted to string for TO_DATE)
            preparedStatement.setString(4, (String) userDetails.get(3));  // accountType
            preparedStatement.setString(5, (String) userDetails.get(4));  // userId
            preparedStatement.setLong(6, (Long) userDetails.get(5));      // accountNumber
            preparedStatement.setString(7, (String) userDetails.get(6));  // password
            preparedStatement.setDouble(8, (Double) userDetails.get(7));  // balance
            preparedStatement.setDouble(9, (Double) userDetails.get(8));  // salary (this could be null if the user is below 18)

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("New User Account Was Successfully Created!");
                isInserted = true;
            } else {
                System.out.println("Failed to insert user data.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while inserting user data.");
        }
        return isInserted;
    }
     
    public ArrayList<Object> fetchUserDetails() {
        String jdbcUrl = "!"; 
        String username = "!";                    
        String password = "!";  
        ArrayList<Object> userDetails = new ArrayList<>();
        String sql = "SELECT * FROM UserAccount WHERE userId = ?";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        	System.out.println("Enter your UserId: ");
        	String userId = in.next();
        	preparedStatement.setString(1, userId);
        	
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                boolean isPasswordCorrect = false;
                while(!isPasswordCorrect) {
	                	System.out.println("Enter your Password: ");
	                	String enteredPassword = in.next();
	                	if (dbPassword.equals(enteredPassword)) {
	                		System.out.println("Password matched. Fetching user details...");
	                		userDetails.add(resultSet.getString("userName"));       // userName
	                		userDetails.add(resultSet.getString("phoneNumber"));   // phoneNumber
	                		userDetails.add(resultSet.getDate("dob"));             // dob
	                		userDetails.add(resultSet.getString("accountType"));   // accountType
	                		userDetails.add(resultSet.getString("userId"));        // userId
	                		userDetails.add(resultSet.getLong("accountNumber"));   // accountNumber
	                		userDetails.add(resultSet.getDouble("balance"));       // balance
	                		userDetails.add(resultSet.getDouble("salary"));        // salary
	                		isPasswordCorrect = true;
	                	} else { 
	                		System.out.println("Password mismatch. Access denied.");
	                	}
                }
            } else {
                System.out.println("No user found with userId: " + userId);
                return userDetails;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while fetching user details.");
        }

        return userDetails;
    }


}








    
