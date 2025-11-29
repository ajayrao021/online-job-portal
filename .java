// ==================== UTILITY LAYER ====================

// File: DatabaseConnection.java
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/job_portal";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "your_password";
    private static Connection connection = null;

    private DatabaseConnection() {}

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// ==================== MODEL LAYER ====================

// File: User.java
package models;

import java.sql.Timestamp;

public class User {
    private int userId;
    private String email;
    private String password;
    private String userType; // EMPLOYEE or INTERVIEWER
    private Timestamp createdAt;

    public User() {}

    public User(int userId, String email, String password, String userType, Timestamp createdAt) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }
    
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}

// File: Employee.java
package models;

public class Employee {
    private int employeeId;
    private int userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String skills;
    private int experienceYears;
    private String resumePath;
    private String profileSummary;

    public Employee() {}

    public Employee(int employeeId, int userId, String firstName, String lastName, 
                   String phone, String skills, int experienceYears, String resumePath, String profileSummary) {
        this.employeeId = employeeId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.skills = skills;
        this.experienceYears = experienceYears;
        this.resumePath = resumePath;
        this.profileSummary = profileSummary;
    }

    // Getters and Setters
    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
    
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }
    
    public int getExperienceYears() { return experienceYears; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }
    
    public String getResumePath() { return resumePath; }
    public void setResumePath(String resumePath) { this.resumePath = resumePath; }
    
    public String getProfileSummary() { return profileSummary; }
    public void setProfileSummary(String profileSummary) { this.profileSummary = profileSummary; }
}

// File: Interviewer.java
package models;

public class Interviewer {
    private int interviewerId;
    private int userId;
    private String companyName;
    private String firstName;
    private String lastName;
    private String phone;
    private String companyWebsite;

    public Interviewer() {}

    public Interviewer(int interviewerId, int userId, String companyName, 
                      String firstName, String lastName, String phone, String companyWebsite) {
        this.interviewerId = interviewerId;
        this.userId = userId;
        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.companyWebsite = companyWebsite;
    }

    // Getters and Setters
    public int getInterviewerId() { return interviewerId; }
    public void setInterviewerId(int interviewerId) { this.interviewerId = interviewerId; }
    
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getCompanyWebsite() { return companyWebsite; }
    public void setCompanyWebsite(String companyWebsite) { this.companyWebsite = companyWebsite; }
}

// File: Job.java
package models;

import java.sql.Timestamp;

public class Job {
    private int jobId;
    private int interviewerId;
    private String title;
    private String description;
    private String requirements;
    private String location;
    private String salaryRange;
    private String jobType; // FULL_TIME, PART_TIME, CONTRACT
    private Timestamp postedDate;
    private String status; // ACTIVE, CLOSED

    public Job() {}

    public Job(int jobId, int interviewerId, String title, String description, String requirements,
              String location, String salaryRange, String jobType, Timestamp postedDate, String status) {
        this.jobId = jobId;
        this.interviewerId = interviewerId;
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.location = location;
        this.salaryRange = salaryRange;
        this.jobType = jobType;
        this.postedDate = postedDate;
        this.status = status;
    }

    // Getters and Setters
    public int getJobId() { return jobId; }
    public void setJobId(int jobId) { this.jobId = jobId; }
    
    public int getInterviewerId() { return interviewerId; }
    public void setInterviewerId(int interviewerId) { this.interviewerId = interviewerId; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getRequirements() { return requirements; }
    public void setRequirements(String requirements) { this.requirements = requirements; }
    
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    public String getSalaryRange() { return salaryRange; }
    public void setSalaryRange(String salaryRange) { this.salaryRange = salaryRange; }
    
    public String getJobType() { return jobType; }
    public void setJobType(String jobType) { this.jobType = jobType; }
    
    public Timestamp getPostedDate() { return postedDate; }
    public void setPostedDate(Timestamp postedDate) { this.postedDate = postedDate; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

// File: Application.java
package models;

import java.sql.Timestamp;

public class Application {
    private int applicationId;
    private int jobId;
    private int employeeId;
    private String coverLetter;
    private Timestamp applicationDate;
    private String status; // PENDING, REVIEWED, SHORTLISTED, REJECTED, ACCEPTED

    public Application() {}

    public Application(int applicationId, int jobId, int employeeId, String coverLetter,
                      Timestamp applicationDate, String status) {
        this.applicationId = applicationId;
        this.jobId = jobId;
        this.employeeId = employeeId;
        this.coverLetter = coverLetter;
        this.applicationDate = applicationDate;
        this.status = status;
    }

    // Getters and Setters
    public int getApplicationId() { return applicationId; }
    public void setApplicationId(int applicationId) { this.applicationId = applicationId; }
    
    public int getJobId() { return jobId; }
    public void setJobId(int jobId) { this.jobId = jobId; }
    
    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
    
    public String getCoverLetter() { return coverLetter; }
    public void setCoverLetter(String coverLetter) { this.coverLetter = coverLetter; }
    
    public Timestamp getApplicationDate() { return applicationDate; }
    public void setApplicationDate(Timestamp applicationDate) { this.applicationDate = applicationDate; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

// File: Interview.java
package models;

import java.sql.Timestamp;

public class Interview {
    private int interviewId;
    private int applicationId;
    private Timestamp interviewDate;
    private String interviewMode; // ONLINE, OFFLINE
    private String meetingLink;
    private String status; // SCHEDULED, COMPLETED, CANCELLED
    private String feedback;

    public Interview() {}

    public Interview(int interviewId, int applicationId, Timestamp interviewDate,
                    String interviewMode, String meetingLink, String status, String feedback) {
        this.interviewId = interviewId;
        this.applicationId = applicationId;
        this.interviewDate = interviewDate;
        this.interviewMode = interviewMode;
        this.meetingLink = meetingLink;
        this.status = status;
        this.feedback = feedback;
    }

    // Getters and Setters
    public int getInterviewId() { return interviewId; }
    public void setInterviewId(int interviewId) { this.interviewId = interviewId; }
    
    public int getApplicationId() { return applicationId; }
    public void setApplicationId(int applicationId) { this.applicationId = applicationId; }
    
    public Timestamp getInterviewDate() { return interviewDate; }
    public void setInterviewDate(Timestamp interviewDate) { this.interviewDate = interviewDate; }
    
    public String getInterviewMode() { return interviewMode; }
    public void setInterviewMode(String interviewMode) { this.interviewMode = interviewMode; }
    
    public String getMeetingLink() { return meetingLink; }
    public void setMeetingLink(String meetingLink) { this.meetingLink = meetingLink; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
}

// ==================== DAO LAYER ====================

// File: UserDAO.java
package dao;

import models.User;
import util.DatabaseConnection;
import java.sql.*;

public class UserDAO {
    
    public User registerUser(String email, String password, String userType) {
        String sql = "INSERT INTO users (email, password, user_type) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.setString(3, userType);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int userId = rs.getInt(1);
                    return getUserById(userId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User login(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getInt("user_id"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("user_type"),
                    rs.getTimestamp("created_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserById(int userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new User(
                    rs.getInt("user_id"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("user_type"),
                    rs.getTimestamp("created_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

// File: EmployeeDAO.java
package dao;

import models.Employee;
import util.DatabaseConnection;
import java.sql.*;

public class EmployeeDAO {
    
    public boolean createEmployeeProfile(Employee employee) {
        String sql = "INSERT INTO employees (user_id, first_name, last_name, phone, skills, experience_years, resume_path, profile_summary) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, employee.getUserId());
            stmt.setString(2, employee.getFirstName());
            stmt.setString(3, employee.getLastName());
            stmt.setString(4, employee.getPhone());
            stmt.setString(5, employee.getSkills());
            stmt.setInt(6, employee.getExperienceYears());
            stmt.setString(7, employee.getResumePath());
            stmt.setString(8, employee.getProfileSummary());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Employee getEmployeeByUserId(int userId) {
        String sql = "SELECT * FROM employees WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Employee(
                    rs.getInt("employee_id"),
                    rs.getInt("user_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("phone"),
                    rs.getString("skills"),
                    rs.getInt("experience_years"),
                    rs.getString("resume_path"),
                    rs.getString("profile_summary")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateEmployeeProfile(Employee employee) {
        String sql = "UPDATE employees SET first_name = ?, last_name = ?, phone = ?, skills = ?, experience_years = ?, resume_path = ?, profile_summary = ? WHERE employee_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getPhone());
            stmt.setString(4, employee.getSkills());
            stmt.setInt(5, employee.getExperienceYears());
            stmt.setString(6, employee.getResumePath());
            stmt.setString(7, employee.getProfileSummary());
            stmt.setInt(8, employee.getEmployeeId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

// File: InterviewerDAO.java
package dao;

import models.Interviewer;
import util.DatabaseConnection;
import java.sql.*;

public class InterviewerDAO {
    
    public boolean createInterviewerProfile(Interviewer interviewer) {
        String sql = "INSERT INTO interviewers (user_id, company_name, first_name, last_name, phone, company_website) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, interviewer.getUserId());
            stmt.setString(2, interviewer.getCompanyName());
            stmt.setString(3, interviewer.getFirstName());
            stmt.setString(4, interviewer.getLastName());
            stmt.setString(5, interviewer.getPhone());
            stmt.setString(6, interviewer.getCompanyWebsite());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Interviewer getInterviewerByUserId(int userId) {
        String sql = "SELECT * FROM interviewers WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Interviewer(
                    rs.getInt("interviewer_id"),
                    rs.getInt("user_id"),
                    rs.getString("company_name"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("phone"),
                    rs.getString("company_website")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

// File: JobDAO.java
package dao;

import models.Job;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {
    
    public boolean postJob(Job job) {
        String sql = "INSERT INTO jobs (interviewer_id, title, description, requirements, location, salary_range, job_type, status) VALUES (?, ?, ?, ?, ?, ?, ?, 'ACTIVE')";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, job.getInterviewerId());
            stmt.setString(2, job.getTitle());
            stmt.setString(3, job.getDescription());
            stmt.setString(4, job.getRequirements());
            stmt.setString(5, job.getLocation());
            stmt.setString(6, job.getSalaryRange());
            stmt.setString(7, job.getJobType());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Job> getAllActiveJobs() {
        List<Job> jobs = new ArrayList<>();
        String sql = "SELECT * FROM jobs WHERE status = 'ACTIVE' ORDER BY posted_date DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                jobs.add(new Job(
                    rs.getInt("job_id"),
                    rs.getInt("interviewer_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("requirements"),
                    rs.getString("location"),
                    rs.getString("salary_range"),
                    rs.getString("job_type"),
                    rs.getTimestamp("posted_date"),
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }

    public List<Job> getJobsByInterviewer(int interviewerId) {
        List<Job> jobs = new ArrayList<>();
        String sql = "SELECT * FROM jobs WHERE interviewer_id = ? ORDER BY posted_date DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, interviewerId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                jobs.add(new Job(
                    rs.getInt("job_id"),
                    rs.getInt("interviewer_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("requirements"),
                    rs.getString("location"),
                    rs.getString("salary_range"),
                    rs.getString("job_type"),
                    rs.getTimestamp("posted_date"),
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }
}

// File: ApplicationDAO.java
package dao;

import models.Application;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAO {
    
    public boolean applyForJob(Application application) {
        String sql = "INSERT INTO applications (job_id, employee_id, cover_letter, status) VALUES (?, ?, ?, 'PENDING')";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, application.getJobId());
            stmt.setInt(2, application.getEmployeeId());
            stmt.setString(3, application.getCoverLetter());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Application> getApplicationsByEmployee(int employeeId) {
        List<Application> applications = new ArrayList<>();
        String sql = "SELECT * FROM applications WHERE employee_id = ? ORDER BY application_date DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                applications.add(new Application(
                    rs.getInt("application_id"),
                    rs.getInt("job_id"),
                    rs.getInt("employee_id"),
                    rs.getString("cover_letter"),
                    rs.getTimestamp("application_date"),
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    }

    public List<Application> getApplicationsByJob(int jobId) {
        List<Application> applications = new ArrayList<>();
        String sql = "SELECT * FROM applications WHERE job_id = ? ORDER BY application_date DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, jobId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                applications.add(new Application(
                    rs.getInt("application_id"),
                    rs.getInt("job_id"),
                    rs.getInt("employee_id"),
                    rs.getString("cover_letter"),
                    rs.getTimestamp("application_date"),
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    }

    public boolean updateApplicationStatus(int applicationId, String status) {
        String sql = "UPDATE applications SET status = ? WHERE application_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, status);
            stmt.setInt(2, applicationId);
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

// ==================== MAIN APPLICATION ====================

// File: Main.java
package main;

import view.LoginView;

public class Main {
    public static void main(String[] args) {
        // Launch the login view
        javax.swing.SwingUtilities.invokeLater(() -> {
            new LoginView().setVisible(true);
        });
    }
}