package module_4;

import controller.AssessmentController;
import Entity.Assessment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class CreateAssessmentFrame extends JFrame {
    
    private JTextField txtAssessmentId;
    private JTextField txtTitle;
    private JTextField txtAssessmentFile;

    private JTextArea txtDescription;

    private JButton btnBrowse;

    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnSearch;
    private JButton btnRefresh;
    private JButton btnBack;

    private JTable tblAssessment;
    private DefaultTableModel model;

    // TEMP INSTRUCTOR ID
    private final int instructorId = 1;

    public CreateAssessmentFrame() {

        setTitle("Assessment Management");
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initializeUI();

        loadAssessments();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel = new JPanel(null);

        JLabel lblTitle =
                new JLabel("ASSESSMENT MANAGEMENT");

        lblTitle.setBounds(
                300,
                20,
                300,
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

        JLabel lblAssessmentTitle =
                new JLabel("Title:");

        lblAssessmentTitle.setBounds(
                50,
                120,
                120,
                25);

        panel.add(lblAssessmentTitle);

        txtTitle =
                new JTextField();

        txtTitle.setBounds(
                180,
                120,
                250,
                25);

        panel.add(txtTitle);

        JLabel lblDescription =
                new JLabel("Description:");

        lblDescription.setBounds(
                50,
                160,
                120,
                25);

        panel.add(lblDescription);

        txtDescription =
                new JTextArea();

        JScrollPane descScroll =
                new JScrollPane(txtDescription);

        descScroll.setBounds(
                180,
                160,
                250,
                80);

        panel.add(descScroll);
        
        JLabel lblFile =
        new JLabel("Assessment File:");

        lblFile.setBounds(
        50,
        250,
        120,
        25);

        panel.add(lblFile);

        txtAssessmentFile =
        new JTextField();

        txtAssessmentFile.setBounds(
        180,
        250,
        250,
        25);

        panel.add(txtAssessmentFile);

        btnBrowse =
        new JButton("Browse");

        btnBrowse.setBounds(
        440,
        250,
        100,
        25);

        panel.add(btnBrowse);
    
        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnSearch = new JButton("Search");
        btnRefresh = new JButton("Refresh");
        btnBack = new JButton("Back");

        btnAdd.setBounds(500,80,100,30);
        btnUpdate.setBounds(610,80,100,30);
        btnDelete.setBounds(720,80,100,30);

        btnSearch.setBounds(500,130,100,30);
        btnRefresh.setBounds(610,130,100,30);
        btnBack.setBounds(720,130,100,30);

        panel.add(btnAdd);
        panel.add(btnUpdate);
        panel.add(btnDelete);
        panel.add(btnSearch);
        panel.add(btnRefresh);
        panel.add(btnBack);

        model =
                new DefaultTableModel();

        model.addColumn("Assessment ID");
        model.addColumn("Title");
        model.addColumn("Description");
        model.addColumn("Instructor ID");
        model.addColumn("Assessment File");

        tblAssessment =
                new JTable(model);

        JScrollPane tableScroll =
                new JScrollPane(tblAssessment);

        tableScroll.setBounds(
            50,
            350,
            780,
            170);

        panel.add(tableScroll);

        add(panel);

        btnAdd.addActionListener(
                e -> addAssessment());

        btnUpdate.addActionListener(
                e -> updateAssessment());

        btnDelete.addActionListener(
                e -> deleteAssessment());

        btnSearch.addActionListener(
                e -> searchAssessment());

        btnRefresh.addActionListener(
                e -> loadAssessments());

        btnBack.addActionListener(
                e -> dispose());
        
        btnBrowse.addActionListener(e -> {

        JFileChooser chooser =
            new JFileChooser();

        int result =
            chooser.showOpenDialog(this);

        if(result ==
            JFileChooser.APPROVE_OPTION){

        txtAssessmentFile.setText(

                chooser.getSelectedFile()
                       .getAbsolutePath()
        );
    }
    });
    }

    private void addAssessment() {

    AssessmentController controller =
            new AssessmentController();

    boolean success =
            controller.addAssessment(

                    txtAssessmentId.getText(),
                    txtTitle.getText(),
                    txtDescription.getText(),
                    instructorId,
                    txtAssessmentFile.getText()
            );

    if(success){

        JOptionPane.showMessageDialog(
                this,
                "Assessment Added");

        loadAssessments();
    }
    }

    private void updateAssessment() {

        AssessmentController controller =
                new AssessmentController();

        boolean success =
                controller.updateAssessment(

                        txtAssessmentId.getText(),
                        txtTitle.getText(),
                        txtDescription.getText()
                );

        if(success) {

            JOptionPane.showMessageDialog(
                    this,
                    "Assessment Updated");

            loadAssessments();
        }
    }

    private void deleteAssessment() {

        AssessmentController controller =
                new AssessmentController();

        boolean success =
                controller.deleteAssessment(

                        txtAssessmentId.getText()
                );

        if(success) {

            JOptionPane.showMessageDialog(
                    this,
                    "Assessment Deleted");

            loadAssessments();
        }
    }

    private void searchAssessment() {

        AssessmentController controller =
                new AssessmentController();

        Assessment assessment =
                controller.searchAssessment(

                        txtAssessmentId.getText()
                );

        if(assessment != null) {

            txtTitle.setText(
                    assessment.getTitle());

            txtDescription.setText(
                    assessment.getDescription());

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Assessment Not Found");
        }
    }

    private void loadAssessments() {

        model.setRowCount(0);

        AssessmentController controller =
                new AssessmentController();

        ArrayList<Assessment> list =
                controller.getAllAssessments();

        for(Assessment assessment : list) {

            model.addRow(new Object[]{

            assessment.getAssessmentId(),
            assessment.getTitle(),
            assessment.getDescription(),
            assessment.getInstructorId(),
            assessment.getAssessmentFile()
            });
        }
    }
}