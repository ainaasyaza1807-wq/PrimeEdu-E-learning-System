package module_2;

import controller.SubjectController;

import javax.swing.*;
import java.awt.*;

public class CreateSubjectUI extends JFrame {

    private JComboBox<String> cmbStandard;

    private JTextField txtSubjectCode;
    private JTextField txtInstructorName;
    private JTextField txtSubjectName;

    private JButton btnSaveSubject;
    private JButton btnBack;

    public CreateSubjectUI() {

        setTitle("Create Subject");
        setSize(900, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeUI();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel = new JPanel(null);

        JLabel lblTitle =
                new JLabel("Create Subject");

        lblTitle.setFont(
                new Font("Arial",
                        Font.BOLD,
                        24));

        lblTitle.setBounds(
                350,
                50,
                250,
                30);

        panel.add(lblTitle);

        // Standard

        JLabel lblStandard =
                new JLabel("Standard:");

        lblStandard.setBounds(
                380,
                120,
                100,
                25);

        panel.add(lblStandard);

        cmbStandard =
                new JComboBox<>();

        cmbStandard.addItem("Standard 4");
        cmbStandard.addItem("Standard 5");
        cmbStandard.addItem("Standard 6");

        cmbStandard.setBounds(
                350,
                150,
                150,
                30);

        panel.add(cmbStandard);

        // Subject Code

        JLabel lblSubjectCode =
                new JLabel("Subject Code:");

        lblSubjectCode.setBounds(
                120,
                220,
                120,
                25);

        panel.add(lblSubjectCode);

        txtSubjectCode =
                new JTextField();

        txtSubjectCode.setBounds(
                120,
                250,
                150,
                30);

        panel.add(txtSubjectCode);

        // Instructor Name

        JLabel lblInstructorName =
                new JLabel("Instructor Name:");

        lblInstructorName.setBounds(
                350,
                220,
                150,
                25);

        panel.add(lblInstructorName);

        txtInstructorName =
                new JTextField();

        txtInstructorName.setBounds(
                350,
                250,
                220,
                30);

        panel.add(txtInstructorName);

        // Subject Name

        JLabel lblSubjectName =
                new JLabel("Subject Name:");

        lblSubjectName.setBounds(
                650,
                220,
                120,
                25);

        panel.add(lblSubjectName);

        txtSubjectName =
                new JTextField();

        txtSubjectName.setBounds(
                650,
                250,
                150,
                30);

        panel.add(txtSubjectName);

        // Save Button

        btnSaveSubject =
                new JButton("Save Subject");

        btnSaveSubject.setBounds(
                350,
                350,
                180,
                40);

        panel.add(btnSaveSubject);

        // Back Button

        btnBack =
                new JButton("< Back to Dashboard");

        btnBack.setBounds(
                600,
                420,
                220,
                40);

        panel.add(btnBack);

        add(panel);

        // Actions

        btnSaveSubject.addActionListener(
                e -> saveSubject());

        btnBack.addActionListener(
                e -> {

                    dispose();

                    // nanti link dashboard sebenar
                    // new DashboardUI();
                });
    }

    private void saveSubject() {

        SubjectController controller =
                new SubjectController();

        boolean success =
                controller.addSubject(

                        cmbStandard
                                .getSelectedItem()
                                .toString(),

                        txtSubjectCode.getText(),

                        txtInstructorName.getText(),

                        txtSubjectName.getText()
                );

        if(success){

            JOptionPane.showMessageDialog(
                    this,
                    "Subject Saved Successfully");

            clearFields();

        }else{

            JOptionPane.showMessageDialog(
                    this,
                    "Failed To Save Subject");
        }
    }

    private void clearFields() {

        txtSubjectCode.setText("");
        txtInstructorName.setText("");
        txtSubjectName.setText("");

        cmbStandard.setSelectedIndex(0);
    }
}