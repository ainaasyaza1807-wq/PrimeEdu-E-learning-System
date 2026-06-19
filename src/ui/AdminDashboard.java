package ui;

import module_4.AdminAssessmentRecordsFrame;

import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {

    private JButton btnAssessmentRecords;
    private JButton btnLogout;

    public AdminDashboard() {

        setTitle("Admin Dashboard");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeUI();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel = new JPanel(null);

        JLabel lblTitle =
                new JLabel("ADMIN DASHBOARD");

        lblTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24));

        lblTitle.setBounds(
                200,
                40,
                300,
                30);

        panel.add(lblTitle);

        btnAssessmentRecords =
                new JButton(
                        "Assessment Records");

        btnLogout =
                new JButton(
                        "Logout");

        btnAssessmentRecords.setBounds(
                240,
                140,
                220,
                40);

        btnLogout.setBounds(
                240,
                220,
                220,
                40);

        panel.add(btnAssessmentRecords);
        panel.add(btnLogout);

        add(panel);

        // Assessment Records

        btnAssessmentRecords
                .addActionListener(e -> {

            new AdminAssessmentRecordsFrame();

            dispose();
        });

        // Logout

        btnLogout.addActionListener(e -> {

            new LoginFrame();

            dispose();
        });
    }
}