package module_4;

import controller.ResultController;
import Entity.Result;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ViewResultsFrame extends JFrame {

    private JTable tblResults;
    private DefaultTableModel model;

    private JButton btnRefresh;
    private JButton btnBack;

    // TEMP STUDENT
    private final int studentId = 1;

    public ViewResultsFrame() {

        setTitle("View Results");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initializeUI();

        loadResults();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel = new JPanel(null);

        JLabel lblTitle =
                new JLabel("MY RESULTS");

        lblTitle.setBounds(
                300,
                20,
                200,
                30);

        panel.add(lblTitle);

        model =
                new DefaultTableModel();

        model.addColumn("Result ID");
        model.addColumn("Quiz ID");
        model.addColumn("Student ID");
        model.addColumn("Score");

        tblResults =
                new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(tblResults);

        scrollPane.setBounds(
                40,
                70,
                600,
                280);

        panel.add(scrollPane);

        btnRefresh =
                new JButton("Refresh");

        btnBack =
                new JButton("Back");

        btnRefresh.setBounds(
                180,
                380,
                120,
                35);

        btnBack.setBounds(
                350,
                380,
                120,
                35);

        panel.add(btnRefresh);
        panel.add(btnBack);

        add(panel);

        btnRefresh.addActionListener(
                e -> loadResults());

        btnBack.addActionListener(
                e -> dispose());
    }

    private void loadResults() {

        model.setRowCount(0);

        ResultController controller =
                new ResultController();

        ArrayList<Result> list =
                controller.getStudentResults(
                        studentId);

        for(Result result : list) {

            model.addRow(new Object[]{

                    result.getResultId(),
                    result.getQuizId(),
                    result.getStudentId(),
                    result.getScore()
            });
        }
    }
}