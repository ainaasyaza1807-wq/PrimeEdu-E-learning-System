package controller;

import database.DBConnection;
import entity.ChildProfile;

import java.sql.*;
import java.util.ArrayList;

public class ChildController {

public boolean addChild(
int parentId,
String childName,
String childEmail,
String childPassword,
String standard,
String schoolName) {

try {

    Connection conn =
            DBConnection.getConnection();

    String userSql =
    "INSERT INTO users "
    + "(username,password,full_name,email,role) "
    + "VALUES(?,?,?,?,?)";

    PreparedStatement pst1 =
            conn.prepareStatement(
                    userSql,
                    Statement.RETURN_GENERATED_KEYS);

    pst1.setString(1, childEmail);
    pst1.setString(2, childPassword);
    pst1.setString(3, childName);
    pst1.setString(4, childEmail);
    pst1.setString(5, "STUDENT");

    pst1.executeUpdate();

    ResultSet rs =
            pst1.getGeneratedKeys();

    int userId = 0;

    if(rs.next()) {

        userId = rs.getInt(1);
    }

    String studentSql =
            "INSERT INTO students "
            + "(user_id,level,parent_id) "
            + "VALUES(?,?,?)";

    PreparedStatement pst2 =
            conn.prepareStatement(studentSql);

    pst2.setInt(1, userId);
    pst2.setString(2, standard);
    pst2.setInt(3, parentId);

    pst2.executeUpdate();

    String childSql =
            "INSERT INTO child_profiles "
            + "(parent_id,child_name,"
            + "child_email,child_password,"
            + "standard,school_name) "
            + "VALUES(?,?,?,?,?,?)";

    PreparedStatement pst3 =
            conn.prepareStatement(childSql);

    pst3.setInt(1, parentId);
    pst3.setString(2, childName);
    pst3.setString(3, childEmail);
    pst3.setString(4, childPassword);
    pst3.setString(5, standard);
    pst3.setString(6, schoolName);

    return pst3.executeUpdate() > 0;

} catch(SQLException e) {

    e.printStackTrace();
}

return false;

}


public boolean updateChild(
        int childId,
        String childName,
        String childEmail,
        String childPassword,
        String standard,
        String schoolName) {

    String sql =
            "UPDATE child_profiles "
            + "SET child_name=?, "
            + "child_email=?, "
            + "child_password=?, "
            + "standard=?, "
            + "school_name=? "
            + "WHERE child_id=?";

    try {

        Connection conn =
                DBConnection.getConnection();

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setString(1, childName);
        pst.setString(2, childEmail);
        pst.setString(3, childPassword);
        pst.setString(4, standard);
        pst.setString(5, schoolName);
        pst.setInt(6, childId);

        return pst.executeUpdate() > 0;

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return false;
}

public boolean deleteChild(int childId) {

    String sql =
            "DELETE FROM child_profiles "
            + "WHERE child_id=?";

    try {

        Connection conn =
                DBConnection.getConnection();

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setInt(1, childId);

        return pst.executeUpdate() > 0;

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return false;
}

public ChildProfile searchChild(int childId) {

    String sql =
            "SELECT * FROM child_profiles "
            + "WHERE child_id=?";

    try {

        Connection conn =
                DBConnection.getConnection();

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setInt(1, childId);

        ResultSet rs =
                pst.executeQuery();

        if (rs.next()) {

            return new ChildProfile(
                    rs.getInt("child_id"),
                    rs.getString("child_name"),
                    rs.getString("child_email"),
                    rs.getString("child_password"),
                    rs.getString("standard"),
                    rs.getString("school_name")
            );
        }

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return null;
}

public ArrayList<ChildProfile>
getAllChildren(int parentId) {

    ArrayList<ChildProfile> children =
            new ArrayList<>();

    String sql =
            "SELECT * FROM child_profiles "
            + "WHERE parent_id=?";

    try {

        Connection conn =
                DBConnection.getConnection();

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setInt(1, parentId);

        ResultSet rs =
                pst.executeQuery();

        while (rs.next()) {

            children.add(
                    new ChildProfile(
                            rs.getInt("child_id"),
                            rs.getString("child_name"),
                            rs.getString("child_email"),
                            rs.getString("child_password"),
                            rs.getString("standard"),
                            rs.getString("school_name")
                    )
            );
        }

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return children;
}

}
