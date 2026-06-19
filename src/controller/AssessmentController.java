package controller;

import Entity.Assessment;
import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class AssessmentController {

    public boolean addAssessment(
        String assessmentId,
        String title,
        String description,
        int instructorId,
        String assessmentFile) {

    String sql =
            "INSERT INTO assessments "
            + "(assessment_id,title,"
            + "description,instructor_id,"
            + "assessment_file) "
            + "VALUES(?,?,?,?,?)";

    try {

        Connection conn =
                DBConnection.getConnection();

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setString(1, assessmentId);
        pst.setString(2, title);
        pst.setString(3, description);
        pst.setInt(4, instructorId);
        pst.setString(5, assessmentFile);

        return pst.executeUpdate() > 0;

    } catch(Exception e) {

        e.printStackTrace();
    }

    return false;
    }

    public boolean updateAssessment(
            String assessmentId,
            String title,
            String description) {

        String sql =
                "UPDATE assessments "
                + "SET title=?, "
                + "description=? "
                + "WHERE assessment_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, title);
            pst.setString(2, description);
            pst.setString(3, assessmentId);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteAssessment(
            String assessmentId) {

        String sql =
                "DELETE FROM assessments "
                + "WHERE assessment_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, assessmentId);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public Assessment searchAssessment(
            String assessmentId) {

        String sql =
                "SELECT * FROM assessments "
                + "WHERE assessment_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, assessmentId);

            ResultSet rs =
                    pst.executeQuery();

            if(rs.next()) {

                return new Assessment(

                        rs.getString("assessment_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("instructor_id"),
                        rs.getString("assessment_file")
                );
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Assessment>
    getAllAssessments() {

        ArrayList<Assessment> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM assessments";

        try {

            Connection conn =
                    DBConnection.getConnection();

            Statement st =
                    conn.createStatement();

            ResultSet rs =
                    st.executeQuery(sql);

            while(rs.next()) {

                Assessment assessment =
                        new Assessment(

                        rs.getString("assessment_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("instructor_id"),
                        rs.getString("assessment_file")
                    );

                list.add(assessment);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}