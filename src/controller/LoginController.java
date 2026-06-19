package controller;

import database.DBConnection;
import entity.User;
import entity.UserFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    // =========================
    // LOGIN
    // =========================

    public User login(
            String email,
            String password) {

        String sql =
                "SELECT * FROM users "
                + "WHERE email=? "
                + "AND password=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs =
                    pst.executeQuery();

            if (rs.next()) {

                int userId =
                        rs.getInt("user_id");

                String fullName =
                        rs.getString("full_name");

                String role =
                        rs.getString("role");

                return UserFactory.createUser(
                        role,
                        userId,
                        email,
                        password,
                        fullName,
                        email
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

    // =========================
    // GET ROLE
    // =========================

    public String getRole(
            String email) {

        String sql =
                "SELECT role "
                + "FROM users "
                + "WHERE email=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, email);

            ResultSet rs =
                    pst.executeQuery();

            if (rs.next()) {

                return rs.getString("role");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

    // =========================
    // GET PARENT ID
    // =========================

    public int getParentId(
            int userId) {

        String sql =
                "SELECT parent_id "
                + "FROM parents "
                + "WHERE user_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, userId);

            ResultSet rs =
                    pst.executeQuery();

            if (rs.next()) {

                return rs.getInt(
                        "parent_id");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return 0;
    }

    // =========================
    // VALIDATE LOGIN
    // =========================

    public boolean validateLogin(
            String email,
            String password) {

        return login(
                email,
                password) != null;
    }
}