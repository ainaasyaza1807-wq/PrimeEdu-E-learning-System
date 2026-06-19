package ui;

import module_2.CreateSubjectUI;
import module_2.ManageMaterialsUI;
import module_2.UploadMaterialUI;

import module_4.CreateAssessmentFrame;
import module_4.CreateQuizFrame;
import module_4.GradeAssessmentFrame;
import module_4.QuestionManagementFrame;

import javax.swing.*;
import java.awt.*;

public class InstructorDashboard extends JFrame {

    private JButton btnCreateSubject;
    private JButton btnUploadMaterial;
    private JButton btnManageMaterial;

    private JButton btnCreateAssessment;
    private JButton btnGradeAssessment;

    private JButton btnCreateQuiz;
    private JButton btnManageQuestions;

    private JButton btnLogout;

    public InstructorDashboard() {

        setTitle("Instructor Dashboard");
        setSize(850,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeUI();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel = new JPanel(null);

        JLabel lblTitle =
                new JLabel("INSTRUCTOR DASHBOARD");

        lblTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24));

        lblTitle.setBounds(
                250,
                20,
                400,
                30);

        panel.add(lblTitle);

        // MODULE 2

        btnCreateSubject =
                new JButton("Create Subject");

        btnUploadMaterial =
                new JButton("Upload Material");

        btnManageMaterial =
                new JButton("Manage Materials");

        // MODULE 4

        btnCreateAssessment =
                new JButton("Create Assessment");

        btnGradeAssessment =
                new JButton("Grade Assessment");

        btnCreateQuiz =
                new JButton("Create Quiz");

        btnManageQuestions =
                new JButton("Manage Questions");

        btnLogout =
                new JButton("Logout");

        // LEFT SIDE

        btnCreateSubject.setBounds(
                80,100,250,40);

        btnUploadMaterial.setBounds(
                80,170,250,40);

        btnManageMaterial.setBounds(
                80,240,250,40);

        // RIGHT SIDE

        btnCreateAssessment.setBounds(
                480,100,250,40);

        btnGradeAssessment.setBounds(
                480,170,250,40);

        btnCreateQuiz.setBounds(
                480,240,250,40);

        btnManageQuestions.setBounds(
                480,310,250,40);

        btnLogout.setBounds(
                300,450,200,40);

        panel.add(btnCreateSubject);
        panel.add(btnUploadMaterial);
        panel.add(btnManageMaterial);

        panel.add(btnCreateAssessment);
        panel.add(btnGradeAssessment);
        panel.add(btnCreateQuiz);
        panel.add(btnManageQuestions);

        panel.add(btnLogout);

        add(panel);

        // MODULE 2

        btnCreateSubject.addActionListener(e -> {
            new CreateSubjectUI();
        });

        btnUploadMaterial.addActionListener(e -> {
            new UploadMaterialUI();
        });

        btnManageMaterial.addActionListener(e -> {
            new ManageMaterialsUI();
        });

        // MODULE 4

        btnCreateAssessment.addActionListener(e -> {
            new CreateAssessmentFrame();
        });

        btnGradeAssessment.addActionListener(e -> {
            new GradeAssessmentFrame();
        });

        btnCreateQuiz.addActionListener(e -> {
            new CreateQuizFrame();
        });

        btnManageQuestions.addActionListener(e -> {
            new QuestionManagementFrame();
        });

        // LOGOUT

        btnLogout.addActionListener(e -> {

            new LoginFrame();

            dispose();
        });
    }
}