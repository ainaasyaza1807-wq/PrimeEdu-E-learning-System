package entity;

public class AssessmentMaterial
extends LearningContent {

private int totalMarks;

public AssessmentMaterial(
        int id,
        String title,
        String description,
        int totalMarks) {

    super(id, title, description);

    this.totalMarks = totalMarks;
}

public int getTotalMarks() {
    return totalMarks;
}

public void setTotalMarks(
        int totalMarks) {

    this.totalMarks = totalMarks;
}

@Override
public String displayContent() {

    return "Assessment: "
            + getTitle()
            + " | Marks: "
            + totalMarks;
}

}
