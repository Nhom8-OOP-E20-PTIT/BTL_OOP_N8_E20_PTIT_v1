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
public class MarkTheTest extends javax.swing.JFrame {

    static class student{
        private String Group_ID;
        private String Secret_ID;
        private String Stu_Score;

        public student(String Group_ID, String Secret_ID, String Stu_Score) {
            this.Group_ID = Group_ID;
            this.Secret_ID = Secret_ID;
            this.Stu_Score = Stu_Score;
        }
        
        public student(String Group_ID, String Secret_ID) {
            this.Group_ID = Group_ID;
            this.Secret_ID = Secret_ID;
        }

        public String getGroup_ID() {
            return Group_ID;
        }

        public String getSecret_ID() {
            return Secret_ID;
        }

        public String getStu_Score() {
            return Stu_Score;
        }

        public void setStu_Score(String Stu_Score) {
            this.Stu_Score = Stu_Score;
        }
        
        
        
        
    }
    static String DB_NAME = "enrollment";
    static String DB_NAME_2 = "Test_Info";
    DefaultTableModel model;
    ArrayList<student> students = new ArrayList<>();
    List<String> tableName = new ArrayList<>();
    

    public MarkTheTest() {
        initComponents();
        dbInfo.setDbname(DB_NAME);
        dbInfo.setDburl(DB_NAME);
        tableName.clear();
        model = (DefaultTableModel) jTable1.getModel();
        getAll();
        int count = 0;
        try{
            String cmd = "SHOW TABLES";
            ResultSet rs = dbInfo.dbquery(cmd);
            while(rs.next()){
                count++;
            }
            
        }catch(Exception e){
            e.printStackTrace();;
        }
        if(dbInfo.getRole().equals("ad")){
            for(int i = 1; i <= count; i++){
                tableName.add("group" + i);
            }
        }else if(dbInfo.getRole().equals("le")){
            for(int i = 1; i <= count; i++){
                try{
                    String cmd = "SELECT EXISTS(SELECT * from group" + i +  " WHERE Lec_ID='" + dbInfo.USERNAME +"');";
//                    System.out.println(cmd);
                    ResultSet rs = dbInfo.dbquery(cmd);
                    while(rs.next()){
                        int b = Integer.parseInt(rs.getString(1));
                        if(b==1){
                            tableName.add("group" + i);
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        for(String x : tableName){
            jComboBox1.addItem(x);
        }
        getAll();
        
    }
    public void getAll(){
        model.setRowCount(0);
        for(student s : students){
            model.addRow(new Object[]{
                s.getGroup_ID(), s.getSecret_ID(), s.getStu_Score()
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Secret ID");

        jLabel2.setText("Group ID");

        jLabel3.setText("Student Score");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Group ID", "Secret ID", "Student Score"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Mark");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Back to Main Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Load");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(46, 46, 46)
                                .addComponent(jTextField1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField2))))
                        .addGap(34, 34, 34)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addGap(100, 100, 100))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(0, 598, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        int edit_index = jTable1.getSelectedRow();
        if(edit_index == -1){
            JOptionPane.showMessageDialog(null, "Please select one line to edit");
        }else if(students.size() == 0){
            JOptionPane.showMessageDialog(null, "No data to edit");
        }else{
            dbInfo.setDbname(DB_NAME_2);
            dbInfo.setDburl(DB_NAME_2);            
            student st_edit = students.get(edit_index);
            students.remove(edit_index);
            jTextField1.setText(st_edit.Secret_ID);
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_jButton1ActionPerformed

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
                String Group_ID = group_name;
                String Secret_ID = rs.getString("Secret_ID");
                student st = new student(Group_ID, Secret_ID);
                students.add(st);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        for(student i : students){
            try{
                String Group_ID = i.Group_ID;
                String Secret_ID = i.Secret_ID;
                String cmd = "INSERT INTO marking VALUES('" + Group_ID + "','" + Secret_ID + "','null');";
                dbInfo.dbexec(cmd);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        getAll();         
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dbInfo.setDbname(DB_NAME_2);
        dbInfo.setDburl(DB_NAME_2);
        String Secret_ID = jTextField1.getText();
        String Stu_Score = jTextField2.getText();
        int selected_index = jComboBox1.getSelectedIndex();
        String Group_ID = tableName.get(selected_index);
        if(Secret_ID == ""){
            JOptionPane.showMessageDialog(null, "Secret ID cannot be empty");
        }else if(Stu_Score == ""){
            JOptionPane.showMessageDialog(null, "Student score cannot be empty");
        }
        String cmd = "DELETE FROM marking WHERE Secret_ID = '" + Secret_ID + "' AND Group_ID = '" + Group_ID + "';";
        dbInfo.dbexec(cmd);
        String cmd2 = "INSERT INTO marking VALUES('" + Group_ID + "','" + Secret_ID + "','" + Stu_Score +"');";
        dbInfo.dbexec(cmd2);
        student st = new student(Group_ID, Secret_ID, Stu_Score);
        students.add(st);
        getAll();
        jTextField1.setText("");
        jTextField2.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dbInfo.setDbname(DB_NAME_2);
        dbInfo.setDburl(DB_NAME_2);
        students.clear();
        model.setRowCount(0);
        try{
            String cmd = "SELECT * FROM marking";
            ResultSet rs = dbInfo.dbquery(cmd);
            while(rs.next()){
                String Group_ID = rs.getString("Group_ID");
                String Secret_ID = rs.getString("Secret_ID");
                String Stu_Score = rs.getString("Stu_Score");
                student st = new student(Group_ID, Secret_ID, Stu_Score);
                students.add(st);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        getAll();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(MarkTheTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarkTheTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarkTheTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarkTheTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarkTheTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
