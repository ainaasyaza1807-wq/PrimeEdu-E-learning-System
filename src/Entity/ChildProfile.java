package entity;

public class ChildProfile {

    private int childId;
    private String childName;
    private String childEmail;
    private String childPassword;
    private String standard;
    private String schoolName;

    public ChildProfile() {
    }

    public ChildProfile(
            int childId,
            String childName,
            String childEmail,
            String childPassword,
            String standard,
            String schoolName) {

        this.childId = childId;
        this.childName = childName;
        this.childEmail = childEmail;
        this.childPassword = childPassword;
        this.standard = standard;
        this.schoolName = schoolName;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildEmail() {
        return childEmail;
    }

    public void setChildEmail(String childEmail) {
        this.childEmail = childEmail;
    }

    public String getChildPassword() {
        return childPassword;
    }

    public void setChildPassword(String childPassword) {
        this.childPassword = childPassword;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}