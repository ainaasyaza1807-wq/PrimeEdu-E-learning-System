package controller;

import Entity.Feedback;
import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class FeedbackController {

    public boolean addFeedback(
            int studentId,
            int instructorId,
            String feedbackText) {

        String sql =
                "INSERT INTO feedbacks "
                + "(student_id,instructor_id,feedback_text) "
                + "VALUES(?,?,?)";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, studentId);
            pst.setInt(2, instructorId);
            pst.setString(3, feedbackText);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean updateFeedback(
            int feedbackId,
            String feedbackText) {

        String sql =
                "UPDATE feedbacks "
                + "SET feedback_text=? "
                + "WHERE feedback_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, feedbackText);
            pst.setInt(2, feedbackId);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteFeedback(
            int feedbackId) {

        String sql =
                "DELETE FROM feedbacks "
                + "WHERE feedback_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, feedbackId);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public Feedback searchFeedback(
            int feedbackId) {

        String sql =
                "SELECT * FROM feedbacks "
                + "WHERE feedback_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, feedbackId);

            ResultSet rs =
                    pst.executeQuery();

            if(rs.next()) {

                return new Feedback(

                        rs.getInt("feedback_id"),
                        rs.getInt("student_id"),
                        rs.getInt("instructor_id"),
                        rs.getString("feedback_text")
                );
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Feedback>
    getAllFeedbacks() {

        ArrayList<Feedback> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM feedbacks";

        try {

            Connection conn =
                    DBConnection.getConnection();

            Statement st =
                    conn.createStatement();

            ResultSet rs =
                    st.executeQuery(sql);

            while(rs.next()) {

                Feedback feedback =
                        new Feedback(

                                rs.getInt("feedback_id"),
                                rs.getInt("student_id"),
                                rs.getInt("instructor_id"),
                                rs.getString("feedback_text")
                        );

                list.add(feedback);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Feedback>
    getStudentFeedbacks(
            int studentId) {

        ArrayList<Feedback> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM feedbacks "
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

                Feedback feedback =
                        new Feedback(

                                rs.getInt("feedback_id"),
                                rs.getInt("student_id"),
                                rs.getInt("instructor_id"),
                                rs.getString("feedback_text")
                        );

                list.add(feedback);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}