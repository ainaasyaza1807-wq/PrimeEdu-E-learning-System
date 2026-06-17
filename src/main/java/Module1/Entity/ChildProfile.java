package Entity;

public class ChildProfile {

private int childId;
private int parentId;
private String childName;
private String childStandard;
private String schoolName;
private String childEmail;
private String childPassword;

public ChildProfile(int parentId, String childName,
                    String childStandard, String schoolName,
                    String childEmail, String childPassword) {

    this.parentId = parentId;
    this.childName = childName;
    this.childStandard = childStandard;
    this.schoolName = schoolName;
    this.childEmail = childEmail;
    this.childPassword = childPassword;
}

// GETTERS
public int getChildId() {
    return childId;
}

public int getParentId() {
    return parentId;
}

public String getChildName() {
    return childName;
}

public String getChildStandard() {
    return childStandard;
}

public String getSchoolName() {
    return schoolName;
}

public String getChildEmail() {
    return childEmail;
}

public String getChildPassword() {
    return childPassword;
}

// SETTERS
public void setChildId(int childId) {
    this.childId = childId;
}

public void setParentId(int parentId) {
    this.parentId = parentId;
}

public void setChildName(String childName) {
    this.childName = childName;
}

public void setChildStandard(String childStandard) {
    this.childStandard = childStandard;
}

public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
}

public void setChildEmail(String childEmail) {
    this.childEmail = childEmail;
}

public void setChildPassword(String childPassword) {
    this.childPassword = childPassword;
}

}
