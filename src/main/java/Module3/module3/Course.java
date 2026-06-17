package module3;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Course in the E-Learning system.
 * Demonstrates: Encapsulation, OOP class structure
 * @author Thaneshraj CA25056
 */
public class Course {

    // --- Encapsulated Fields ---
    private String courseId;
    private String title;
    private String instructor;
    private String duration;
    private String status; // "Active" or "Draft"
    private List<Topic> topics;

    // --- Constructor ---
    public Course(String courseId, String title, String instructor, String duration) {
        this.courseId  = courseId;
        this.title     = title;
        this.instructor = instructor;
        this.duration  = duration;
        this.status    = "Active";
        this.topics    = new ArrayList<>();
    }

    // --- Topic Management ---
    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public List<Topic> getTopics() {
        return topics;
    }

    // --- Getters & Setters ---
    public String getCourseId()              { return courseId; }
    public String getTitle()                 { return title; }
    public String getInstructor()            { return instructor; }
    public String getDuration()              { return duration; }
    public String getStatus()                { return status; }
    public void   setStatus(String status)   { this.status = status; }

    @Override
    public String toString() {
        return title + " (" + courseId + ")";
    }
}
