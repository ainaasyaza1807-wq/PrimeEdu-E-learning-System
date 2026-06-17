/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Module1.com.mycompany.primeedu_module1;

import java.util.ArrayList;
import Module1.Controller.LoginController;

public class LoginFrame extends javax.swing.JFrame {
// Declare static parallel lists so data persists across frames
    public static ArrayList<String> registeredEmails = new ArrayList<>();
    public static ArrayList<String> registeredPasswords = new ArrayList<>();
    public static ArrayList<String> registeredRoles = new ArrayList<>();
    private LoginController loginController = new LoginController();
    
    // C1 Constraint Tracker: Count failed login attempts
    private int loginAttempts = 0;

    public LoginFrame() {
        initComponents();
   
        // Pre-load default mockup profiles if the system is blank
        if (registeredEmails.isEmpty()) {
        // Profile 1: Parent
        registeredEmails.add("parent@email.com");
        registeredPasswords.add("parent123");
        registeredRoles.add("Parent"); // Index 0 is a Parent
        
        // Profile 2: Student
        registeredEmails.add("student@email.com");
        registeredPasswords.add("student123");
        registeredRoles.add("Student"); // Index 1 is a Student
        
        // Profile 3: Instructor / Teacher
        registeredEmails.add("teacher@email.com");
        registeredPasswords.add("teacher123");
        registeredRoles.add("Teacher"); //Index 2 is a Teacher
        }
        
        // Clear your error text label on initialization
        lblErrorMessage.setText("");
    }
    // Dipanggil secara static oleh frame-frame lain (e.g., RegisterFrame, RegisterChild)
    public static boolean isValidEmail(String email) {
        // Acuan pattern e-mel rasmi
        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        
        // Pulangkan true jika e-mel user padan dengan pattern, false jika salah
        return email.matches(emailPattern); 
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WelcomeText = new javax.swing.JLabel();
        EmailText = new javax.swing.JLabel();
        EmailField = new javax.swing.JTextField();
        PassText = new javax.swing.JLabel();
        ForgotPassButton = new javax.swing.JButton();
        lblErrorMessage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        RegisterButton = new javax.swing.JButton();
        PassField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        WelcomeText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        WelcomeText.setText("Welcome To PrimeEdu");

        EmailText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        EmailText.setText("Email :");

        EmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailFieldActionPerformed(evt);
            }
        });

        PassText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PassText.setText("Password : ");

        ForgotPassButton.setText("Forgot Password ?");
        ForgotPassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForgotPassButtonActionPerformed(evt);
            }
        });

        LoginButton.setBackground(new java.awt.Color(204, 204, 255));
        LoginButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LoginButton.setText("Login");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Don\"t have an account yet? Register");

        RegisterButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RegisterButton.setText("Register");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PassField, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ForgotPassButton))
                        .addComponent(EmailText)
                        .addComponent(PassText)
                        .addComponent(LoginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(106, 106, 106))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(RegisterButton)
                        .addGap(164, 164, 164))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(WelcomeText)
                        .addGap(109, 109, 109))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(WelcomeText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EmailText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PassText)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ForgotPassButton)
                        .addComponent(PassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LoginButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(RegisterButton)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailFieldActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // 1. Ambil teks daripada input field yang BETUL (EmailField & PassField)
    String inputEmail = EmailField.getText().trim().toLowerCase();
    String inputPassword = new String(PassField.getPassword()).trim();
    
    // RESET WARNA ASAL (Putih) setiap kali butang ditekan
    EmailField.setBackground(java.awt.Color.WHITE);
    PassField.setBackground(java.awt.Color.WHITE);
    
    // 2. Semak jika ada ruangan kosong
    if (inputEmail.isEmpty() || inputPassword.isEmpty()) {
        lblErrorMessage.setText("Error: Email and Password fields cannot be empty!");
        lblErrorMessage.setForeground(java.awt.Color.RED);
        
        // TUKAR WARNA JADI PINK JIKA KOSONG
        if (inputEmail.isEmpty()) {
            EmailField.setBackground(new java.awt.Color(255, 204, 204)); // Warna Pink Lembut
        }
        if (inputPassword.isEmpty()) {
            PassField.setBackground(new java.awt.Color(255, 204, 204)); // Warna Pink Lembut
        }
        return; 
    }
    
    
    // 3. Constraint C1: Semak jika akaun kena kunci (lockout)
    if (loginAttempts >= 5) {
        lblErrorMessage.setText("Account locked. Maximum login attempts (5) exceeded.");
        lblErrorMessage.setForeground(java.awt.Color.RED);
        return;
    }
    
String userRole =
        loginController.loginUser(inputEmail, inputPassword);

if (userRole == null) {

    loginAttempts++;

    int remaining = 5 - loginAttempts;

    lblErrorMessage.setText(
        "Error: Invalid email or password. "
        + remaining + " attempts remaining."
    );

    lblErrorMessage.setForeground(java.awt.Color.RED);

    return;
}

loginAttempts = 0; 
    javax.swing.JOptionPane.showMessageDialog(this, "Login Successful as " + userRole + "!");
    
    // Buka page mengikut peranan masing-masing secara automatik
    if (userRole.equalsIgnoreCase("Parent")) {

    ParentFrame parentPage = new ParentFrame();
    parentPage.setVisible(true);

}
else if (userRole.equalsIgnoreCase("Child")) {

    StudentFrame studentPage = new StudentFrame();
    studentPage.setVisible(true);

}
else if (userRole.equalsIgnoreCase("Student")) {

    StudentFrame studentPage = new StudentFrame();
    studentPage.setVisible(true);

}
else if (userRole.equalsIgnoreCase("Instructor")) {

    InstructorFrame teacherPage = new InstructorFrame();
    teacherPage.setVisible(true);

}
    
    // Tutup LoginFrame
    this.dispose();
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void ForgotPassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForgotPassButtonActionPerformed
    // 1. Create an instance of the ForgotPassFrame window
    ForgotPassFrame forgotPage = new ForgotPassFrame();
    
    // 2. Make the ForgotPassFrame window visible to the user
    forgotPage.setVisible(true);
    
    // 3. Close or dispose of the current LoginFrame window
    this.dispose();
    }//GEN-LAST:event_ForgotPassButtonActionPerformed

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
  // 1. Create an instance of your registration window
    RegisterFrame registerPage = new RegisterFrame();
    
    // 2. Make the RegisterFrame window show up on screen
    registerPage.setVisible(true);
    
    // 3. Close the current LoginFrame window to keep things clean
    this.dispose();      
    }//GEN-LAST:event_RegisterButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EmailField;
    private javax.swing.JLabel EmailText;
    private javax.swing.JButton ForgotPassButton;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPasswordField PassField;
    private javax.swing.JLabel PassText;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JLabel WelcomeText;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblErrorMessage;
    // End of variables declaration//GEN-END:variables
}