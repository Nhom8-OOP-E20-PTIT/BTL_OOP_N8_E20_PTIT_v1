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
import static ktmsoft.MarkTheTest.DB_NAME_2;
public class TestResult extends javax.swing.JFrame {

    static class student{
        private String Stu_ID;
        private String Course_ID;
        private String Group_ID;
        private String Stu_Score;

        public student(String Stu_ID, String Course_ID, String Group_ID, String Stu_Score) {
            this.Stu_ID = Stu_ID;
            this.Course_ID = Course_ID;
            this.Group_ID = Group_ID;
            this.Stu_Score = Stu_Score;
        }
        
        public student(String Stu_ID, String Group_ID, String Stu_Score) {
            this.Stu_ID = Stu_ID;
            this.Group_ID = Group_ID;
            this.Stu_Score = Stu_Score;
        }

        public String getStu_ID() {
            return Stu_ID;
        }

        public void setStu_ID(String Stu_ID) {
            this.Stu_ID = Stu_ID;
        }

        public String getCourse_ID() {
            return Course_ID;
        }

        public void setCourse_ID(String Course_ID) {
            this.Course_ID = Course_ID;
        }

        public String getGroup_ID() {
            return Group_ID;
        }

        public void setGroup_ID(String Group_ID) {
            this.Group_ID = Group_ID;
        }

        public String getStu_Score() {
            return Stu_Score;
        }

        public void setStu_Score(String Stu_Score) {
            this.Stu_Score = Stu_Score;
        }

        
        
    }
    static String DB_NAME = "Test_Info";
    static String DB_NAME2 = "enrollment";
    DefaultTableModel model;
    ArrayList<student> students = new ArrayList<>();
    ArrayList<student> filter = new ArrayList<>();
    List<String> tableName = new ArrayList<>();    
    public TestResult() {
        initComponents();
        dbInfo.setDburl(DB_NAME);
        dbInfo.setDbname(DB_NAME);
        model = (DefaultTableModel) jTable1.getModel();
        try{
            String cmd = "SELECT e.Stu_ID, e.Group_ID, m.Stu_Score FROM encode e, marking m WHERE e.Secret_ID = m.Secret_ID AND e.Group_ID = m.Group_ID;";
            ResultSet rs = dbInfo.dbquery(cmd);
            while(rs.next()){
                String Stu_ID = rs.getString("Stu_ID");
                String Group_ID = rs.getString("Group_ID");
                String Stu_Score = rs.getString("Stu_Score");
                String Course_ID = "";
                try{
                    String cmd2 = "SELECT DISTINCT Course_ID FROM enrollment." + Group_ID +";";
                    ResultSet rs2 = dbInfo.dbquery(cmd2);
                    while(rs2.next()){
                        Course_ID = rs2.getString("Course_ID");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                student st = new student(Stu_ID, Course_ID, Group_ID, Stu_Score);
                students.add(st);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
         // add tableName
        dbInfo.setDbname(DB_NAME2);
        dbInfo.setDburl(DB_NAME2);
        tableName.clear();
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
        }else if(dbInfo.getRole().equals("st")){
            for(int i = 1; i <= count; i++){
                try{
                    String cmd = "SELECT EXISTS(SELECT * from group" + i +  " WHERE stu_ID='" + dbInfo.USERNAME +"');";
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
    }
    public void getAll(){
        model.setRowCount(0);
        for(student s : students){
            model.addRow(new Object[]{
                s.getStu_ID(), s.getCourse_ID(), s.getGroup_ID(), s.getStu_Score()
            });
        }
    }
    public void getAll2(ArrayList<student> arr){
        model.setRowCount(0);
        for(student s : arr){
            model.addRow(new Object[]{
                s.getStu_ID(), s.getCourse_ID(), s.getGroup_ID(), s.getStu_Score()
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Student ID");

        jLabel2.setText("Course ID");

        jLabel3.setText("Group ID");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Course ID", "Group ID", "Student Score"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Ascending", "ID Descending", "Course ID Ascending", "Course ID Descending", "Group ID Ascending", "Group ID Descending", "Score Ascending", "Score Descending" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Sort By");

        jButton2.setText("Back to Main Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Save to DB");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton2)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3))))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        int selected_index = jComboBox2.getSelectedIndex();
        if(selected_index == 0){
            students.sort(Comparator.comparing(student::getStu_ID));
        }else if(selected_index == 1){
            students.sort(Comparator.comparing(student::getStu_ID).reversed());
        }else if(selected_index == 2){
            students.sort(Comparator.comparing(student::getCourse_ID));
        }else if(selected_index == 3){
            students.sort(Comparator.comparing(student::getCourse_ID).reversed());
        }else if(selected_index == 4){
            students.sort(Comparator.comparing(student::getGroup_ID));
        }else if(selected_index == 5){
            students.sort(Comparator.comparing(student::getGroup_ID).reversed());
        }else if(selected_index == 6){
            students.sort(Comparator.comparing(student::getStu_Score));
        }else if(selected_index == 7){
            students.sort(Comparator.comparing(student::getStu_Score).reversed());
        }
        getAll();        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dbInfo.setDbname(DB_NAME);
        dbInfo.setDburl(DB_NAME);
        filter.clear();
        model.setRowCount(0);
        int selected_index = jComboBox1.getSelectedIndex();
        String group_name = tableName.get(selected_index);
        for(student i : students){
            if(i.getGroup_ID().equals(group_name)){
                filter.add(i);
            }
        }
        getAll2(filter);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dbInfo.setDburl(DB_NAME);
        dbInfo.setDbname(DB_NAME);        
        for(student i : filter){
            String Stu_ID = i.getStu_ID();
            String Course_ID = i.getCourse_ID();
            String Group_ID = i.getGroup_ID();
            String Student_Score = i.getStu_Score();
            String cmd = "INSERT INTO result VALUES('" + Stu_ID + "','" + Course_ID + "','" + Group_ID + "','" + Student_Score + "');" ;
            dbInfo.dbexec(cmd);
        }
        JOptionPane.showMessageDialog(null, "Done");
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
            java.util.logging.Logger.getLogger(TestResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestResult().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
