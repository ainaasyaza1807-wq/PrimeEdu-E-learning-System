/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package boundary;

import entity.Question;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TakeQuizFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TakeQuizFrame.class.getName());

    private ArrayList<Question> activeQuestionsList;
    private int currentQuestionIndex = 0;
    private int timeRemainingSeconds;
    private Timer countdownTimer;
    private int score = 0;
    
    public TakeQuizFrame(int timeLimitMinutes, ArrayList<Question> questions) {
        initComponents();
        
        this.activeQuestionsList = questions;
        this.timeRemainingSeconds = timeLimitMinutes * 60;
        
        startTimer();
        updateQuestionUI();
    }
    
    public TakeQuizFrame() {
        initComponents();
    }
    
    private void updateQuestionUI() {
        if (activeQuestionsList == null || activeQuestionsList.isEmpty()) {
            txtQuestionDisplay.setText("No questions available in this quiz buffer.");
            return;
        }

        int totalCount = activeQuestionsList.size();
        
        // Kemaskini tracker soalan (Contoh: Question 1 of 2)
        lblQuestionTracker.setText("Question " + (currentQuestionIndex + 1) + " of " + totalCount);
        
        // Kosongkan pilihan radio button untuk soalan baharu
        buttonGroup1.clearSelection();

        // Ambil data soalan berdasarkan indeks semasa
        Question currentQuestion = activeQuestionsList.get(currentQuestionIndex);

        // Paparkan soalan dan pilihan jawapan pada GUI
        txtQuestionDisplay.setText(currentQuestion.getQuestionPrompt());
        rbOptA.setText(currentQuestion.getOptionA());
        rbOptB.setText(currentQuestion.getOptionB());
        rbOptC.setText(currentQuestion.getOptionC());
        rbOptD.setText(currentQuestion.getOptionD());

        // 🎯 LOGIK PENUKARAN TEKS BUTANG YANG BETUL
        if (currentQuestionIndex == totalCount - 1) {
            btnNextQuestion.setText("Submit Quiz");
        } else {
            btnNextQuestion.setText("Next Question");
        }
    }
    
    private void startTimer() {
    countdownTimer = new Timer(1000, new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (timeRemainingSeconds > 0) {
                timeRemainingSeconds--;
                int mins = timeRemainingSeconds / 60;
                int secs = timeRemainingSeconds % 60;
              
                lblTimer.setText(String.format("Time Remaining: %02d:%02d", mins, secs));
            } else {
                countdownTimer.stop();
                JOptionPane.showMessageDialog(TakeQuizFrame.this, 
                    "Time is up! Your quiz has been submitted automatically.", 
                    "Timeout", JOptionPane.WARNING_MESSAGE);
                submitQuizResults();
            }
        }
     });
        countdownTimer.start();
    }
    
    private void submitQuizResults() {
       if (countdownTimer != null && countdownTimer.isRunning()) {
            countdownTimer.stop();
        }

        int totalQuestions = (activeQuestionsList != null) ? activeQuestionsList.size() : 1;
        int finalPercentage = (int) (((double) score / totalQuestions) * 100);

        // ⚠️ PASTIKAN PORT (3306 atau 3307) mengikut ketetapan XAMPP PC kau yang berjaya sebelum ini!
        String url = "jdbc:mysql://localhost:3306/primeedu_db"; 
        String user = "root";
        String password = "";

        String sql = "INSERT INTO quiz_results (student_id, quiz_title, score, total_questions, percentage) VALUES (?, ?, ?, ?, ?)";

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(url, user, password);
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "STU-99"); 
            pstmt.setString(2, "OOP Quiz buffered"); 
            pstmt.setInt(3, score);
            pstmt.setInt(4, totalQuestions);
            pstmt.setInt(5, finalPercentage);

            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(this, 
                    "Quiz submitted successfully!\nYour Score: " + score + "/" + totalQuestions + " (" + finalPercentage + "%)", 
                    "Quiz Results", JOptionPane.INFORMATION_MESSAGE);
            
            this.dispose(); // Hanya tutup frame JIKA proses SQL berjaya!

        } catch (java.sql.SQLException e) {
            // Jika gagal (contoh: table tak wujud), ia akan keluar ralat dan frame TIDAK akan tertutup melulu
            JOptionPane.showMessageDialog(this, "Database Save Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblQuestionTracker = new javax.swing.JLabel();
        lblTimer = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestionDisplay = new javax.swing.JTextArea();
        rbOptA = new javax.swing.JRadioButton();
        rbOptB = new javax.swing.JRadioButton();
        rbOptC = new javax.swing.JRadioButton();
        rbOptD = new javax.swing.JRadioButton();
        btnNextQuestion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblQuestionTracker.setText("Question 1 of 5");

        lblTimer.setText("Time Remaining: 25:29");

        txtQuestionDisplay.setEditable(false);
        txtQuestionDisplay.setColumns(20);
        txtQuestionDisplay.setRows(5);
        jScrollPane1.setViewportView(txtQuestionDisplay);

        buttonGroup1.add(rbOptA);
        rbOptA.setText("jRadioButton1");

        buttonGroup1.add(rbOptB);
        rbOptB.setText("jRadioButton1");

        buttonGroup1.add(rbOptC);
        rbOptC.setText("jRadioButton1");

        buttonGroup1.add(rbOptD);
        rbOptD.setText("jRadioButton1");

        btnNextQuestion.setText("NEXT");
        btnNextQuestion.addActionListener(this::btnNextQuestionActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTimer))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblQuestionTracker)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbOptD)
                    .addComponent(rbOptC)
                    .addComponent(rbOptB)
                    .addComponent(rbOptA))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNextQuestion)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQuestionTracker)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rbOptA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbOptB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbOptC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbOptD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnNextQuestion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTimer)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextQuestionActionPerformed
      
    if (activeQuestionsList == null || activeQuestionsList.isEmpty()) {
            return;
        }

        // 1. Ambil data soalan SEMASA sebelum indeks dinaikkan
        Question currentQuestion = activeQuestionsList.get(currentQuestionIndex);
        String selectedAnswer = "";

        if (rbOptA.isSelected()) selectedAnswer = "A";
        else if (rbOptB.isSelected()) selectedAnswer = "B";
        else if (rbOptC.isSelected()) selectedAnswer = "C";
        else if (rbOptD.isSelected()) selectedAnswer = "D";

        // 2. Validasi: Paksa pelajar pilih jawapan
        if (selectedAnswer.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                    "Please select an answer before proceeding!", 
                    "Selection Required", 
                    JOptionPane.WARNING_MESSAGE);
            return; 
        }

        // 3. Semak jawapan betul & tambah markah
        if (selectedAnswer.equalsIgnoreCase(currentQuestion.getCorrectAnswer())) {
            score++; 
        }

        // 4. LOGIK NAVIGASI: Pergi ke soalan seterusnya ATAU hantar kuiz
        int totalQuestions = activeQuestionsList.size();
        
        if (currentQuestionIndex < totalQuestions - 1) {
            // Jika ada soalan lagi (contoh: baru soalan 1 daripada 2), naikkan indeks dan refresh UI
            currentQuestionIndex++;
            updateQuestionUI(); 
        } else {
            // Jika dah sampai soalan terakhir (soalan 2 daripada 2), baru panggil fungsi hantar database
            submitQuizResults();
        }
    }//GEN-LAST:event_btnNextQuestionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(TakeQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new TakeQuizFrame(30, new ArrayList<>()).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNextQuestion;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblQuestionTracker;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JRadioButton rbOptA;
    private javax.swing.JRadioButton rbOptB;
    private javax.swing.JRadioButton rbOptC;
    private javax.swing.JRadioButton rbOptD;
    private javax.swing.JTextArea txtQuestionDisplay;
    // End of variables declaration//GEN-END:variables
}
