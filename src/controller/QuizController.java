package controller;

import Entity.Quiz;
import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class QuizController {

    public boolean addQuiz(
            String quizId,
            String title,
            String subjectCode) {

        String sql =
                "INSERT INTO quizzes "
                + "(quiz_id,title,subject_code) "
                + "VALUES(?,?,?)";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, quizId);
            pst.setString(2, title);
            pst.setString(3, subjectCode);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean updateQuiz(
            String quizId,
            String title,
            String subjectCode) {

        String sql =
                "UPDATE quizzes "
                + "SET title=?, "
                + "subject_code=? "
                + "WHERE quiz_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, title);
            pst.setString(2, subjectCode);
            pst.setString(3, quizId);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteQuiz(
            String quizId) {

        String sql =
                "DELETE FROM quizzes "
                + "WHERE quiz_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, quizId);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public Quiz searchQuiz(
            String quizId) {

        String sql =
                "SELECT * FROM quizzes "
                + "WHERE quiz_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, quizId);

            ResultSet rs =
                    pst.executeQuery();

            if(rs.next()) {

                return new Quiz(

                        rs.getString(
                                "quiz_id"),

                        rs.getString(
                                "title"),

                        rs.getString(
                                "subject_code")
                );
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Quiz>
    getAllQuizzes() {

        ArrayList<Quiz> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM quizzes";

        try {

            Connection conn =
                    DBConnection.getConnection();

            Statement st =
                    conn.createStatement();

            ResultSet rs =
                    st.executeQuery(sql);

            while(rs.next()) {

                Quiz quiz =
                        new Quiz(

                                rs.getString(
                                        "quiz_id"),

                                rs.getString(
                                        "title"),

                                rs.getString(
                                        "subject_code")
                        );

                list.add(quiz);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}