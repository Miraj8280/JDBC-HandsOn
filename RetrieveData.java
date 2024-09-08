import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveData {
    public static void main(String[] args) throws ClassNotFoundException {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/tcs";
        String username = "root";
        String password = "12345678";

        // SQL query to retrieve data
        String query = "SELECT * FROM employees";

        // Load the Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Establish connection with database
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");

            // Create statement object to execute query
            Statement stmt = con.createStatement();

            // Create result set object to store executed query
            ResultSet rs = stmt.executeQuery(query);

            // Process the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");

                // Display retrieved data
                System.out.println("-------------------");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Job title: " + job_title);
                System.out.println("Salary: " + salary);
            }
            System.out.println("-------------------");

            // Close the resources
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}