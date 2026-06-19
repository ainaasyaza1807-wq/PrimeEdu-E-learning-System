package module_3;

import controller.TopicController;
import controller.EnrolmentController;
import Entity.Topic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ProgressTrackingFrame extends JFrame {

    private JTable tblTopics;
    private DefaultTableModel model;

    private JButton btnComplete;
    private JButton btnRefresh;
    private JButton btnBack;

    // TEMP VALUES
    private final int courseId = 7;
    private final int enrolmentId = 1;

    public ProgressTrackingFrame() {

        setTitle("Progress Tracking");
        setSize(750,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initializeUI();

        loadTopics();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel = new JPanel(null);

        JLabel lblTitle =
                new JLabel("PROGRESS TRACKING");

        lblTitle.setBounds(
                280,
                20,
                250,
                30);

        panel.add(lblTitle);

        model =
                new DefaultTableModel();

        model.addColumn("Topic ID");
        model.addColumn("Topic Name");
        model.addColumn("Completed");

        tblTopics =
                new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(tblTopics);

        scrollPane.setBounds(
                40,
                70,
                650,
                250);

        panel.add(scrollPane);

        btnComplete =
                new JButton("Mark Complete");

        btnRefresh =
                new JButton("Refresh");

        btnBack =
                new JButton("Back");

        btnComplete.setBounds(
                120,
                360,
                150,
                35);

        btnRefresh.setBounds(
                300,
                360,
                120,
                35);

        btnBack.setBounds(
                450,
                360,
                120,
                35);

        panel.add(btnComplete);
        panel.add(btnRefresh);
        panel.add(btnBack);

        add(panel);

        btnComplete.addActionListener(
                e -> markCompleted());

        btnRefresh.addActionListener(
                e -> loadTopics());

        btnBack.addActionListener(
                e -> dispose());
    }

    private void loadTopics() {

        model.setRowCount(0);

        TopicController controller =
                new TopicController();

        ArrayList<Topic> topics =
                controller.getTopicsByCourse(
                        courseId);

        for(Topic topic : topics) {

            model.addRow(new Object[]{

                    topic.getTopicId(),
                    topic.getTopicName(),
                    topic.isCompleted()
            });
        }
    }

    private void markCompleted() {

        int row =
                tblTopics.getSelectedRow();

        if(row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select Topic First");

            return;
        }

        int topicId =
                Integer.parseInt(
                        model.getValueAt(
                                row,
                                0
                        ).toString());

        TopicController controller =
                new TopicController();

        boolean success =
                controller.markCompleted(
                        topicId);

        if(success) {

            updateProgress();

            JOptionPane.showMessageDialog(
                    this,
                    "Topic Completed");

            loadTopics();
        }
    }

    private void updateProgress() {

        TopicController controller =
                new TopicController();

        ArrayList<Topic> topics =
                controller.getTopicsByCourse(
                        courseId);

        int total =
                topics.size();

        int completed = 0;

        for(Topic topic : topics) {

            if(topic.isCompleted()) {

                completed++;
            }
        }

        int progress =
                (completed * 100) / total;

        EnrolmentController enrolmentController =
                new EnrolmentController();

        enrolmentController.updateProgress(
                enrolmentId,
                progress
        );
    }
}