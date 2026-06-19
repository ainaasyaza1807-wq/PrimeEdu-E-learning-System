package controller;

import javax.swing.JOptionPane;
import Entity.Submission;
import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class SubmissionController {

    public boolean submitAssessment(
        String assessmentId,
        int studentId,
        String submissionText,
        String submissionFile) {

    String sql =
            "INSERT INTO submissions "
            + "(assessment_id,"
            + "student_id,"
            + "submission_text,"
            + "file_path,"
            + "marks,"
            + "feedback,"
            + "status)"
            + " VALUES(?,?,?,?,?,?,?)";

    try {

        Connection conn =
                DBConnection.getConnection();

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setString(1, assessmentId);
        pst.setInt(2, studentId);
        pst.setString(3, submissionText);
        pst.setString(4, submissionFile);

        pst.setInt(5, 0);
        pst.setString(6, "");
        pst.setString(7, "PENDING");

        return pst.executeUpdate() > 0;

    } catch(Exception e) {

    e.printStackTrace();

    JOptionPane.showMessageDialog(
            null,
            e.getMessage()
    );
}

    return false;
    }

    public Submission searchSubmission(
            int submissionId) {

        String sql =
                "SELECT * FROM submissions "
                + "WHERE submission_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, submissionId);

            ResultSet rs =
                    pst.executeQuery();
            
            System.out.println(
            "Searching ID = "
            + submissionId);
            
            if(rs.next()) {
                System.out.println(
                "FOUND");
                return new Submission(

                        rs.getInt("submission_id"),
                        rs.getString("assessment_id"),
                        rs.getInt("student_id"),
                        rs.getString("submission_text"),
                        rs.getString("file_path"),
                        rs.getInt("marks"),
                        rs.getString("feedback"),
                        rs.getString("status")
                );
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Submission>
    getAllSubmissions() {

        ArrayList<Submission> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM submissions";

        try {

            Connection conn =
                    DBConnection.getConnection();

            Statement st =
                    conn.createStatement();

            ResultSet rs =
                    st.executeQuery(sql);

            while(rs.next()) {

                Submission submission =
                        new Submission(

                                rs.getInt("submission_id"),
                                rs.getString("assessment_id"),
                                rs.getInt("student_id"),
                                rs.getString("submission_text"),
                                rs.getString("file_path"),
                                rs.getInt("marks"),
                                rs.getString("feedback"),
                                rs.getString("status")

                        );

                list.add(submission);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Submission>
    getStudentSubmissions(
            int studentId) {

        ArrayList<Submission> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM submissions "
                + "WHERE student_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, studentId);

            ResultSet rs =
                    pst.executeQuery();

            while(rs.next()) {

                Submission submission =
                        new Submission(

                                rs.getInt("submission_id"),
                                rs.getString("assessment_id"),
                                rs.getInt("student_id"),
                                rs.getString("submission_text"),
                                rs.getString("file_path"),
                                rs.getInt("marks"),
                                rs.getString("feedback"),
                                rs.getString("status")
                        );

                list.add(submission);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }
    
    public boolean gradeSubmission(
        int submissionId,
        int marks,
        String feedback) {

    String sql =
            "UPDATE submissions "
            + "SET marks=?, "
            + "feedback=?, "
            + "status='GRADED' "
            + "WHERE submission_id=?";

    try {

        Connection conn =
                DBConnection.getConnection();

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setInt(1, marks);
        pst.setString(2, feedback);
        pst.setInt(3, submissionId);

        int rows =
                pst.executeUpdate();

        System.out.println(
                "Rows Updated = "
                + rows);

        return rows > 0;

    } catch(Exception e) {

        e.printStackTrace();
    }

    return false;
}   
    
    public boolean deleteSubmission(
        int submissionId) {

    String sql =
            "DELETE FROM submissions "
            + "WHERE submission_id=?";

    try {

        Connection conn =
                DBConnection.getConnection();

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setInt(1, submissionId);

        return pst.executeUpdate() > 0;

    } catch(Exception e){

        e.printStackTrace();
    }

    return false;
    }
}
