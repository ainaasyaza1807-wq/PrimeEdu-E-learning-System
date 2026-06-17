package Module1.Controller;

import java.sql.*;

public class ForgotPasswordController {

    private final String url = "jdbc:mysql://localhost:3306/primeedu_db";
    private final String user = "root";
    private final String pass = "";

    // Semak email dalam users dan child_profiles
    public boolean emailExists(String email) {

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {

            String userQuery =
                    "SELECT email FROM users WHERE email=?";

            PreparedStatement stmt1 =
                    conn.prepareStatement(userQuery);

            stmt1.setString(1, email);

            ResultSet rs1 = stmt1.executeQuery();

            if (rs1.next()) {
                return true;
            }

            String childQuery =
                    "SELECT child_email FROM child_profiles WHERE child_email=?";

            PreparedStatement stmt2 =
                    conn.prepareStatement(childQuery);

            stmt2.setString(1, email);

            ResultSet rs2 = stmt2.executeQuery();

            return rs2.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Update password untuk users atau child_profiles
    public boolean updatePassword(String email, String newPassword) {

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {

            String userQuery =
                    "UPDATE users SET password=? WHERE email=?";

            PreparedStatement stmt1 =
                    conn.prepareStatement(userQuery);

            stmt1.setString(1, newPassword);
            stmt1.setString(2, email);

            int userRows = stmt1.executeUpdate();

            if (userRows > 0) {
                return true;
            }

            String childQuery =
                    "UPDATE child_profiles "
                    + "SET child_password=? "
                    + "WHERE child_email=?";

            PreparedStatement stmt2 =
                    conn.prepareStatement(childQuery);

            stmt2.setString(1, newPassword);
            stmt2.setString(2, email);

            int childRows = stmt2.executeUpdate();

            return childRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}