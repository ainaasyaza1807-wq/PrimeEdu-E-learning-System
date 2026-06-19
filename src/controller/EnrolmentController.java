package controller;

import Entity.Enrolment;
import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class EnrolmentController {

    public boolean enrollStudent(
            int studentId,
            int courseId) {

        String sql =
                "INSERT INTO enrolments "
                + "(student_id,course_id,"
                + "progress,status) "
                + "VALUES(?,?,0,'ENROLLED')";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, studentId);
            pst.setInt(2, courseId);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean dropCourse(
            int enrolmentId) {

        String sql =
                "DELETE FROM enrolments "
                + "WHERE enrolment_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, enrolmentId);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean updateProgress(
            int enrolmentId,
            int progress) {

        String status =
                progress >= 100
                        ? "COMPLETED"
                        : "IN PROGRESS";

        String sql =
                "UPDATE enrolments "
                + "SET progress=?, "
                + "status=? "
                + "WHERE enrolment_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, progress);
            pst.setString(2, status);
            pst.setInt(3, enrolmentId);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Enrolment>
    getStudentEnrollments(
            int studentId) {

        ArrayList<Enrolment> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM enrolments "
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

                Enrolment enrolment =
                        new Enrolment(

                                rs.getInt(
                                        "enrolment_id"),

                                rs.getInt(
                                        "student_id"),

                                rs.getInt(
                                        "course_id"),

                                rs.getInt(
                                        "progress"),

                                rs.getString(
                                        "status")
                        );

                list.add(enrolment);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}