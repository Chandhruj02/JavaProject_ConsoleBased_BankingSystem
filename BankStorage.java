import java.sql.Connection;
import java.sql.DriverManager;

public class BankStorage {
    
    public boolean checkBankConnection() {
        String jdbcUrl = "!"; 
        String username = "!";                    
        String password = "!";  
        boolean isConnected = false;
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connection to the Bank Database (Oracle Database)");
            isConnected = true;
        }catch (Exception e) {
            System.err.println("Error occurred while connecting to the Bank Database:");
            e.printStackTrace();
        }
        return isConnected;
    }
}
