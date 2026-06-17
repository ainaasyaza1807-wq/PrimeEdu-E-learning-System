package module3;

/**
 * Represents a single Topic inside a Course.
 * Demonstrates: Encapsulation
 * @author Thaneshraj CA25056
 */
public class Topic {

    private String topicId;
    private String title;
    private boolean isCompleted;

    public Topic(String topicId, String title) {
        this.topicId     = topicId;
        this.title       = title;
        this.isCompleted = false;
    }

    // --- Getters & Setters ---
    public String  getTopicId()                    { return topicId; }
    public String  getTitle()                      { return title; }
    public boolean isCompleted()                   { return isCompleted; }
    public void    setCompleted(boolean completed) { this.isCompleted = completed; }

    @Override
    public String toString() { return title; }
}
