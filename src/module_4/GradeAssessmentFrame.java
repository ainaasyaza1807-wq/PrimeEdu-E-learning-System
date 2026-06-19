package module_4;

import controller.SubmissionController;
import Entity.Submission;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class GradeAssessmentFrame extends JFrame {

    private JTextField txtSubmissionId;
    private JTextField txtMarks;

    private JTextArea txtFeedback;

    private JButton btnSearch;
    private JButton btnGrade;
    private JButton btnRefresh;
    private JButton btnBack;

    private JTable tblSubmissions;
    private DefaultTableModel model;

    public GradeAssessmentFrame() {

        setTitle("Grade Assessment");
        setSize(950,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initializeUI();

        loadSubmissions();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel = new JPanel(null);

        JLabel lblTitle =
                new JLabel("GRADE ASSESSMENT");

        lblTitle.setBounds(
                380,
                20,
                200,
                30);

        panel.add(lblTitle);

        JLabel lblSubmissionId =
                new JLabel("Submission ID:");

        lblSubmissionId.setBounds(
                50,
                80,
                120,
                25);

        panel.add(lblSubmissionId);

        txtSubmissionId =
                new JTextField();

        txtSubmissionId.setBounds(
                180,
                80,
                150,
                25);

        panel.add(txtSubmissionId);

        JLabel lblMarks =
                new JLabel("Marks:");

        lblMarks.setBounds(
                50,
                120,
                120,
                25);

        panel.add(lblMarks);

        txtMarks =
                new JTextField();

        txtMarks.setBounds(
                180,
                120,
                150,
                25);

        panel.add(txtMarks);

        JLabel lblFeedback =
                new JLabel("Feedback:");

        lblFeedback.setBounds(
                50,
                160,
                120,
                25);

        panel.add(lblFeedback);

        txtFeedback =
                new JTextArea();

        JScrollPane feedbackScroll =
                new JScrollPane(txtFeedback);

        feedbackScroll.setBounds(
                180,
                160,
                250,
                80);

        panel.add(feedbackScroll);

        btnSearch =
                new JButton("Search");

        btnGrade =
                new JButton("Save Grade");

        btnRefresh =
                new JButton("Refresh");

        btnBack =
                new JButton("Back");

        btnSearch.setBounds(
                520,
                80,
                120,
                30);

        btnGrade.setBounds(
                650,
                80,
                150,
                30);

        btnRefresh.setBounds(
                520,
                130,
                120,
                30);

        btnBack.setBounds(
                650,
                130,
                150,
                30);

        panel.add(btnSearch);
        panel.add(btnGrade);
        panel.add(btnRefresh);
        panel.add(btnBack);

        model =
                new DefaultTableModel();

        model.addColumn("Submission ID");
        model.addColumn("Assessment ID");
        model.addColumn("Student ID");
        model.addColumn("Marks");
        model.addColumn("Status");

        tblSubmissions =
                new JTable(model);

        JScrollPane tableScroll =
                new JScrollPane(tblSubmissions);

        tableScroll.setBounds(
                50,
                280,
                830,
                220);

        panel.add(tableScroll);

        add(panel);

        btnSearch.addActionListener(
                e -> searchSubmission());

        btnGrade.addActionListener(
                e -> gradeSubmission());

        btnRefresh.addActionListener(
                e -> loadSubmissions());

        btnBack.addActionListener(
                e -> dispose());
    }

    private void searchSubmission() {

        SubmissionController controller =
                new SubmissionController();

        Submission submission =
                controller.searchSubmission(

                        Integer.parseInt(
                                txtSubmissionId.getText())
                );

        if(submission != null){

            txtMarks.setText(
                    String.valueOf(
                            submission.getMarks()));

            txtFeedback.setText(
                    submission.getFeedback());

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Submission Not Found");
        }
    }

    private void gradeSubmission() {

        SubmissionController controller =
                new SubmissionController();

        boolean success =
                controller.gradeSubmission(

                        Integer.parseInt(
                                txtSubmissionId.getText()),

                        Integer.parseInt(
                                txtMarks.getText()),

                        txtFeedback.getText()
                );

        if(success){

            JOptionPane.showMessageDialog(
                    this,
                    "Assessment Graded");

            loadSubmissions();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Failed");
        }
    }

    private void loadSubmissions() {

        model.setRowCount(0);

        SubmissionController controller =
                new SubmissionController();

        ArrayList<Submission> list =
                controller.getAllSubmissions();

        for(Submission submission : list){

            model.addRow(new Object[]{

                    submission.getSubmissionId(),
                    submission.getAssessmentId(),
                    submission.getStudentId(),
                    submission.getMarks(),
                    submission.getStatus()
            });
        }
    }
}