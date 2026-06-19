package module_1;

import controller.SubjectController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewRecordsUI extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    private JButton btnRefresh;
    private JButton btnClose;

    public ViewRecordsUI() {

        setTitle("View Records");

        setSize(1000,600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        initializeUI();

        loadRecords();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel =
                new JPanel(null);

        JLabel lblTitle =
                new JLabel(
                        "Learning Records");

        lblTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24));

        lblTitle.setBounds(
                380,
                30,
                250,
                30);

        panel.add(lblTitle);

        model =
                new DefaultTableModel();

        model.addColumn("Standard");
        model.addColumn("Subject Code");
        model.addColumn("Subject Name");
        model.addColumn("Instructor");
        model.addColumn("Material");

        table =
                new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(table);

        scrollPane.setBounds(
                50,
                100,
                850,
                320);

        panel.add(scrollPane);

        btnRefresh =
                new JButton(
                        "Refresh");

        btnRefresh.setBounds(
                300,
                470,
                120,
                35);

        panel.add(btnRefresh);

        btnClose =
                new JButton(
                        "Close");

        btnClose.setBounds(
                500,
                470,
                120,
                35);

        panel.add(btnClose);

        add(panel);

        btnRefresh.addActionListener(
                e -> loadRecords());

        btnClose.addActionListener(
                e -> dispose());
    }

    private void loadRecords() {

        model.setRowCount(0);

        SubjectController controller =
                new SubjectController();

        for(Object[] row :
                controller.getRecords()) {

            model.addRow(row);
        }
    }
}
