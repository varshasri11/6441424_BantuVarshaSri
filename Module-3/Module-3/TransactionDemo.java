import java.sql.*;

public class TransactionDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/sys";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; 

    public void transferMoney(int fromAccountId, int toAccountId, double amount) {
        String debitQuery = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditQuery = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false); 

            try (
                PreparedStatement debitStmt = conn.prepareStatement(debitQuery);
                PreparedStatement creditStmt = conn.prepareStatement(creditQuery)
            ) {
                
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccountId);
                int debitResult = debitStmt.executeUpdate();

                
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccountId);
                int creditResult = creditStmt.executeUpdate();

               
                if (debitResult == 1 && creditResult == 1) {
                    conn.commit();
                    System.out.println("Transfer successful.");
                } else {
                    conn.rollback();
                    System.out.println("Transfer failed. Rolled back.");
                }

            } catch (SQLException e) {
                conn.rollback(); 
                System.out.println("Transaction failed: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TransactionDemo demo = new TransactionDemo();
        demo.transferMoney(1, 2, 200.0); 
}
}