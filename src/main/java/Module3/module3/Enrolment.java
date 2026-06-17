package module3;

import java.time.LocalDate;

/**
 * Represents a Student's Enrolment record for a Course.
 * Demonstrates: Encapsulation, Association relationship with Course
 * @author Thaneshraj CA25056
 */
public class Enrolment {

    private String    studentId;
    private String    studentName;
    private Course    course;
    private String    status;       // "Active", "Completed", "Dropped"
    private LocalDate enrolDate;

    // --- Constructor ---
    public Enrolment(String studentId, String studentName, Course course) {
        this.studentId   = studentId;
        this.studentName = studentName;
        this.course      = course;
        this.status      = "Active";
        this.enrolDate   = LocalDate.now();
    }

    /**
     * UC5: Calculates real-time progress percentage.
     * Formula: (completedTopics / totalTopics) x 100
     */
    public int calculateProgressPercentage() {
        java.util.List<Topic> topics = course.getTopics();
        if (topics.isEmpty()) return 0;

        long completed = topics.stream().filter(Topic::isCompleted).count();
        return (int) ((completed * 100) / topics.size());
    }

    /**
     * UC7: Checks if the student has completed all topics.
     */
    public boolean isFullyCompleted() {
        return calculateProgressPercentage() == 100;
    }

    // --- Getters & Setters ---
    public String    getStudentId()              { return studentId; }
    public String    getStudentName()            { return studentName; }
    public Course    getCourse()                 { return course; }
    public String    getStatus()                 { return status; }
    public LocalDate getEnrolDate()              { return enrolDate; }

    public void setStatus(String status) {
        this.status = status;
        // Auto-update to Completed if 100%
        if (isFullyCompleted() && !status.equals("Dropped")) {
            this.status = "Completed";
        }
    }
}
