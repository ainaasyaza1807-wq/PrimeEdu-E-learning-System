package entity;

public class Admin extends User {

    private String adminLevel;

    public Admin() {
    }

    public Admin(int userId,
                 String username,
                 String password,
                 String fullName,
                 String email,
                 String adminLevel) {

        super(userId, username, password,
              fullName, email);

        this.adminLevel = adminLevel;
    }

    public String getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
    }

    @Override
    public void displayDashboard() {
        System.out.println("Admin Dashboard");
    }
}