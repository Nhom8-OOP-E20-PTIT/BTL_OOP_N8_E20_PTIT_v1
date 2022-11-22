/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktmsoft;

import javax.swing.JOptionPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import ktmsoft.dbInfo;
import ktmsoft.Student_Management;
import ktmsoft.Student_Management.student;
import ktmsoft.AlgorithmForDistributingGroups;
public class EncodeAndDecodeTest extends javax.swing.JFrame {

    static class student{
        private String stu_ID;
        private String group_ID;
        private String secret_ID;

        public student(String stu_ID, String group_ID, String secret_ID) {
            this.stu_ID = stu_ID;
            this.group_ID = group_ID;
            this.secret_ID = secret_ID;
        }
        
        
        public student(String stu_ID, String group_ID) {
            this.stu_ID = stu_ID;
            this.group_ID = group_ID;
        }

        public String getStu_ID() {
            return stu_ID;
        }

        public String getGroup_ID() {
            return group_ID;
        }

        public String getSecret_ID() {
            return secret_ID;
        }

        public void setSecret_ID(String secret_ID) {
            this.secret_ID = secret_ID;
        }
        
        
    }
    DefaultTableModel model;
    List<String> tableName = new ArrayList<>();
    ArrayList<student> students = new ArrayList<>();
    static String DB_NAME = "enrollment";
    static String DB_NAME_2 = "Test_Info";
    public EncodeAndDecodeTest() {
        initComponents();
        dbInfo.setDbname(DB_NAME);
        dbInfo.setDburl(DB_NAME);
        tableName.clear();
        model = (DefaultTableModel) jTable1.getModel();
        getAll();
        try{
            String cmd = "SHOW TABLES";
            ResultSet rs = dbInfo.dbquery(cmd);
            while(rs.next()){
                tableName.add(rs.getString("Tables_in_enrollment"));
            }
            
        }catch(Exception e){
            e.printStackTrace();;
        }
        for(String x : tableName){
            jComboBox1.addItem(x);
        }
    }
    public void getAll(){
        model.setRowCount(0);
        for(student s : students){
            model.addRow(new Object[]{
                s.getStu_ID(), s.getGroup_ID(), s.getSecret_ID()
            });
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

        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Encode");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Group ID");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Group ID", "Secret ID"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setText("Encode And Decode Test");

        jButton3.setText("Load");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Back to Main Menu");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton4)
                        .addGap(174, 174, 174)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jButton3)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButton4))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        students.clear();
        dbInfo.setDbname(DB_NAME);
        dbInfo.setDburl(DB_NAME);
        
        int selected_index = jComboBox1.getSelectedIndex();
        String group_name = tableName.get(selected_index);

        try{
            String cmd = "SELECT Stu_ID FROM " + group_name + ";";
            ResultSet rs = dbInfo.dbquery(cmd);
            while(rs.next()){
                String Stu_ID = rs.getString("Stu_ID");
                String Group_ID = group_name;
                student st = new student(Stu_ID, Group_ID);
                students.add(st);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        int sizeOfGroup = students.size();
        List<Integer> idx = new ArrayList<>();
        for(int i = 0; i < sizeOfGroup; i++){
            idx.add(i+1);
        }
        Random ran = new Random();
        for(student i : students){
            int index = ran.nextInt(idx.size());
            int n = idx.get(index);
            String Secret_ID = String.format("SEC%03d", n);
            i.setSecret_ID(Secret_ID);
            idx.remove(index);
        }
        dbInfo.setDbname(DB_NAME_2);
        dbInfo.setDburl(DB_NAME_2);
        for(student i : students){
            try{
                String cmd = "INSERT INTO encode VALUES('" + i.stu_ID + "','" + i.group_ID + "','" + i.secret_ID + "');";
                dbInfo.dbexec(cmd);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        getAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        if(dbInfo.getRole().equals("ad")){
            Menu_Admin m = new Menu_Admin();
            m.setVisible(true);
            m.setLocationRelativeTo(null);
        }
        else if(dbInfo.getRole().equals("le")){
            Menu_Lecturer m = new Menu_Lecturer();
            m.setVisible(true);
            m.setLocationRelativeTo(null);
        }
        else if(dbInfo.getRole().equals("st")){
            Menu_Student m = new Menu_Student();
            m.setVisible(true);
            m.setLocationRelativeTo(null);
        }
        else if(dbInfo.getRole().equals("su")){
            Menu_Supervisor m = new Menu_Supervisor();
            m.setVisible(true);
            m.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        students.clear();
        dbInfo.setDbname(DB_NAME_2);
        dbInfo.setDburl(DB_NAME_2);
        
        int selected_index = jComboBox1.getSelectedIndex();
        String group_name = tableName.get(selected_index);

        try{
            String cmd = "SELECT * FROM encode WHERE Group_ID ='" + group_name + "';" ;
            ResultSet rs = dbInfo.dbquery(cmd);
            while(rs.next()){
                String Stu_ID = rs.getString("Stu_ID");
                String Group_ID = group_name;
                String Secret_ID = rs.getString("Secret_ID");
                student st = new student(Stu_ID, Group_ID, Secret_ID);
                students.add(st);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        getAll();        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(EncodeAndDecodeTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EncodeAndDecodeTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EncodeAndDecodeTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EncodeAndDecodeTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EncodeAndDecodeTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
