package entity;

public class Material
extends LearningContent {

private String filePath;

public Material(
        int id,
        String title,
        String description,
        String filePath) {

    super(id, title, description);

    this.filePath = filePath;
}

public String getFilePath() {
    return filePath;
}

public void setFilePath(
        String filePath) {

    this.filePath = filePath;
}

@Override
public String displayContent() {

    return "Material: "
            + getTitle();
}

}
