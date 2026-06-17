/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module1.Controller;

import Entity.User; // Huruf E besar
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AuthController {
    private final String url = "jdbc:mysql://localhost:3306/primeedu_db";
    private final String user = "root";
    private final String pass = "";

    // 1. Logik Semak Emel Wujud (Siri Mesej No 7 dalam Sequence Diagram kau)
    public boolean checkEmailExists(String email) {
        String query = "SELECT email FROM users WHERE email = ?";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Pulangkan true kalau emel dah ada dalam DB
            
        } catch (SQLException e) {
    JOptionPane.showMessageDialog(
        null,
        e.getMessage(),
        "Database Error",
        JOptionPane.ERROR_MESSAGE
    );

    e.printStackTrace();
    return false;
}
    }

    // 2. Logik Simpan Data Pendaftaran (Siri Mesej No 10 dalam Sequence Diagram kau)
    public boolean registerUser(User newUser) {

    // Semak input kosong
    if (newUser.getFullName().isEmpty()
            || newUser.getEmail().isEmpty()
            || newUser.getPassword().isEmpty()) {
        return false;
    }

    String query =
            "INSERT INTO users "
            + "(full_name, email, phone_number, password, role) "
            + "VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(url, user, pass);
         PreparedStatement stmt = conn.prepareStatement(query)) {

        System.out.println("Connecting to database...");

        stmt.setString(1, newUser.getFullName());
        stmt.setString(2, newUser.getEmail());
        stmt.setString(3, newUser.getPhoneNumber());
        stmt.setString(4, newUser.getPassword());
        stmt.setString(5, newUser.getRole());

        int rows = stmt.executeUpdate();

        System.out.println("Rows inserted = " + rows);

        return rows > 0;

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
        );

        e.printStackTrace();
        return false;
    }
}    
    public boolean updatePassword(String email, String newPassword) {

    String query =
        "UPDATE users SET password=? WHERE email=?";

    try (Connection conn = DriverManager.getConnection(url, user, pass);
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, newPassword);
        stmt.setString(2, email);

        return stmt.executeUpdate() > 0;

    } catch (SQLException e) {
    JOptionPane.showMessageDialog(
        null,
        e.getMessage(),
        "Database Error",
        JOptionPane.ERROR_MESSAGE
    );

    e.printStackTrace();
    return false;
}
}
}
