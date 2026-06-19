package Entity;

public class Enrolment {

    private int enrolmentId;
    private int studentId;
    private int courseId;
    private int progress;
    private String status;

    public Enrolment() {
    }

    public Enrolment(
            int enrolmentId,
            int studentId,
            int courseId,
            int progress,
            String status) {

        this.enrolmentId = enrolmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.progress = progress;
        this.status = status;
    }

    public int getEnrolmentId() {
        return enrolmentId;
    }

    public void setEnrolmentId(int enrolmentId) {
        this.enrolmentId = enrolmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}