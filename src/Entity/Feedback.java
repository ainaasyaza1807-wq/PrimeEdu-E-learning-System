package Entity;

public class Feedback {

    private int feedbackId;

    private int studentId;
    private int instructorId;

    private String feedbackText;

    public Feedback() {
    }

    public Feedback(
            int feedbackId,
            int studentId,
            int instructorId,
            String feedbackText) {

        this.feedbackId = feedbackId;
        this.studentId = studentId;
        this.instructorId = instructorId;
        this.feedbackText = feedbackText;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public String getFeedbackText() {
        return feedbackText;
    }
}