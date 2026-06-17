package module3;

import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * UC8 – Monitor Student Progress (Instructor View)
 *
 * Instructor can:
 * - View all students enrolled in their courses
 * - See each student's progress percentage
 * - Filter by progress range (e.g. 0–50%, 51–99%, 100%)
 *
 * Demonstrates: Polymorphism (overriding), Inheritance from JFrame
 * @author Thaneshraj CA25056
 */
public final class InstructorDashboardFrame extends javax.swing.JFrame {

    // Hardcoded instructor for demo — in real system, passed via login
    private static final String INSTRUCTOR_NAME = "Dr. Nor Azura";

    // =============================================
    // CONSTRUCTOR
    // =============================================
    public InstructorDashboardFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("E-Learning System — Instructor Dashboard");
        lblInstructorName.setText("Instructor: " + INSTRUCTOR_NAME);
        refreshProgressTable();
    }

    // =============================================
    // UC8 — Refresh Student Progress Table
    // =============================================
    public void refreshProgressTable() {
        String[] columns = {"Student ID", "Student Name", "Course", "Enrol Date", "Status", "Progress"};
        List<Enrolment> all = primeedu_db.getEnrolmentsByInstructor(INSTRUCTOR_NAME);

        // Apply progress range filter
        String filter = (String) cmbProgressFilter.getSelectedItem();
        List<Object[]> rows = new ArrayList<>();

        for (Enrolment e : all) {
            int progress = e.calculateProgressPercentage();
            boolean include = switch (filter) {
                case "0% – 50%"    -> progress <= 50;
                case "51% – 99%"   -> progress > 50 && progress < 100;
                case "100% (Done)" -> progress == 100;
                default            -> true; // "All Students"
            };

            if (include) {
                rows.add(new Object[]{
                    e.getStudentId(),
                    e.getStudentName(),
                    e.getCourse().getTitle(),
                    e.getEnrolDate().toString(),
                    e.getStatus(),
                    progress + "%"
                });
            }
        }

        if (rows.isEmpty()) {
            lblStatus.setText("No students found for the selected filter.");
        } else {
            lblStatus.setText(rows.size() + " student record(s) found.");
        }

        Object[][] data = rows.toArray(Object[][]::new);
        tblStudentProgress.setModel(new DefaultTableModel(data, columns) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        });
    }

    // =============================================
    // GENERATED UI (initComponents)
    // =============================================
    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblTitle          = new JLabel("Instructor Dashboard — Student Progress Monitor");
        lblInstructorName = new JLabel("Instructor: ");
        lblFilterLabel    = new JLabel("Filter by Progress:");
        cmbProgressFilter = new JComboBox<>(new String[]{
            "All Students", "0% – 50%", "51% – 99%", "100% (Done)"
        });
        btnFilter         = new JButton("Apply Filter");
        lblStatus         = new JLabel("Loading...");
        jScrollPane1      = new JScrollPane();
        tblStudentProgress= new JTable();
        btnBackToStudent  = new JButton("Back to Student View");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Styling
        lblTitle.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
        lblInstructorName.setFont(new java.awt.Font("Segoe UI", java.awt.Font.ITALIC, 13));
        lblStatus.setForeground(new java.awt.Color(80, 80, 80));

        // Actions
        btnFilter.addActionListener(e -> refreshProgressTable());
        cmbProgressFilter.addActionListener(e -> refreshProgressTable());
        btnBackToStudent.addActionListener(e -> {
            new StudentDashboardFrame().setVisible(true);
            this.dispose();
        });

        jScrollPane1.setViewportView(tblStudentProgress);

        // Layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(lblInstructorName)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFilterLabel)
                        .addGap(8,8,8)
                        .addComponent(cmbProgressFilter, 160, 160, 160)
                        .addGap(8,8,8)
                        .addComponent(btnFilter))
                    .addComponent(lblStatus)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(btnBackToStudent))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(4,4,4)
                .addComponent(lblInstructorName)
                .addGap(12,12,12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFilterLabel)
                    .addComponent(cmbProgressFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFilter))
                .addGap(6,6,6)
                .addComponent(lblStatus)
                .addGap(6,6,6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10,10,10)
                .addComponent(btnBackToStudent)
                .addContainerGap())
        );

        pack();
    }

    // =============================================
    // VARIABLE DECLARATIONS
    // =============================================
    private JLabel              lblTitle;
    private JLabel              lblInstructorName;
    private JLabel              lblFilterLabel;
    private JComboBox<String>   cmbProgressFilter;
    private JButton             btnFilter;
    private JLabel              lblStatus;
    private JScrollPane         jScrollPane1;
    private JTable              tblStudentProgress;
    private JButton             btnBackToStudent;
}
