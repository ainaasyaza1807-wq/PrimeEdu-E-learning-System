/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module1.Entity;

import java.util.ArrayList;

public class Parent extends User {
    private int parentId;
    private ArrayList<ChildProfile> children;

    public Parent(String fullName, String email,String phoneNumber,String password,String role) {
    super(fullName, email, phoneNumber, password, role);

    children = new ArrayList<>();
}
    
    public void addChild(ChildProfile child) {
    children.add(child);
}

    public ArrayList<ChildProfile> getChildren() {
    return children;
}

    @Override
    public void displayDashboard() {
        // Logik buka skrin Parent Dashboard
    }

    public int getParentId() { return parentId; }
    public void setParentId(int parentId) { this.parentId = parentId; }
}

