package Module1.Controller;

import java.sql.*;

public class LoginController {

    private final String url = "jdbc:mysql://localhost:3306/primeedu_db";
    private final String user = "root";
    private final String pass = "";

    public String loginUser(String email, String password) {

    try (Connection conn = DriverManager.getConnection(url, user, pass)) {

        // SEMAK USERS
        String userQuery =
                "SELECT role FROM users WHERE email=? AND password=?";

        PreparedStatement stmt1 =
                conn.prepareStatement(userQuery);

        stmt1.setString(1, email);
        stmt1.setString(2, password);

        ResultSet rs1 = stmt1.executeQuery();

        if (rs1.next()) {
            return rs1.getString("role");
        }

        // SEMAK CHILD PROFILE
        String childQuery =
                "SELECT child_id FROM child_profiles "
                + "WHERE child_email=? AND child_password=?";

        PreparedStatement stmt2 =
                conn.prepareStatement(childQuery);

        stmt2.setString(1, email);
        stmt2.setString(2, password);

        ResultSet rs2 = stmt2.executeQuery();

        if (rs2.next()) {
            return "Child";
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

        return null;
    }
}