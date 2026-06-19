package ui;

import module_1.ChildManagementFrame;
import module_1.ViewRecordsUI;

import javax.swing.*;
import java.awt.*;

public class ParentDashboard extends JFrame {

    private JButton btnManageChild;
    private JButton btnViewRecords;
    private JButton btnLogout;
    private int parentId;

    public ParentDashboard(int parentId) {

    this.parentId = parentId;

    setTitle("Parent Dashboard");
    setSize(700, 500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    initializeUI();

    setVisible(true);
}

    private void initializeUI() {

        JPanel panel = new JPanel(null);

        JLabel lblTitle =
                new JLabel("PARENT DASHBOARD");

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

        btnManageChild =
                new JButton("Manage Child");

        btnViewRecords =
                new JButton("View Child Records");

        btnLogout =
                new JButton("Logout");

        btnManageChild.setBounds(
                240,
                130,
                200,
                40);

        btnViewRecords.setBounds(
                240,
                190,
                200,
                40);

        btnLogout.setBounds(
                240,
                250,
                200,
                40);

        panel.add(btnManageChild);
        panel.add(btnViewRecords);
        panel.add(btnLogout);

        add(panel);

        // Manage Child

        btnManageChild.addActionListener(e -> {

    new ChildManagementFrame(
            parentId);

    dispose();
});

        // View Child Records

        btnViewRecords.addActionListener(e -> {

            new ViewRecordsUI();

            dispose();
        });

        // Logout

        btnLogout.addActionListener(e -> {

            new LoginFrame();

            dispose();
        });
    }
}