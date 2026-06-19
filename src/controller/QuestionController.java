package controller;

import Entity.Question;
import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class QuestionController {

    public boolean addQuestion(
            String quizId,
            String questionText,
            String optionA,
            String optionB,
            String optionC,
            String optionD,
            String correctAnswer) {

        String sql =
                "INSERT INTO questions "
                + "(quiz_id,question_text,"
                + "option_a,option_b,"
                + "option_c,option_d,"
                + "correct_answer) "
                + "VALUES(?,?,?,?,?,?,?)";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, quizId);
            pst.setString(2, questionText);
            pst.setString(3, optionA);
            pst.setString(4, optionB);
            pst.setString(5, optionC);
            pst.setString(6, optionD);
            pst.setString(7, correctAnswer);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean updateQuestion(
            int questionId,
            String questionText,
            String optionA,
            String optionB,
            String optionC,
            String optionD,
            String correctAnswer) {

        String sql =
                "UPDATE questions "
                + "SET question_text=?, "
                + "option_a=?, "
                + "option_b=?, "
                + "option_c=?, "
                + "option_d=?, "
                + "correct_answer=? "
                + "WHERE question_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, questionText);
            pst.setString(2, optionA);
            pst.setString(3, optionB);
            pst.setString(4, optionC);
            pst.setString(5, optionD);
            pst.setString(6, correctAnswer);
            pst.setInt(7, questionId);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteQuestion(
            int questionId) {

        String sql =
                "DELETE FROM questions "
                + "WHERE question_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, questionId);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Question>
    getQuestionsByQuiz(
            String quizId) {

        ArrayList<Question> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM questions "
                + "WHERE quiz_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, quizId);

            ResultSet rs =
                    pst.executeQuery();

            while(rs.next()) {

                Question question =
                        new Question(

                                rs.getInt("question_id"),
                                rs.getString("quiz_id"),
                                rs.getString("question_text"),
                                rs.getString("option_a"),
                                rs.getString("option_b"),
                                rs.getString("option_c"),
                                rs.getString("option_d"),
                                rs.getString("correct_answer")
                        );

                list.add(question);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }

    public Question searchQuestion(
            int questionId) {

        String sql =
                "SELECT * FROM questions "
                + "WHERE question_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, questionId);

            ResultSet rs =
                    pst.executeQuery();

            if(rs.next()) {

                return new Question(

                        rs.getInt("question_id"),
                        rs.getString("quiz_id"),
                        rs.getString("question_text"),
                        rs.getString("option_a"),
                        rs.getString("option_b"),
                        rs.getString("option_c"),
                        rs.getString("option_d"),
                        rs.getString("correct_answer")
                );
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}