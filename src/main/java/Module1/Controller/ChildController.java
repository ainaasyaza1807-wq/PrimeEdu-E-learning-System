package Module1.Controller;

import Entity.ChildProfile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChildController {

    private final String url = "jdbc:mysql://localhost:3306/primeedu_db";
    private final String user = "root";
    private final String pass = "";

    // Register Child Profile
    public boolean registerChild(ChildProfile child) {

        String query = "INSERT INTO child_profiles "
                + "(parent_id, child_name, child_standard, school_name, child_email, child_password) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, child.getParentId());
            stmt.setString(2, child.getChildName());
            stmt.setString(3, child.getChildStandard());
            stmt.setString(4, child.getSchoolName());
            stmt.setString(5, child.getChildEmail());
            stmt.setString(6, child.getChildPassword());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // View Child Profiles
    public List<ChildProfile> viewChildrenList(int parentId) {

        List<ChildProfile> list = new ArrayList<>();

        String query = "SELECT * FROM child_profiles WHERE parent_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, parentId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                ChildProfile child = new ChildProfile(
                        rs.getInt("parent_id"),
                        rs.getString("child_name"),
                        rs.getString("child_standard"),
                        rs.getString("school_name"),
                        rs.getString("child_email"),
                        rs.getString("child_password")
                );

                child.setChildId(rs.getInt("child_id"));

                list.add(child);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Update Child Profile
    public boolean updateChildProfile(ChildProfile child, String originalEmail) {

        String query = "UPDATE child_profiles "
                + "SET child_name=?, "
                + "child_standard=?, "
                + "school_name=?, "
                + "child_email=?, "
                + "child_password=? "
                + "WHERE child_email=?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, child.getChildName());
            stmt.setString(2, child.getChildStandard());
            stmt.setString(3, child.getSchoolName());
            stmt.setString(4, child.getChildEmail());
            stmt.setString(5, child.getChildPassword());
            stmt.setString(6, originalEmail);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}