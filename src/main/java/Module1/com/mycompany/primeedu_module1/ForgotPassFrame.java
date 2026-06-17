/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Module1.com.mycompany.primeedu_module1;

import java.util.ArrayList;
import Module1.Controller.ForgotPasswordController;

public class ForgotPassFrame extends javax.swing.JFrame {
// Jalur kawalan sistem OTP dan Timer
    private long codeSentTime; 
    private String generatedOTP = "";
    private javax.swing.Timer countdownTimer;
    private int timeLeft = 60;
    private boolean isCodeVerified = false; //Kunci keselamatan utama
    private ForgotPasswordController forgotController = new ForgotPasswordController();
    
    public ForgotPassFrame() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        EmailText = new javax.swing.JLabel();
        txtResetEmail = new javax.swing.JTextField();
        btnSendCode = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtVerificationCode = new javax.swing.JTextField();
        btnVerifyCode = new javax.swing.JButton();
        btnResendCode = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        btnUpdatePassword = new javax.swing.JButton();
        lblResetStatusMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(733, 318));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Reset Password");

        EmailText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        EmailText.setText("Email : ");

        btnSendCode.setText("Send");
        btnSendCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendCodeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Verification Code : ");

        btnVerifyCode.setText("Submit code");
        btnVerifyCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifyCodeActionPerformed(evt);
            }
        });

        btnResendCode.setText("Resend Code");
        btnResendCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResendCodeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("New Password : ");

        btnUpdatePassword.setText("Update");
        btnUpdatePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblResetStatusMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNewPassword))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtVerificationCode))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(EmailText)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtResetEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnVerifyCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSendCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnResendCode, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(btnUpdatePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSendCode)
                        .addGap(1, 1, 1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EmailText)
                        .addComponent(txtResetEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtVerificationCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerifyCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnResendCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdatePassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResetStatusMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendCodeActionPerformed
     String email = txtResetEmail.getText().trim().toLowerCase();
        
        // Reset warna kotak asal (Putih)
        txtResetEmail.setBackground(java.awt.Color.WHITE);
        
        if (email.isEmpty()) {
            lblResetStatusMessage.setText("Error: Email field cannot be empty!");
            lblResetStatusMessage.setForeground(java.awt.Color.RED);
            txtResetEmail.setBackground(new java.awt.Color(255, 204, 204)); // Tukar kotak jadi pink
            return;
        }
        
        //Validasi format e-mel guna fungsi dari LoginFrame
        if (!LoginFrame.isValidEmail(email)) {
            lblResetStatusMessage.setText("Error: Invalid email format! (e.g., name@email.com)");
            lblResetStatusMessage.setForeground(java.awt.Color.RED);
            txtResetEmail.setBackground(new java.awt.Color(255, 204, 204)); // Tukar kotak jadi pink
            return; // SEKAT PENGENAAN OTP SERTA-MERTA
        }
        
       if (!forgotController.emailExists(email)) {
    lblResetStatusMessage.setText("Error: Email Not Registered.");
    lblResetStatusMessage.setForeground(java.awt.Color.RED);
    txtResetEmail.setBackground(new java.awt.Color(255, 204, 204));
    return;
}
       
    //Jana 6 angka rawak (Random OTP)
    java.util.Random rand = new java.util.Random();
    // Menghasilkan nombor antara 100000 hingga 999999
    int number = 100000 + rand.nextInt(900000); 
    generatedOTP = String.valueOf(number); // Simpan nombor rawak ke variable utama
    
    codeSentTime = System.currentTimeMillis(); 
    isCodeVerified = false; 
    
    // Paparkan kod rawak yang baru dijana tadi dekat popup simulasi e-mel
    javax.swing.JOptionPane.showMessageDialog(this, 
            "A verification code has been sent to your email!\nYour Verification Code is: " + generatedOTP,
            "Verification Code Sent",
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
    
    startCountdown();
    //Supaya user tak boleh tukar teks e-mel selepas OTP dihantar!
    txtResetEmail.setEnabled(false);
    }//GEN-LAST:event_btnSendCodeActionPerformed

    private void btnVerifyCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifyCodeActionPerformed
     String enteredCode = txtVerificationCode.getText().trim();
        long currentTime = System.currentTimeMillis();
        txtVerificationCode.setBackground(java.awt.Color.WHITE);
        
        // Semak tarikh luput (60 saat)
        if ((currentTime - codeSentTime) > 60000) {
            lblResetStatusMessage.setText("Error: Verification code expired. Please click Resend Code.");
            lblResetStatusMessage.setForeground(java.awt.Color.RED);
            isCodeVerified = false;
            btnResendCode.setEnabled(true);
            return;
        }
        
        // Semak kod betul atau salah
        if (!enteredCode.equals(generatedOTP)) {
            lblResetStatusMessage.setText("Error: Invalid verification code.");
            lblResetStatusMessage.setForeground(java.awt.Color.RED);
            txtVerificationCode.setBackground(new java.awt.Color(255, 204, 204));
            isCodeVerified = false;
            return;  
        }
        
        // Lepas pengesahan
        if (countdownTimer != null) countdownTimer.stop(); // Berhentikan timer sebab dah settle
        isCodeVerified = true; // 🌟 PINTU UTAMA DIBUKA
        lblResetStatusMessage.setText("Code verified successfully! You may now enter a new password.");
        lblResetStatusMessage.setForeground(new java.awt.Color(0, 153, 51));
    
    }//GEN-LAST:event_btnVerifyCodeActionPerformed

    private void btnUpdatePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePasswordActionPerformed

if (!isCodeVerified) {
    lblResetStatusMessage.setText(
            "Error: You must submit and verify the correct code first!");
    lblResetStatusMessage.setForeground(java.awt.Color.RED);
    return;
}

String email = txtResetEmail.getText().trim().toLowerCase();
String newPass = new String(txtNewPassword.getPassword()).trim();

txtNewPassword.setBackground(java.awt.Color.WHITE);

if (newPass.length() < 8) {
    lblResetStatusMessage.setText(
            "Error: New password must be at least 8 characters.");
    lblResetStatusMessage.setForeground(java.awt.Color.RED);
    txtNewPassword.setBackground(
            new java.awt.Color(255, 204, 204));
    return;
}

ForgotPasswordController forgotController =
        new ForgotPasswordController();

if (forgotController.updatePassword(email, newPass)) {

    if (countdownTimer != null) {
        countdownTimer.stop();
    }

    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Password updated successfully!"
    );

    new LoginFrame().setVisible(true);
    this.dispose();

} else {

    lblResetStatusMessage.setText(
            "Error: Failed to update password."
    );

    lblResetStatusMessage.setForeground(
            java.awt.Color.RED
    );
}
    }//GEN-LAST:event_btnUpdatePasswordActionPerformed

    private void btnResendCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResendCodeActionPerformed
       // 🌟 Jana nombor rawak baharu masa user klik resend
    java.util.Random rand = new java.util.Random();
    int number = 100000 + rand.nextInt(900000); 
    generatedOTP = String.valueOf(number);
    
    codeSentTime = System.currentTimeMillis(); 
    isCodeVerified = false;
    txtVerificationCode.setText("");
    
    javax.swing.JOptionPane.showMessageDialog(this, 
            "A NEW verification code has been generated!\nYour New Verification Code is: " + generatedOTP,
            "Resend Verification Code",
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
    
    startCountdown();
    }//GEN-LAST:event_btnResendCodeActionPerformed

    private void startCountdown() {
    timeLeft = 60; // Reset ke 60 saat
    btnResendCode.setEnabled(false); // Matikan butang resend sepanjang countdown
    
    if (countdownTimer != null && countdownTimer.isRunning()) {
        countdownTimer.stop();
    }

    countdownTimer = new javax.swing.Timer(1000, new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            timeLeft--;
            if (timeLeft > 0) {
                lblResetStatusMessage.setText("Verification code sent. Resend available in: " + timeLeft + "s");
                lblResetStatusMessage.setForeground(new java.awt.Color(0, 153, 51));
            } else {
                countdownTimer.stop();
                lblResetStatusMessage.setText("Code expired? You can click Resend Code now.");
                lblResetStatusMessage.setForeground(java.awt.Color.ORANGE);
                btnResendCode.setEnabled(true); // Hidupkan semula butang
            }
        }
    });
    countdownTimer.start();
    }
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ForgotPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EmailText;
    private javax.swing.JButton btnResendCode;
    private javax.swing.JButton btnSendCode;
    private javax.swing.JButton btnUpdatePassword;
    private javax.swing.JButton btnVerifyCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblResetStatusMessage;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JTextField txtResetEmail;
    private javax.swing.JTextField txtVerificationCode;
    // End of variables declaration//GEN-END:variables
}
