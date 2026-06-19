package Entity;

public class Topic {

    private int topicId;
    private int courseId;
    private String topicName;
    private boolean completed;

    public Topic() {
    }

    public Topic(
            int topicId,
            int courseId,
            String topicName,
            boolean completed) {

        this.topicId = topicId;
        this.courseId = courseId;
        this.topicName = topicName;
        this.completed = completed;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}