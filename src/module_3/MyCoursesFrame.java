package module_3;

import database.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import ui.StudentDashboard;

public class MyCoursesFrame extends JFrame {

    private JTable tblCourses;
    private DefaultTableModel model;

    private JButton btnRefresh;
    private JButton btnBack;

    // TEMP STUDENT ID
    private final int studentId = 1;

    public MyCoursesFrame() {

        setTitle("My Courses");
        setSize(800,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initializeUI();

        loadCourses();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel = new JPanel(null);

        JLabel lblTitle =
                new JLabel("MY COURSES");

        lblTitle.setBounds(
                330,
                20,
                200,
                30);

        panel.add(lblTitle);

        model =
                new DefaultTableModel();

        model.addColumn("Course ID");
        model.addColumn("Course Name");
        model.addColumn("Description");
        model.addColumn("Progress");
        model.addColumn("Status");

        tblCourses =
                new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(tblCourses);

        scrollPane.setBounds(
                30,
                70,
                720,
                280);

        panel.add(scrollPane);

        btnRefresh =
                new JButton("Refresh");

        btnBack =
                new JButton("Back");

        btnRefresh.setBounds(
                250,
                380,
                120,
                35);

        btnBack.setBounds(
                400,
                380,
                120,
                35);

        panel.add(btnRefresh);
        panel.add(btnBack);

        add(panel);

        btnRefresh.addActionListener(
                e -> loadCourses());

        btnBack.addActionListener(
                e -> {

                    new StudentDashboard();
                    dispose();
                });
    }

    private void loadCourses() {

        model.setRowCount(0);

        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =

                    "SELECT c.course_id, "
                    + "c.course_name, "
                    + "c.description, "
                    + "e.progress, "
                    + "e.status "
                    + "FROM enrolments e "
                    + "JOIN courses c "
                    + "ON e.course_id = c.course_id "
                    + "WHERE e.student_id=?";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, studentId);

            ResultSet rs =
                    pst.executeQuery();

            while(rs.next()) {

                model.addRow(new Object[]{

                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getString("description"),
                        rs.getInt("progress") + "%",
                        rs.getString("status")
                });
            }

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}