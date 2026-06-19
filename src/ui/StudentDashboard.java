package ui;

import module_3.AvailableCoursesFrame;
import module_3.MyCoursesFrame;
import module_3.ProgressTrackingFrame;
import module_4.SubmitAssessmentFrame;
import module_4.TakeQuizFrame;
import module_4.ViewAssessmentFeedbackFrame;
import module_4.ViewResultsFrame;

import javax.swing.*;
import java.awt.*;

public class StudentDashboard extends JFrame {

    private JButton btnCourses;
    private JButton btnMyCourses;
    private JButton btnProgress;

    private JButton btnQuiz;
    private JButton btnResults;

    private JButton btnSubmitAssessment;
    private JButton btnFeedback;

    private JButton btnLogout;

    public StudentDashboard() {

        setTitle("Student Dashboard");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeUI();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel = new JPanel(null);

        JLabel lblTitle =
                new JLabel(
                        "STUDENT DASHBOARD");

        lblTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24));

        lblTitle.setBounds(
                280,
                20,
                300,
                30);

        panel.add(lblTitle);

        btnCourses =
                new JButton(
                        "Available Courses");

        btnMyCourses =
                new JButton(
                        "My Courses");

        btnProgress =
                new JButton(
                        "Track Progress");

        btnQuiz =
                new JButton(
                        "Take Quiz");

        btnResults =
                new JButton(
                        "View Results");

        btnSubmitAssessment =
                new JButton(
                        "Submit Assessment");

        btnFeedback =
                new JButton(
                        "View Feedback");

        btnLogout =
                new JButton(
                        "Logout");

        btnCourses.setBounds(
                100,100,220,40);

        btnMyCourses.setBounds(
                100,160,220,40);

        btnProgress.setBounds(
                100,220,220,40);

        btnQuiz.setBounds(
                450,100,220,40);

        btnResults.setBounds(
                450,160,220,40);

        btnSubmitAssessment.setBounds(
                450,220,220,40);

        btnFeedback.setBounds(
                275,300,220,40);

        btnLogout.setBounds(
                275,400,220,40);

        panel.add(btnCourses);
        panel.add(btnMyCourses);
        panel.add(btnProgress);

        panel.add(btnQuiz);
        panel.add(btnResults);

        panel.add(btnSubmitAssessment);
        panel.add(btnFeedback);

        panel.add(btnLogout);

        add(panel);

        // MODULE 3

        btnCourses.addActionListener(e -> {
            new AvailableCoursesFrame();
        });

        btnMyCourses.addActionListener(e -> {
            new MyCoursesFrame();
        });

        btnProgress.addActionListener(e -> {
            new ProgressTrackingFrame();
        });

        // MODULE 4

        btnQuiz.addActionListener(e -> {
            new TakeQuizFrame();
        });

        btnResults.addActionListener(e -> {
            new ViewResultsFrame();
        });

        btnSubmitAssessment.addActionListener(e -> {
            new SubmitAssessmentFrame();
        });

        btnFeedback.addActionListener(e -> {
            new ViewAssessmentFeedbackFrame();
        });

        // LOGOUT

        btnLogout.addActionListener(e -> {

            new LoginFrame();

            dispose();
        });
    }
}