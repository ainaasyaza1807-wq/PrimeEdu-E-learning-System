/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module1.Entity;

public class Student extends User {
    private String studentStandard;
    private String schoolName;

    public Student(String fullName, String email, String phoneNumber, String password, String role, String studentStandard, String schoolName) {
        super(fullName, email, phoneNumber, password, role);
        this.studentStandard = studentStandard;
        this.schoolName = schoolName;
    }

    @Override
    public void displayDashboard() {
        // Logik buka skrin Student Dashboard
    }

    public String getStudentStandard() { return studentStandard; }
    public String getSchoolName() { return schoolName; }
}
