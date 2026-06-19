package module_4;

import controller.SubmissionController;

import javax.swing.*;
import java.awt.*;

public class SubmitAssessmentFrame extends JFrame {

    private JTextField txtSubmissionFile;
    private JButton btnBrowse;
    private JTextField txtAssessmentId;

    private JTextArea txtSubmission;

    private JButton btnSubmit;
    private JButton btnClear;
    private JButton btnBack;

    // TEMP STUDENT ID
    private final int studentId = 1;

    public SubmitAssessmentFrame() {

        setTitle("Submit Assessment");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initializeUI();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel = new JPanel(null);

        JLabel lblTitle =
                new JLabel("SUBMIT ASSESSMENT");

        lblTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20));

        lblTitle.setBounds(
                220,
                20,
                250,
                30);

        panel.add(lblTitle);

        JLabel lblAssessmentId =
                new JLabel("Assessment ID:");

        lblAssessmentId.setBounds(
                50,
                80,
                120,
                25);

        panel.add(lblAssessmentId);

        txtAssessmentId =
                new JTextField();

        txtAssessmentId.setBounds(
                180,
                80,
                200,
                25);

        panel.add(txtAssessmentId);

        JLabel lblSubmission =
                new JLabel("Submission:");

        lblSubmission.setBounds(
                50,
                130,
                120,
                25);

        panel.add(lblSubmission);

        txtSubmission =
                new JTextArea();

        JScrollPane scrollPane =
                new JScrollPane(
                        txtSubmission);

        scrollPane.setBounds(
                180,
                130,
                400,
                180);

        panel.add(scrollPane);
        
        JLabel lblFile =
        new JLabel("Answer File:");

        lblFile.setBounds(
        50,
        330,
        120,
        25);

        panel.add(lblFile);

        txtSubmissionFile =
        new JTextField();

        txtSubmissionFile.setBounds(
        180,
        330,
        250,
        25);

        panel.add(txtSubmissionFile);

        btnBrowse =
        new JButton("Browse");

        btnBrowse.setBounds(
        450,
        330,
        100,
        25);

        panel.add(btnBrowse);
        
        btnSubmit =
                new JButton("Submit");

        btnClear =
                new JButton("Clear");

        btnBack =
                new JButton("Back");

        btnSubmit.setBounds(
                180,
                390,
                120,
                35);
        btnClear.setBounds(
                320,
                390,
                120,
                35);

        btnBack.setBounds(
                460,
                390,
                120,
                35);

        panel.add(btnSubmit);
        panel.add(btnClear);
        panel.add(btnBack);

        add(panel);

        btnSubmit.addActionListener(
                e -> submitAssessment());

        btnClear.addActionListener(
                e -> clearForm());

        btnBack.addActionListener(
                e -> dispose());
        btnBrowse.addActionListener(e -> {

        JFileChooser chooser =
            new JFileChooser();

        int result =
            chooser.showOpenDialog(this);

        if(result ==
            JFileChooser.APPROVE_OPTION){

        txtSubmissionFile.setText(

                chooser.getSelectedFile()
                       .getAbsolutePath()
        );
    }
    });
    }

    private void submitAssessment() {

    SubmissionController controller =
            new SubmissionController();

    boolean success =
            controller.submitAssessment(

                    txtAssessmentId.getText(),
                    studentId,
                    txtSubmission.getText(),
                    txtSubmissionFile.getText()
            );

    if(success){

        JOptionPane.showMessageDialog(
                this,
                "Assessment Submitted Successfully");

        clearForm();

    }else{

        JOptionPane.showMessageDialog(
                this,
                "Submission Failed");
    }
}

    private void clearForm() {

    txtAssessmentId.setText("");
    txtSubmission.setText("");
    txtSubmissionFile.setText("");
    }
}