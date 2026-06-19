package Entity;

public class Result {

    private int resultId;

    private String quizId;
    private int studentId;

    private int score;

    public Result() {
    }

    public Result(
            int resultId,
            String quizId,
            int studentId,
            int score) {

        this.resultId = resultId;
        this.quizId = quizId;
        this.studentId = studentId;
        this.score = score;
    }

    public int getResultId() {
        return resultId;
    }

    public String getQuizId() {
        return quizId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getScore() {
        return score;
    }
}