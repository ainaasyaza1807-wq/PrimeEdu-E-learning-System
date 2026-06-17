package module3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Live Database Store for the E-Learning system mapped to MySQL via XAMPP.
 * Seamlessly integrates into existing GUI layout configurations.
 * @author Thaneshraj CA25056
 */
public class primeedu_db {

    public static List<Course>    globalCourses    = new ArrayList<>();
    public static List<Enrolment> globalEnrolments = new ArrayList<>();

    // Database configurations 
    private static final String URL  = "jdbc:mysql://localhost:3306/elearning_db";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static void initializeDatabase() {
    // Updated connection string to use your new primeedu_db name
    String url = "jdbc:mysql://localhost:3306/primeedu_db";
    String user = "root";
    String password = "";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(url, user, password);
             java.sql.Statement stmt = conn.createStatement()) {
            
            // 1. Auto-Create Courses Table
            stmt.execute("CREATE TABLE IF NOT EXISTS courses (" +
                    "course_id VARCHAR(50) PRIMARY KEY, " +
                    "title VARCHAR(100), " +
                    "instructor VARCHAR(100), " +
                    "duration VARCHAR(50), " +
                    "status VARCHAR(20))");
            
            // 2. Auto-Create Enrolments Table
            stmt.execute("CREATE TABLE IF NOT EXISTS enrolments (" +
                    "student_id VARCHAR(50), " +
                    "student_name VARCHAR(100), " +
                    "course_id VARCHAR(50), " +
                    "enrol_date DATE, " +
                    "status VARCHAR(20), " +
                    "progress INT, " +
                    "PRIMARY KEY (student_id, course_id))");

            // 3. Auto-Create Topics Table
            stmt.execute("CREATE TABLE IF NOT EXISTS topics (" +
                    "topic_id VARCHAR(50) PRIMARY KEY, " +
                    "course_id VARCHAR(50), " +
                    "title VARCHAR(100), " +
                    "is_completed BOOLEAN)");
            
            System.out.println("✅ Database tables successfully verified/created!");
        }
    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("❌ Database table initialization failed: " + e.getMessage());
    }
}

    // =============================================
    // CRUD OPERATIONS
    // =============================================

    public static boolean enrolStudent(String studentId, String studentName, Course course) {
        for (Enrolment e : globalEnrolments) {
            if (e.getStudentId().equals(studentId)
                    && e.getCourse().getCourseId().equals(course.getCourseId())
                    && !e.getStatus().equals("Dropped")) {
                return false; 
            }
        }
        globalEnrolments.add(new Enrolment(studentId, studentName, course));
        saveToFile(); // Silently routes to MySQL sync handler
        return true;
    }

    public static void dropEnrolment(Enrolment enrolment) {
        enrolment.setStatus("Dropped");
        saveToFile();
    }

    public static List<Enrolment> getEnrolmentsByStudent(String studentId) {
        List<Enrolment> result = new ArrayList<>();
        for (Enrolment e : globalEnrolments) {
            if (e.getStudentId().equals(studentId)) {
                result.add(e);
            }
        }
        return result;
    }

    public static List<Enrolment> getEnrolmentsByInstructor(String instructorName) {
        List<Enrolment> result = new ArrayList<>();
        for (Enrolment e : globalEnrolments) {
            if (e.getCourse().getInstructor().equals(instructorName)) {
                result.add(e);
            }
        }
        return result;
    }

    // =============================================
    // LIVE MYSQL DATABASE PERSISTENCE CONNECTIONS
    // =============================================

    /** * Rewritten: Saves memory structures directly to the XAMPP database tables.
     */
    public static void saveToFile() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            
            // 1. Sync Enrolment Records Table
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("DELETE FROM enrolments");
            }
            String insertEnrolSql = "INSERT INTO enrolments (student_id, student_name, course_id, status) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertEnrolSql)) {
                for (Enrolment e : globalEnrolments) {
                    stmt.setString(1, e.getStudentId());
                    stmt.setString(2, e.getStudentName());
                    stmt.setString(3, e.getCourse().getCourseId());
                    stmt.setString(4, e.getStatus());
                    stmt.addBatch();
                }
                stmt.executeBatch();
            }
            
            // 2. Sync Topic Progress Completions
            String updateTopicSql = "UPDATE topics SET is_completed = ? WHERE course_id = ? AND topic_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(updateTopicSql)) {
                for (Course c : globalCourses) {
                    for (Topic t : c.getTopics()) {
                        stmt.setBoolean(1, t.isCompleted());
                        stmt.setString(2, c.getCourseId());
                        stmt.setString(3, t.getTopicId());
                        stmt.addBatch();
                    }
                }
                stmt.executeBatch();
            }
            
        } catch (SQLException ex) {
            System.err.println("Database Sync Save Failed: " + ex.getMessage());
        }
    }

    /** * Rewritten: Populates internal architecture arrays directly out of SQL fields.
     */
    public static void loadFromFile() {
        globalCourses.clear();
        globalEnrolments.clear();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            
            // 1. Fetch Course Catalogue
            String courseSql = "SELECT * FROM courses";
            try (PreparedStatement stmt = conn.prepareStatement(courseSql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Course c = new Course(
                        rs.getString("course_id"),
                        rs.getString("title"),
                        rs.getString("instructor"),
                        rs.getString("duration")
                    );
                    c.setStatus(rs.getString("status"));
                    globalCourses.add(c);
                }
            }
            
            // 2. Fetch Linked Child Topics
            String topicSql = "SELECT * FROM topics ORDER BY course_id, topic_id";
            try (PreparedStatement stmt = conn.prepareStatement(topicSql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String courseId = rs.getString("course_id");
                    Topic t = new Topic(rs.getString("topic_id"), rs.getString("title"));
                    t.setCompleted(rs.getBoolean("is_completed"));
                    
                    for (Course c : globalCourses) {
                        if (c.getCourseId().equals(courseId)) {
                            c.addTopic(t);
                        }
                    }
                }
            }
            
            // 3. Fetch Transaction Enrolments
            String enrolSql = "SELECT * FROM enrolments";
            try (PreparedStatement stmt = conn.prepareStatement(enrolSql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String studentId = rs.getString("student_id");
                    String studentName = rs.getString("student_name");
                    String courseId = rs.getString("course_id");
                    String status = rs.getString("status");
                    
                    Course targetCourse = null;
                    for (Course c : globalCourses) {
                        if (c.getCourseId().equals(courseId)) {
                            targetCourse = c;
                            break;
                        }
                    }
                    
                    if (targetCourse != null) {
                        Enrolment e = new Enrolment(studentId, studentName, targetCourse);
                        e.setStatus(status);
                        globalEnrolments.add(e);
                    }
                }
            }
            
        } catch (SQLException ex) {
            System.err.println("Database Initial Load Failed: " + ex.getMessage());
        }
    }
}