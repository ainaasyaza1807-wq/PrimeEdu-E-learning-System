package entity;

import java.util.ArrayList;

public class Parent extends User {

    private String phoneNumber;

    // Aggregation
    private ArrayList<ChildProfile> children;

    public Parent() {
        children = new ArrayList<>();
    }

    public Parent(int userId,
            String username,
            String password,
            String fullName,
            String email,
            String phoneNumber) {

        super(userId, username, password, fullName, email);

        this.phoneNumber = phoneNumber;
        this.children = new ArrayList<>();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<ChildProfile> getChildren() {
        return children;
    }

    public void addChild(ChildProfile child) {
        children.add(child);
    }

    public void removeChild(ChildProfile child) {
        children.remove(child);
    }

    @Override
    public void displayDashboard() {
        System.out.println("Parent Dashboard");
    }
}