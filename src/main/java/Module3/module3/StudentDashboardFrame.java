package module3;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * UC1 – Browse Available Courses
 * UC2 – Enrol in a Course
 * UC3 – Drop a Course
 * UC4 – View Enrolment History
 * UC5 – Track Course Progress (launches ProgressTrackerFrame)
 *
 * Main Student Dashboard with two tabs:
 *   Tab 1: Course Catalogue  (UC1, UC2)
 *   Tab 2: My Enrolment History (UC3, UC4, UC5)
 *
 * @author Thaneshraj CA25056
 */
public final class StudentDashboardFrame extends javax.swing.JFrame {

    // Logged-in student details (hardcoded for Module 3 demo)
    private static final String STUDENT_ID   = "STU-CA25056";
    private static final String STUDENT_NAME = "Thaneshraj";

    // =============================================
    // CONSTRUCTOR
    // =============================================
public StudentDashboardFrame() {
    initComponents();
    setLocationRelativeTo(null);
    setTitle("E-Learning System — Student Dashboard");

    primeedu_db.initializeDatabase(); // ✨ Automatically creates your missing tables!
    primeedu_db.loadFromFile();       // Restore previous session data
    
    refreshCatalogueTable();
    refreshHistoryTable();
}

    // =============================================
    // UC1 — Refresh Course Catalogue Table
    // =============================================
    public void refreshCatalogueTable() {
        String keyword = txtSearch.getText().trim().toLowerCase();
        String[] columns = {"Course ID", "Title", "Instructor", "Duration", "Status"};

        List<Course> source = primeedu_db.globalCourses;
        List<Object[]> rows = new ArrayList<>();

        for (Course c : source) {
            if (!c.getStatus().equals("Active")) continue; // Only published courses
            if (!keyword.isEmpty() &&
                !c.getTitle().toLowerCase().contains(keyword) &&
                !c.getInstructor().toLowerCase().contains(keyword)) continue;

            rows.add(new Object[]{
                c.getCourseId(), c.getTitle(), c.getInstructor(),
                c.getDuration(), c.getStatus()
            });
        }

        if (rows.isEmpty()) {
            lblCatalogueStatus.setText("No courses found.");
        } else {
            lblCatalogueStatus.setText(rows.size() + " course(s) available.");
        }

        Object[][] data = rows.toArray(Object[][]::new);
        tblCatalogue.setModel(new DefaultTableModel(data, columns) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        });
    }

    // =============================================
    // UC4 — Refresh Enrolment History Table
    // =============================================
    public void refreshHistoryTable() {
        String[] columns = {"Course Title", "Instructor", "Enrol Date", "Status", "Progress"};
        List<Enrolment> list = primeedu_db.getEnrolmentsByStudent(STUDENT_ID);

        // Filter by status combo
        String filter = (String) cmbStatusFilter.getSelectedItem();
        List<Object[]> rows = new ArrayList<>();

        for (Enrolment e : list) {
            if (!filter.equals("All") && !e.getStatus().equals(filter)) continue;
            rows.add(new Object[]{
                e.getCourse().getTitle(),
                e.getCourse().getInstructor(),
                e.getEnrolDate().toString(),
                e.getStatus(),
                e.calculateProgressPercentage() + "%"
            });
        }

        if (rows.isEmpty()) {
            lblHistoryStatus.setText("No enrolment records found.");
        } else {
            lblHistoryStatus.setText(rows.size() + " record(s) found.");
        }

        Object[][] data = rows.toArray(Object[][]::new);
        tblHistory.setModel(new DefaultTableModel(data, columns) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        });
    }

    // =============================================
    // GENERATED UI CODE (initComponents)
    // =============================================
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTabbedPane1      = new JTabbedPane();

        // --- Tab 1 components ---
        pnlCatalogue      = new JPanel();
        lblSearch         = new JLabel("Search:");
        txtSearch         = new JTextField();
        btnSearch         = new JButton("Search");
        lblCatalogueStatus= new JLabel("Loading...");
        jScrollPane1      = new JScrollPane();
        tblCatalogue      = new JTable();
        btnEnrol          = new JButton("Enrol in Course");

        // --- Tab 2 components ---
        pnlHistory        = new JPanel();
        lblFilter         = new JLabel("Filter by Status:");
        cmbStatusFilter   = new JComboBox<>(new String[]{"All","Active","Completed","Dropped"});
        btnFilter         = new JButton("Apply Filter");
        lblHistoryStatus  = new JLabel("Loading...");
        jScrollPane2      = new JScrollPane();
        tblHistory        = new JTable();
        btnDrop           = new JButton("Drop Selected Course");
        btnTrack          = new JButton("Track Progress");
        btnInstructor     = new JButton("Switch to Instructor View");

        // --- Window settings ---
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ---- Tab 1: Course Catalogue layout ----
       // ---- Tab 1: Course Catalogue layout ----
        btnSearch.addActionListener(e -> refreshCatalogueTable());
        txtSearch.addActionListener(e -> refreshCatalogueTable());
        btnEnrol.addActionListener(e -> btnEnrolActionPerformed()); // Corrected here!

        lblSearch.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblCatalogueStatus.setForeground(new java.awt.Color(100, 100, 100));

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(pnlCatalogue);
        pnlCatalogue.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addComponent(lblSearch)
                        .addGap(8,8,8)
                        .addComponent(txtSearch, 200, 200, 200)
                        .addGap(8,8,8)
                        .addComponent(btnSearch))
                    .addComponent(lblCatalogueStatus)
                    .addComponent(btnEnrol))
                .addContainerGap())
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(6,6,6)
                .addComponent(lblCatalogueStatus)
                .addGap(6,6,6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8,8,8)
                .addComponent(btnEnrol)
                .addContainerGap())
        );
        jScrollPane1.setViewportView(tblCatalogue);

        // ---- Tab 2: Enrolment History layout ----
        // ---- Tab 2: Enrolment History layout ----
        cmbStatusFilter.addActionListener(e -> refreshHistoryTable());
        btnFilter.addActionListener(e -> refreshHistoryTable());
        btnDrop.addActionListener(e -> btnDropActionPerformed());   // Corrected here!
        btnTrack.addActionListener(e -> btnTrackActionPerformed()); // Corrected here!
        btnInstructor.addActionListener((ActionEvent e) -> {
            new InstructorDashboardFrame().setVisible(true);
            StudentDashboardFrame.this.dispose();
        });

        lblFilter.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblHistoryStatus.setForeground(new java.awt.Color(100, 100, 100));

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(pnlHistory);
        pnlHistory.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(tab2Layout.createSequentialGroup()
                        .addComponent(lblFilter)
                        .addGap(8,8,8)
                        .addComponent(cmbStatusFilter, 120,120,120)
                        .addGap(8,8,8)
                        .addComponent(btnFilter))
                    .addComponent(lblHistoryStatus)
                    .addGroup(tab2Layout.createSequentialGroup()
                        .addComponent(btnDrop)
                        .addGap(8,8,8)
                        .addComponent(btnTrack)
                        .addGap(20,20,20)
                        .addComponent(btnInstructor)))
                .addContainerGap())
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFilter)
                    .addComponent(cmbStatusFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFilter))
                .addGap(6,6,6)
                .addComponent(lblHistoryStatus)
                .addGap(6,6,6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8,8,8)
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDrop)
                    .addComponent(btnTrack)
                    .addComponent(btnInstructor))
                .addContainerGap())
        );
        jScrollPane2.setViewportView(tblHistory);

        jTabbedPane1.addTab("📚 Course Catalogue", pnlCatalogue);
        jTabbedPane1.addTab("📋 My Enrolment History", pnlHistory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup().addComponent(jTabbedPane1));
        layout.setVerticalGroup(layout.createParallelGroup().addComponent(jTabbedPane1));

        pack();
    }

    // =============================================
    // UC2 — Enrol Button Handler
    // =============================================
    private void btnEnrolActionPerformed() {
        int selectedRow = tblCatalogue.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                "Please select a course from the catalogue first!",
                "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Get selected course from global list (filtered display may differ, so match by ID)
        String selectedId = (String) tblCatalogue.getValueAt(selectedRow, 0);
        Course selectedCourse = null;
        for (Course c : primeedu_db.globalCourses) {
            if (c.getCourseId().equals(selectedId)) { selectedCourse = c; break; }
        }
        if (selectedCourse == null) return;

        boolean success = primeedu_db.enrolStudent(STUDENT_ID, STUDENT_NAME, selectedCourse);

        if (success) {
            JOptionPane.showMessageDialog(this,
                "Successfully enrolled in:\n" + selectedCourse.getTitle(),
                "Enrolment Successful", JOptionPane.INFORMATION_MESSAGE);
            refreshHistoryTable();
            jTabbedPane1.setSelectedIndex(1); // Switch to history tab
        } else {
            JOptionPane.showMessageDialog(this,
                "You are already actively enrolled in:\n" + selectedCourse.getTitle(),
                "Enrolment Denied", JOptionPane.ERROR_MESSAGE);
        }
    }

    // =============================================
    // UC3 — Drop Button Handler
    // =============================================
    private void btnDropActionPerformed() {
        int selectedRow = tblHistory.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                "Please select a course from your Enrolment History to drop.",
                "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<Enrolment> myEnrolments = primeedu_db.getEnrolmentsByStudent(STUDENT_ID);
        // Match by filtering the same way as the table
        String filter = (String) cmbStatusFilter.getSelectedItem();
        List<Enrolment> filtered = new ArrayList<>();
        for (Enrolment e : myEnrolments) {
            if (filter.equals("All") || e.getStatus().equals(filter)) filtered.add(e);
        }

        Enrolment target = filtered.get(selectedRow);

        if (target.getStatus().equals("Dropped")) {
            JOptionPane.showMessageDialog(this,
                "This course has already been dropped.",
                "Already Dropped", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to withdraw from:\n" + target.getCourse().getTitle() + "?",
            "Confirm Drop", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            primeedu_db.dropEnrolment(target);
            JOptionPane.showMessageDialog(this,
                "Successfully dropped: " + target.getCourse().getTitle(),
                "Course Dropped", JOptionPane.INFORMATION_MESSAGE);
            refreshHistoryTable();
        }
    }

    // =============================================
    // UC5 — Track Progress Button Handler
    // =============================================
    private void btnTrackActionPerformed() {
        int selectedRow = tblHistory.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                "Please select an active course from your Enrolment History first!",
                "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<Enrolment> myEnrolments = primeedu_db.getEnrolmentsByStudent(STUDENT_ID);
        String filter = (String) cmbStatusFilter.getSelectedItem();
        List<Enrolment> filtered = new ArrayList<>();
        for (Enrolment e : myEnrolments) {
            if (filter.equals("All") || e.getStatus().equals(filter)) filtered.add(e);
        }

        Enrolment selected = filtered.get(selectedRow);

        if (selected.getStatus().equals("Dropped")) {
            JOptionPane.showMessageDialog(this,
                "Cannot track progress for a dropped course.",
                "Unavailable", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ProgressTrackerFrame tracker = new ProgressTrackerFrame(selected);
        tracker.setVisible(true);
        tracker.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                refreshHistoryTable(); // Refresh after tracker closes
            }
        });
    }

    // =============================================
    // MAIN — Entry Point
    // =============================================
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentDashboardFrame.class.getName())
                .log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new StudentDashboardFrame().setVisible(true));
    }

    // =============================================
    // VARIABLE DECLARATIONS
    // =============================================
    private JTabbedPane  jTabbedPane1;
    private JPanel       pnlCatalogue;
    private JLabel       lblSearch;
    private JTextField   txtSearch;
    private JButton      btnSearch;
    private JLabel       lblCatalogueStatus;
    private JScrollPane  jScrollPane1;
    private JTable       tblCatalogue;
    private JButton      btnEnrol;
    private JPanel       pnlHistory;
    private JLabel       lblFilter;
    private JComboBox<String> cmbStatusFilter;
    private JButton      btnFilter;
    private JLabel       lblHistoryStatus;
    private JScrollPane  jScrollPane2;
    private JTable       tblHistory;
    private JButton      btnDrop;
    private JButton      btnTrack;
    private JButton      btnInstructor;
}
