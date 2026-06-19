package controller;

import Entity.Result;
import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class ResultController {

    public boolean saveResult(
            String quizId,
            int studentId,
            int score) {

        String sql =
                "INSERT INTO results "
                + "(quiz_id,student_id,score) "
                + "VALUES(?,?,?)";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, quizId);
            pst.setInt(2, studentId);
            pst.setInt(3, score);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public Result searchResult(
            int resultId) {

        String sql =
                "SELECT * FROM results "
                + "WHERE result_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, resultId);

            ResultSet rs =
                    pst.executeQuery();

            if(rs.next()) {

                return new Result(

                        rs.getInt("result_id"),
                        rs.getString("quiz_id"),
                        rs.getInt("student_id"),
                        rs.getInt("score")
                );
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Result>
    getAllResults() {

        ArrayList<Result> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM results";

        try {

            Connection conn =
                    DBConnection.getConnection();

            Statement st =
                    conn.createStatement();

            ResultSet rs =
                    st.executeQuery(sql);

            while(rs.next()) {

                Result result =
                        new Result(

                                rs.getInt("result_id"),
                                rs.getString("quiz_id"),
                                rs.getInt("student_id"),
                                rs.getInt("score")
                        );

                list.add(result);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Result>
    getStudentResults(
            int studentId) {

        ArrayList<Result> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM results "
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

                Result result =
                        new Result(

                                rs.getInt("result_id"),
                                rs.getString("quiz_id"),
                                rs.getInt("student_id"),
                                rs.getInt("score")
                        );

                list.add(result);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }

    public boolean deleteResult(
            int resultId) {

        String sql =
                "DELETE FROM results "
                + "WHERE result_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, resultId);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }
}