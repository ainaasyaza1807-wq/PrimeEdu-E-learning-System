package controller;

import Entity.Topic;
import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class TopicController {

    public boolean addTopic(
            int courseId,
            String topicName) {

        String sql =
                "INSERT INTO topics "
                + "(course_id,topic_name) "
                + "VALUES(?,?)";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, courseId);
            pst.setString(2, topicName);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean updateTopic(
            int topicId,
            String topicName) {

        String sql =
                "UPDATE topics "
                + "SET topic_name=? "
                + "WHERE topic_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, topicName);
            pst.setInt(2, topicId);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteTopic(
            int topicId) {

        String sql =
                "DELETE FROM topics "
                + "WHERE topic_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, topicId);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean markCompleted(
            int topicId) {

        String sql =
                "UPDATE topics "
                + "SET completed=1 "
                + "WHERE topic_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, topicId);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Topic>
    getTopicsByCourse(int courseId) {

        ArrayList<Topic> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM topics "
                + "WHERE course_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, courseId);

            ResultSet rs =
                    pst.executeQuery();

            while(rs.next()) {

                Topic topic =
                        new Topic(

                                rs.getInt("topic_id"),
                                rs.getInt("course_id"),
                                rs.getString("topic_name"),
                                rs.getBoolean("completed")
                        );

                list.add(topic);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}