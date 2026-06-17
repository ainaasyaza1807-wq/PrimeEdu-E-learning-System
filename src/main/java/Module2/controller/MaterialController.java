package Module2.controller;

import Module2.entity.Material;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MaterialController {

    // Add Material
    public boolean addMaterial(String subjectCode,
                               String standard,
                               String instructor,
                               String filePath) {

        String url = "jdbc:mysql://localhost:3306/primeedu_db";
        String user = "root";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query =
                "INSERT INTO materials " +
                "(title, description, subjectCode, standard, instructorName, filePath) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, "Course Material");
            stmt.setString(2, "Auto-uploaded file");
            stmt.setString(3, subjectCode);
            stmt.setString(4, standard);
            stmt.setString(5, instructor);
            stmt.setString(6, filePath);

            stmt.executeUpdate();

            conn.close();

            System.out.println("SUCCESS: Saved to XAMPP!");
            return true;

        } catch (Exception e) {
            System.out.println("CRASH ERROR: " + e.getMessage());
            return false;
        }
    }

    // Get All Materials
    public ArrayList<Material> getMaterialList() {

        ArrayList<Material> materialList = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/primeedu_db";

        try {

            Connection conn =
                    DriverManager.getConnection(url, "root", "");

            PreparedStatement stmt =
                    conn.prepareStatement("SELECT * FROM materials");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Material m = new Material(
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("subjectCode"),
                        rs.getString("standard"),
                        rs.getString("filePath"),
                        rs.getString("instructorName")
                );

                materialList.add(m);
            }

            conn.close();

        } catch (Exception e) {
            System.out.println("Error loading table: " + e.getMessage());
        }

        return materialList;
    }

    // Delete Material
    public boolean deleteMaterial(String subjectCode,
                                  String filePath) {

        String url = "jdbc:mysql://localhost:3306/primeedu_db";

        try {

            Connection conn =
                    DriverManager.getConnection(url, "root", "");

            String query =
                    "DELETE FROM materials WHERE subjectCode = ? AND filePath = ?";

            PreparedStatement stmt =
                    conn.prepareStatement(query);

            stmt.setString(1, subjectCode);
            stmt.setString(2, filePath);

            stmt.executeUpdate();

            conn.close();

            System.out.println("SUCCESS: Deleted from XAMPP!");
            return true;

        } catch (Exception e) {

            System.out.println("Error deleting material: " + e.getMessage());
            return false;
        }
    }
}