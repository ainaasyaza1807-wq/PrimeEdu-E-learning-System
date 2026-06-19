package controller;

import Entity.Course;
import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class CourseController {

    public boolean addCourse(
            String courseName,
            String description,
            int instructorId) {

        String sql =
                "INSERT INTO courses "
                + "(course_name,description,instructor_id) "
                + "VALUES(?,?,?)";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, courseName);
            pst.setString(2, description);
            pst.setInt(3, instructorId);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean updateCourse(
            int courseId,
            String courseName,
            String description,
            int instructorId) {

        String sql =
                "UPDATE courses "
                + "SET course_name=?, "
                + "description=?, "
                + "instructor_id=? "
                + "WHERE course_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, courseName);
            pst.setString(2, description);
            pst.setInt(3, instructorId);
            pst.setInt(4, courseId);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteCourse(
            int courseId) {

        String sql =
                "DELETE FROM courses "
                + "WHERE course_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, courseId);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public Course searchCourse(
            int courseId) {

        String sql =
                "SELECT * FROM courses "
                + "WHERE course_id=?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, courseId);

            ResultSet rs =
                    pst.executeQuery();

            if(rs.next()) {

                return new Course(

                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getString("description"),
                        rs.getInt("instructor_id")
                );
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Course> getAllCourses() {

        ArrayList<Course> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM courses";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    pst.executeQuery();

            while(rs.next()) {

                Course course =
                        new Course(

                                rs.getInt("course_id"),
                                rs.getString("course_name"),
                                rs.getString("description"),
                                rs.getInt("instructor_id")
                        );

                list.add(course);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}