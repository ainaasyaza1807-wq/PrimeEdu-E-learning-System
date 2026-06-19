package module_4;

import controller.SubmissionController;
import Entity.Submission;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ViewAssessmentFeedbackFrame extends JFrame {

    private JTable tblFeedback;
    private DefaultTableModel model;

    private JButton btnRefresh;
    private JButton btnBack;

    // TEMP STUDENT
    private final int studentId = 1;

    public ViewAssessmentFeedbackFrame() {

        setTitle("Assessment Feedback");

        setSize(900,500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);

        initializeUI();

        loadFeedback();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel =
                new JPanel(null);

        JLabel lblTitle =
                new JLabel(
                        "ASSESSMENT FEEDBACK");

        lblTitle.setBounds(
                330,
                20,
                250,
                30);

        panel.add(lblTitle);

        model =
                new DefaultTableModel();

        model.addColumn("Submission ID");
        model.addColumn("Assessment ID");
        model.addColumn("Marks");
        model.addColumn("Feedback");
        model.addColumn("Status");

        tblFeedback =
                new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(tblFeedback);

        scrollPane.setBounds(
                30,
                80,
                820,
                260);

        panel.add(scrollPane);

        btnRefresh =
                new JButton("Refresh");

        btnBack =
                new JButton("Back");

        btnRefresh.setBounds(
                250,
                370,
                120,
                35);

        btnBack.setBounds(
                450,
                370,
                120,
                35);

        panel.add(btnRefresh);
        panel.add(btnBack);

        add(panel);

        btnRefresh.addActionListener(
                e -> loadFeedback());

        btnBack.addActionListener(
                e -> dispose());
    }

    private void loadFeedback() {

        model.setRowCount(0);

        SubmissionController controller =
                new SubmissionController();

        ArrayList<Submission> list =
                controller.getStudentSubmissions(
                        studentId);

        for(Submission submission : list) {

            model.addRow(new Object[]{

                    submission.getSubmissionId(),
                    submission.getAssessmentId(),
                    submission.getMarks(),
                    submission.getFeedback(),
                    submission.getStatus()
            });
        }
    }
}