package controller;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ForgotPasswordController {

    // =========================
    // VERIFY EMAIL
    // =========================

    public boolean verifyEmail(String email) {

        String sql =
                "SELECT * FROM users "
                + "WHERE email=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, email);

            ResultSet rs =
                    pst.executeQuery();

            return rs.next();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    // =========================
    // RESET PASSWORD
    // =========================

    public boolean resetPassword(
            String email,
            String newPassword) {

        if (!verifyEmail(email)) {

            return false;
        }

        String sql =
                "UPDATE users "
                + "SET password=? "
                + "WHERE email=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, newPassword);
            pst.setString(2, email);

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }
}