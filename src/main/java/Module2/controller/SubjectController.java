package Module2.controller;

import Module2.entity.Subject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SubjectController {

    // Add Subject
    public boolean addSubject(String code, String name, String standard, String teacherName) {

        String url = "jdbc:mysql://localhost:3306/primeedu_db";

        try {
            Connection conn = DriverManager.getConnection(url, "root", "");

            String query = "INSERT INTO subjects (code, name, standard, teacherName) VALUES (?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, code);
            stmt.setString(2, name);
            stmt.setString(3, standard);
            stmt.setString(4, teacherName);

            stmt.executeUpdate();

            conn.close();

            System.out.println("SUCCESS: New Subject saved to XAMPP!");
            return true;

        } catch (Exception e) {
            System.out.println("Error saving subject: " + e.getMessage());
            return false;
        }
    }

    // Get Subject List
    public ArrayList<Subject> getSubjectList() {

        ArrayList<Subject> subjectList = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/primeedu_db";

        try {
            Connection conn = DriverManager.getConnection(url, "root", "");

            PreparedStatement stmt =
                    conn.prepareStatement("SELECT * FROM subjects");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Subject s = new Subject(
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getString("standard"),
                        rs.getString("teacherName")
                );

                subjectList.add(s);
            }

            conn.close();

        } catch (Exception e) {
            System.out.println("Error loading subjects: " + e.getMessage());
        }

        return subjectList;
    }

    // Delete Subject
    public boolean deleteSubject(String subjectCode) {

        String url = "jdbc:mysql://localhost:3306/primeedu_db";

        try {
            Connection conn = DriverManager.getConnection(url, "root", "");

            String query = "DELETE FROM subjects WHERE code = ?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, subjectCode);

            stmt.executeUpdate();

            conn.close();

            System.out.println("SUCCESS: Subject deleted from XAMPP!");
            return true;

        } catch (Exception e) {
            System.out.println("Error deleting subject: " + e.getMessage());
            return false;
        }
    }

    // Update Subject
    public boolean updateSubject(String code,
                                 String newName,
                                 String newStandard,
                                 String newTeacher) {

        String url = "jdbc:mysql://localhost:3306/primeedu_db";

        try {
            Connection conn = DriverManager.getConnection(url, "root", "");

            String query =
                    "UPDATE subjects SET name=?, standard=?, teacherName=? WHERE code=?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, newName);
            stmt.setString(2, newStandard);
            stmt.setString(3, newTeacher);
            stmt.setString(4, code);

            stmt.executeUpdate();

            conn.close();

            System.out.println("SUCCESS: Subject updated in XAMPP!");
            return true;

        } catch (Exception e) {
            System.out.println("Error updating subject: " + e.getMessage());
            return false;
        }
    }
}