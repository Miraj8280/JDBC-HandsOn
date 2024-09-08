import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/tcs";
        String username = "root";
        String password = "12345678";

        // SQL query to insert data
        String query = "INSERT INTO employees(id, name, job_title, salary) VALUES(2, 'Arab', 'Frontend Developer', 35000.0);";

        try {
            // Establish connection with database
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");

            // Create a statement object to execute query
            Statement stmt = con.createStatement();

            // Store the result i.e., rows affected after insertion
            int rowsAffected = stmt.executeUpdate(query);

            if (rowsAffected > 0) {
                System.out.println("Insertion successful!");
                System.out.println(rowsAffected + " row(s) affected.");
            } else {
                System.out.println("Insertion failed!");
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
