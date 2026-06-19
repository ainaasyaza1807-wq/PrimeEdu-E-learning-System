package Entity;

public class Submission {

    private int submissionId;

    private String assessmentId;
    private int studentId;

    private String submissionText;

    private int marks;
    private String feedback;
    
    private String submissionFile;
    private String status;

    public Submission() {
    }

    public Submission(
            int submissionId,
            String assessmentId,
            int studentId,
            String submissionText,
            String submissionFile,
            int marks,
            String feedback,
            String status) {

        this.submissionId = submissionId;
        this.assessmentId = assessmentId;
        this.studentId = studentId;
        this.submissionText = submissionText;
        this.submissionFile = submissionFile;
        this.marks = marks;
        this.feedback = feedback;
        this.status = status;
    }

    public int getSubmissionId() {
        return submissionId;
    }

    public String getAssessmentId() {
        return assessmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getSubmissionText() {
        return submissionText;
    }

    public int getMarks() {
        return marks;
    }

    public String getFeedback() {
        return feedback;
    }
    
    public String getSubmissionFile() {
    return submissionFile;
    }

    public void setSubmissionFile(String submissionFile) {
    this.submissionFile = submissionFile;
    }

    public String getStatus() {
    return status;
    }

    public void setStatus(String status) {
    this.status = status;
    }
}