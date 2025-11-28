// JobPortalDAO.java
// This is a sample Java class for an Online Job Portal project using JDBC.
// It demonstrates basic database operations like connecting to a database,
// inserting a job posting, and retrieving job listings.
// Assumptions: Using MySQL database with a table 'jobs' (id, title, description, company, location).

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobPortalDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/jobportal"; // Replace with your DB URL
    private static final String USER = "root"; // Replace with your DB username
    private static final String PASSWORD = "password"; // Replace with your DB password

    // Method to establish database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Method to add a new job posting
    public void addJob(String title, String description, String company, String location) {
        String sql = "INSERT INTO jobs (title, description, company, location) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setString(3, company);
            stmt.setString(4, location);
            stmt.executeUpdate();
            System.out.println("Job added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all job postings
    public List<String> getAllJobs() {
        List<String> jobs = new ArrayList<>();
        String sql = "SELECT * FROM jobs";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String job = "ID: " + rs.getInt("id") + ", Title: " + rs.getString("title") +
                             ", Description: " + rs.getString("description") + ", Company: " + rs.getString("company") +
                             ", Location: " + rs.getString("location");
                jobs.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }

    // Main method for testing (optional)
    public static void main(String[] args) {
        JobPortalDAO dao = new JobPortalDAO();
        // Example: Add a job
        dao.addJob("Software Engineer", "Develop web applications", "TechCorp", "New York");
        // Example: Retrieve and print jobs
        List<String> jobs = dao.getAllJobs();
        for (String job : jobs) {
            System.out.println(job);
        }
    }
}
