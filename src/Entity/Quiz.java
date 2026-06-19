package Entity;

public class Quiz {

    private String quizId;
    private String title;
    private String subjectCode;

    public Quiz() {
    }

    public Quiz(
            String quizId,
            String title,
            String subjectCode) {

        this.quizId = quizId;
        this.title = title;
        this.subjectCode = subjectCode;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
}