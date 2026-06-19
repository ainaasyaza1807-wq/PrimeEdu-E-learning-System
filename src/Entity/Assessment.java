package Entity;

public class Assessment {

    private String assessmentId;
    private String assessmentFile;
    private String title;
    private String description;
    private int instructorId;

    public Assessment() {
    }

    public Assessment(
            String assessmentId,
        String title,
        String description,
        int instructorId,
        String assessmentFile) {

        this.assessmentId = assessmentId;
        this.title = title;
        this.description = description;
        this.instructorId = instructorId;
        this.assessmentFile = assessmentFile;
    }

    public String getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }
    
    public String getAssessmentFile() {
    return assessmentFile;
    }

    public void setAssessmentFile(String assessmentFile) {
    this.assessmentFile = assessmentFile;
    }
}