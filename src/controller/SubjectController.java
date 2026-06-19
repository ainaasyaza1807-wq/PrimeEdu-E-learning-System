package controller;

import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class SubjectController {

    public boolean addSubject(

        String standard,
        String subjectCode,
        String instructorName,
        String subjectName) {

    String sql =
            "INSERT INTO subjects "
            + "(standard,"
            + "subject_code,"
            + "instructor_name,"
            + "subject_name)"
            + " VALUES(?,?,?,?)";

    try {

        Connection conn =
                DBConnection.getConnection();

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setString(1, standard);
        pst.setString(2, subjectCode);
        pst.setString(3, instructorName);
        pst.setString(4, subjectName);

        return pst.executeUpdate() > 0;

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return false;
    }

    public ArrayList<String>
    getAllSubjects() {

        ArrayList<String> subjects =
                new ArrayList<>();

        String sql =
                "SELECT * FROM subjects";

        try {

            Connection conn =
                    DBConnection.getConnection();

            Statement st =
                    conn.createStatement();

            ResultSet rs =
                    st.executeQuery(sql);

            while(rs.next()){

                subjects.add(
                        rs.getString(
                                "subject_name")
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return subjects;
    }
    
    public ArrayList<Object[]> getRecords() {

    ArrayList<Object[]> list =
            new ArrayList<>();

    String sql =
            "SELECT s.standard, "
            + "s.subject_code, "
            + "s.subject_name, "
            + "s.instructor_name, "
            + "m.title "
            + "FROM subjects s "
            + "LEFT JOIN materials m "
            + "ON s.subject_id = m.subject_id";

    try {

        Connection conn =
                DBConnection.getConnection();

        Statement st =
                conn.createStatement();

        ResultSet rs =
                st.executeQuery(sql);

        while(rs.next()){

            list.add(new Object[]{

                    rs.getString(
                            "standard"),

                    rs.getString(
                            "subject_code"),

                    rs.getString(
                            "subject_name"),

                    rs.getString(
                            "instructor_name"),

                    rs.getString(
                            "title")
            });
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    return list;
    }
}