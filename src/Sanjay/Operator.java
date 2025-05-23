//package Sanjay;
//
//
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//    public class Operator {
//
//
//        // Database credentials
//        static final String DB_URL = "jdbc:mysql://localhost:3306/Demodb"; // Repdblace with your DB URL
//        static final String USER = "root"; // Replace with your username
//        static final String PASS = "Sanjay123"; // Replace with your password
//
//        static String query = "SELECT * FROM employee";
//        //static String query = "SELECT * FROM employee WHERE name = ?";
//
//        public static void main(String[] args) {
//            Connection conn = null;
//            Statement stmt = null;
//            PreparedStatement pstmt = null;
//            ResultSet rs = null;
//
//            try {
//                // Step 1: Register the JDBC driver (optional for newer versions)
//                Class.forName("com.mysql.cj.jdbc.Driver");
//
//                // Step 2: Open a connection
//                System.out.println("Connecting to database...");
//                conn = DriverManager.getConnection(DB_URL, USER, PASS );
//
//                System.out.println("Connected to the database successfully!");
//
//
//                stmt = conn.createStatement();
//
////	             Step 3: Execute the query
//
//                String update = "INSERT INTO employee (name, email, salary) VALUES (?, ?, ?)";
//                pstmt = conn.prepareStatement(update);
//                pstmt.setString(1, "Kumar");  // Setting the id column (first ? in the query)
//                pstmt.setString(2, "Kumar@example.com");  // Setting the name column (second ? in the query)
//                pstmt.setString(3, "70000");
//                pstmt.executeUpdate();
//
////	            PreparedStatement pstmt = conn.prepareStatement(query);
////	            pstmt.setString(1, "John Doe");  // Set parameter dynamically
////	             rs = pstmt.executeQuery();
//
//                rs = stmt.executeQuery(query);
//                while (rs.next()) {
//                    // Retrieve data by column name or index (e.g., "id", "name")
//                    int id = rs.getInt("id");  // Assuming there's an "id" column
//                    String name = rs.getString("name");  // Assuming there's a "name" column
//                    String salary = rs.getString("salary");  // Assuming there's a "name" column
//                    System.out.println("ID: " + id + ", Name: " + name+ ", Salary: "+ salary);  // Output the data
//                }
//
//            } catch (SQLException | ClassNotFoundException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    if (rs != null) rs.close();
//                    if (stmt != null) stmt.close();
//                    if (conn != null) conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
