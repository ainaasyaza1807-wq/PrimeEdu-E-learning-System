package Module2.entity;

public class Material extends LearningContent {
    
    private String subjectCode;
    private String standard; // Added standard!
    private String filePath;
    private String instructorName;

    // The Constructor (The blueprint)
    public Material(String title, String description, String subjectCode, String standard, String filePath, String instructorName) {
        super(title, description); 
        this.subjectCode = subjectCode;
        this.standard = standard;
        this.filePath = filePath;
        this.instructorName = instructorName;
    }

    // Getters so your UI table can read the data
    public String getSubjectCode() { return subjectCode; }
    public String getStandard() { return standard; }
    public String getFilePath() { return filePath; }
    public String getInstructorName() { return instructorName; }
}