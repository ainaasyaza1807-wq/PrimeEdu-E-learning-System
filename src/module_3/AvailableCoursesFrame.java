package module_3;

import controller.CourseController;
import controller.EnrolmentController;
import Entity.Course;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class AvailableCoursesFrame extends JFrame {

    private JTable tblCourses;
    private DefaultTableModel model;

    private JButton btnEnroll;
    private JButton btnBack;

    // Temporary Student ID
    private final int studentId = 1;

    public AvailableCoursesFrame() {

        setTitle("Available Courses");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initializeUI();

        loadCourses();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel = new JPanel(null);

        JLabel lblTitle =
                new JLabel("AVAILABLE COURSES");

        lblTitle.setBounds(
                300,
                20,
                250,
                30);

        panel.add(lblTitle);

        model =
                new DefaultTableModel();

        model.addColumn("Course ID");
        model.addColumn("Course Name");
        model.addColumn("Description");
        model.addColumn("Instructor ID");

        tblCourses =
                new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(tblCourses);

        scrollPane.setBounds(
                40,
                70,
                700,
                250);

        panel.add(scrollPane);

        btnEnroll =
                new JButton("Enroll Course");

        btnBack =
                new JButton("Back");

        btnEnroll.setBounds(
                220,
                350,
                150,
                35);

        btnBack.setBounds(
                420,
                350,
                150,
                35);

        panel.add(btnEnroll);
        panel.add(btnBack);

        add(panel);

        btnEnroll.addActionListener(
                e -> enrollCourse());

        btnBack.addActionListener(
                e -> dispose());
    }

    private void loadCourses() {

        model.setRowCount(0);

        CourseController controller =
                new CourseController();

        ArrayList<Course> courses =
                controller.getAllCourses();

        for (Course course : courses) {

            model.addRow(new Object[]{

                    course.getCourseId(),
                    course.getCourseName(),
                    course.getDescription(),
                    course.getInstructorId()
            });
        }
    }

    private void enrollCourse() {

        int row =
                tblCourses.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a course");

            return;
        }

        int courseId =
                Integer.parseInt(
                        model.getValueAt(
                                row,
                                0).toString());

        EnrolmentController controller =
                new EnrolmentController();

        boolean success =
                controller.enrollStudent(
                        studentId,
                        courseId);

        if (success) {

            JOptionPane.showMessageDialog(
                    this,
                    "Course Enrolled Successfully");

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Enrollment Failed");
        }
    }
}