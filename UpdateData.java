import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class UpdateData {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/tcs";
        String username = "root";
        String password = "12345678";

        // SQL query to update data
        String query = "UPDATE employees\n" +
                "SET job_title = 'Full Stack Developer', salary = 45000.0\n" +
                "WHERE id = 3;";

        try {
            // Establish connection with database
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");

            // Create a statement object to execute the query
            Statement stmt = con.createStatement();

            // Store the result i.e., rows affected
            int rowsAffected = stmt.executeUpdate(query);

            if (rowsAffected > 0) {
                System.out.println("Successfully updated!");
                System.out.println(rowsAffected + " row(s) affected");
            } else {
                System.out.println("Failed to update!");
            }

            // Close all resources
            stmt.close();
            con.close();
            System.out.println("Connection closed successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}