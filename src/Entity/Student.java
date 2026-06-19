package entity;

public class Student extends User {

    private String level;
    private Parent parent;

    public Student() {
    }

    public Student(int userId,
            String username,
            String password,
            String fullName,
            String email,
            String level) {

        super(userId, username, password,
                fullName, email);

        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    @Override
    public void displayDashboard() {
        System.out.println("Student Dashboard");
    }
}