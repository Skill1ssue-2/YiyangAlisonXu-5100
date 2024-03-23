/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package main;

import com.neu.jdbcapp.model.User;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.text.SimpleDateFormat;
import jdbcApp.DatabaseConnector;



/**
 *
 * @author A
 */
public class FormPanel extends javax.swing.JPanel {

    /**
     * Creates new form FormPanel
     */
    private JPanel bottomPanel;
    public FormPanel(JPanel bottomPanel) {
        initComponents();
        this.bottomPanel = bottomPanel;
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderButtonGroup = new javax.swing.ButtonGroup();
        jFileChooser1 = new javax.swing.JFileChooser();
        formTitleLable = new javax.swing.JLabel();
        firstnameLable = new javax.swing.JLabel();
        ageLable = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        ageTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(789, 488));

        formTitleLable.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        formTitleLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        formTitleLable.setText("Patient Registration Form");

        firstnameLable.setText("Name");

        ageLable.setText("Age");

        ageTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ageTextFieldKeyPressed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstnameLable, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ageLable))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ageTextField)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(saveButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(formTitleLable, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(272, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(formTitleLable, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstnameLable)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageLable)
                    .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(saveButton)
                .addContainerGap(191, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
//    public User newUser;
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        User newUser = new User();
        String Name = nameTextField.getText(); //
        
        int age = Integer.parseInt(ageTextField.getText()); 

        try {
            newUser.setName(nameTextField.getText());
            newUser.setAge(Integer.parseInt(ageTextField.getText())); 
            DatabaseConnector.addUser(newUser);  
            JOptionPane.showMessageDialog(null, "User Added");
                    } 
        catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                    }
        ViewPanel newViewPanel = new ViewPanel(newUser, bottomPanel);
        bottomPanel.add(newViewPanel, "ViewPanel");
        CardLayout layout = (CardLayout)bottomPanel.getLayout();

    }//GEN-LAST:event_saveButtonActionPerformed

    private void ageTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ageTextFieldKeyPressed
        // TODO add your handling code here:
        try{
            int age = Integer.parseInt(ageTextField.getText());
            ageTextField.setForeground(Color.black);
        } 
        catch(Exception e){
            ageTextField.setForeground(Color.red);
        }
    }//GEN-LAST:event_ageTextFieldKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ageLable;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JLabel firstnameLable;
    private javax.swing.JLabel formTitleLable;
    private javax.swing.ButtonGroup genderButtonGroup;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
