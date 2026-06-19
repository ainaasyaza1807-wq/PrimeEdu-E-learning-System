package entity;

public class Instructor extends User {

    private String specialization;

    public Instructor() {
    }

    public Instructor(int userId,
                      String username,
                      String password,
                      String fullName,
                      String email,
                      String specialization) {

        super(userId, username, password,
              fullName, email);

        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void displayDashboard() {
        System.out.println("Instructor Dashboard");
    }
}