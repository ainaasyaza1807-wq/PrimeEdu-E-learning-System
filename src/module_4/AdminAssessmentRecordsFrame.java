package module_4;

import controller.SubmissionController;
import Entity.Submission;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class AdminAssessmentRecordsFrame extends JFrame {

    private JTextField txtResultId;

    private JTable tblResults;
    private DefaultTableModel model;

    private JButton btnSearch;
    private JButton btnDelete;
    private JButton btnRefresh;
    private JButton btnBack;

    public AdminAssessmentRecordsFrame() {

        setTitle("Admin Assessment Records");

        setSize(900,600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);

        initializeUI();

        loadSubmissions();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel =
                new JPanel(null);

        JLabel lblTitle =
                new JLabel(
                        "ADMIN ASSESSMENT RECORDS");

        lblTitle.setBounds(
                300,
                20,
                300,
                30);

        panel.add(lblTitle);

        JLabel lblResultId =
                new JLabel("Result ID:");

        lblResultId.setBounds(
                50,
                80,
                100,
                25);

        panel.add(lblResultId);

        txtResultId =
                new JTextField();

        txtResultId.setBounds(
                150,
                80,
                180,
                25);

        panel.add(txtResultId);

        btnSearch =
                new JButton("Search");

        btnDelete =
                new JButton("Delete");

        btnRefresh =
                new JButton("Refresh");

        btnBack =
                new JButton("Back");

        btnSearch.setBounds(
                400,
                80,
                100,
                30);

        btnDelete.setBounds(
                510,
                80,
                100,
                30);

        btnRefresh.setBounds(
                620,
                80,
                100,
                30);

        btnBack.setBounds(
                730,
                80,
                100,
                30);

        panel.add(btnSearch);
        panel.add(btnDelete);
        panel.add(btnRefresh);
        panel.add(btnBack);

        model =
                new DefaultTableModel();

        model.addColumn("Submission ID");
        model.addColumn("Assessment ID");
        model.addColumn("Student ID");
        model.addColumn("Marks");
        model.addColumn("Feedback");
        model.addColumn("Status");

        tblResults =
                new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(
                        tblResults);

        scrollPane.setBounds(
                50,
                150,
                780,
                330);

        panel.add(scrollPane);

        add(panel);

        btnSearch.addActionListener(
        e -> searchSubmission());

        btnDelete.addActionListener(
        e -> deleteSubmission());

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
                            txtResultId.getText())
            );

    model.setRowCount(0);

    if(submission != null){

        model.addRow(new Object[]{

                submission.getSubmissionId(),
                submission.getAssessmentId(),
                submission.getStudentId(),
                submission.getMarks(),
                submission.getFeedback(),
                submission.getStatus()
        });

    } else {

        JOptionPane.showMessageDialog(
                this,
                "Submission Not Found");
    }
    }

    private void deleteSubmission() {

    SubmissionController controller =
            new SubmissionController();

    boolean success =
            controller.deleteSubmission(

                    Integer.parseInt(
                            txtResultId.getText())
            );

    if(success){

        JOptionPane.showMessageDialog(
                this,
                "Submission Deleted");

        loadSubmissions();

    } else {

        JOptionPane.showMessageDialog(
                this,
                "Delete Failed");
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
                submission.getFeedback(),
                submission.getStatus()
        });
    }
    }
}