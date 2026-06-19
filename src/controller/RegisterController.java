package controller;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterController {

public boolean isEmailExists(String email) {

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

    } catch(SQLException e) {

        e.printStackTrace();
    }

    return false;
}

public boolean registerParent(
        String password,
        String fullName,
        String email,
        String phoneNumber) {

    if(isEmailExists(email)) {

        return false;
    }

    try {

        Connection conn =
                DBConnection.getConnection();

        String userSql =
                "INSERT INTO users "
                + "(password,full_name,email,"
                + "phone_number,role) "
                + "VALUES(?,?,?,?,?)";

        PreparedStatement pst =
                conn.prepareStatement(
                        userSql,
                        PreparedStatement.RETURN_GENERATED_KEYS);

        pst.setString(1, password);
        pst.setString(2, fullName);
        pst.setString(3, email);
        pst.setString(4, phoneNumber);
        pst.setString(5, "PARENT");

        pst.executeUpdate();

        ResultSet rs =
                pst.getGeneratedKeys();

        int userId = 0;

        if(rs.next()) {

            userId = rs.getInt(1);
        }

        String parentSql =
                "INSERT INTO parents "
                + "(user_id,phone_number) "
                + "VALUES(?,?)";

        PreparedStatement pst2 =
                conn.prepareStatement(parentSql);

        pst2.setInt(1, userId);
        pst2.setString(2, phoneNumber);

        pst2.executeUpdate();

        return true;

    } catch(SQLException e) {

        e.printStackTrace();
    }

    return false;
}

public boolean registerInstructor(
        String password,
        String fullName,
        String email,
        String phoneNumber) {

    if(isEmailExists(email)) {

        return false;
    }

    try {

        Connection conn =
                DBConnection.getConnection();

        String sql =
                "INSERT INTO users "
                + "(password,full_name,email,"
                + "phone_number,role) "
                + "VALUES(?,?,?,?,?)";

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setString(1, password);
        pst.setString(2, fullName);
        pst.setString(3, email);
        pst.setString(4, phoneNumber);
        pst.setString(5, "INSTRUCTOR");

        pst.executeUpdate();

        return true;

    } catch(SQLException e) {

        e.printStackTrace();
    }

    return false;
}

}
