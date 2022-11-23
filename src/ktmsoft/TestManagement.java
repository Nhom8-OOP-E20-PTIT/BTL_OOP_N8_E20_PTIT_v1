/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktmsoft;
import java.io.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import ktmsoft.Student_Management.student;
/**
 *
 * @author nguye
 */
public class TestManagement extends javax.swing.JFrame {
    static String DB_NAME = "enrollment";
    static String DB_NAME2 = "Test_Info";

    /**
     * Creates new form TestManagement
     */
    private String Course_ID, Group_ID, Test_StartTime, Test_Date, Test_Period,
            Room_ID, Test_Format, Supervisor_ID;

    public TestManagement(String Course_ID, String Group_ID, String Test_StartTime, String Test_Date, String Test_Period, String Room_ID, String Test_Format, String Supervisor_ID) {
        this.Course_ID = Course_ID;
        this.Group_ID = Group_ID;
        this.Test_StartTime = Test_StartTime;
        this.Test_Date = Test_Date;
        this.Test_Period = Test_Period;
        this.Room_ID = Room_ID;
        this.Test_Format = Test_Format;
        this.Supervisor_ID = Supervisor_ID;
    }

    public String getCourse_ID() {
        return Course_ID;
    }

    public String getGroup_ID() {
        return Group_ID;
    }

    public String getTest_StartTime() {
        return Test_StartTime;
    }

    public String getTest_Date() {
        return Test_Date;
    }

    public String getTest_Period() {
        return Test_Period;
    }

    public String getRoom_ID() {
        return Room_ID;
    }

    public String getTest_Format() {
        return Test_Format;
    }

    public String getSupervisor_ID() {
        return Supervisor_ID;
    }
    
    private ArrayList<TestManagement> list;
    DefaultTableModel model;
    public TestManagement() {
        initComponents();
        
        if(dbInfo.getRole().equals("st")){
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
            
        }
        model = (DefaultTableModel) jTable2.getModel();
        list = ReadAll();
        getAll();
        List<String> tableName = new ArrayList<>();
        
        try{
            dbInfo.setDbname(DB_NAME);
            dbInfo.setDburl(DB_NAME);
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
    public ArrayList ReadAll(){
        ArrayList<TestManagement> result = new ArrayList<>();
        dbInfo.setDbname(DB_NAME2);
        dbInfo.setDburl(DB_NAME2);
        try{
            String cmd = "SELECT * FROM Test";
            ResultSet rs = dbInfo.dbquery(cmd);
            while(rs.next()){
                String Course_ID = rs.getString("Course_ID");
                String Group_ID = rs.getString("Group_ID");
                String Test_StartTime = rs.getString("Test_StartTime");
                String Test_Date = rs.getString("Test_Date");
                String Test_Period = rs.getString("Test_Period");
                String Room_ID = rs.getString("Room_ID");
                String Test_Format = rs.getString("Test_Format");
                String Supervisor_ID = rs.getString("Supervisor_ID");
                
                TestManagement test = new TestManagement(Course_ID, Group_ID, Test_StartTime, Test_Date, Test_Period, Room_ID, Test_Format, Supervisor_ID);
                result.add(test);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
        
    }
    public void getAll(){
        model.setRowCount(0);
        for(TestManagement s : list){
            model.addRow(new Object[]{
                s.getCourse_ID(), s.getGroup_ID(), s.getTest_StartTime(), s.getTest_Date(), s.getTest_Period(), s.getRoom_ID(), s.getTest_Format(), s.getSupervisor_ID()
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Course ID");

        jLabel2.setText("Group ID");

        jLabel3.setText("Start Time");

        jLabel4.setText("Date");

        jLabel5.setText("Period");

        jLabel6.setText("Room ID");

        jLabel7.setText("Test Format");

        jLabel8.setText("Supervisor ID");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Course ID", "Group ID", "Start Time", "Date", "Period", "Room ID", "Test Format", "Supervisor ID"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Import");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Back to Main Menu");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField4)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(jTextField6)
                                            .addComponent(jTextField7)))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
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
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dbInfo.setDbname(DB_NAME2);
        dbInfo.setDburl(DB_NAME2);
        String Course_ID = jTextField1.getText();
        int selected_index = jComboBox1.getSelectedIndex();
        // String Group_ID = tableName.get(selected_index);
        String Group_ID = "group1";
        String Start_Time = jTextField3.getText();
        String Period = jTextField4.getText();
        String Date = jTextField5.getText();
        String Room_ID = jTextField6.getText();
        String Test_Format = jTextField7.getText();
        String Supervisor_ID = jTextField8.getText();
        
        if(Course_ID == ""){
            JOptionPane.showMessageDialog(null, "Course ID cannot be empty");
        }else if(Group_ID == ""){
            JOptionPane.showMessageDialog(null, "Group ID cannot be empty");
        }else if(Start_Time == ""){
            JOptionPane.showMessageDialog(null, "Start Time cannot be empty");
        }else if(Period == ""){
            JOptionPane.showMessageDialog(null, "Period cannot be empty");
        }else if(Date == ""){
            JOptionPane.showMessageDialog(null, "Date cannot be empty");
        }else if(Room_ID == ""){
            JOptionPane.showMessageDialog(null, "Room ID cannot be empty");
        }else if(Test_Format == ""){
            JOptionPane.showMessageDialog(null, "Test Format cannot be empty");
        }else if(Supervisor_ID == ""){
            JOptionPane.showMessageDialog(null, "Supervisor ID cannot be empty");
        }                
        String cmd = "INSERT INTO Test VALUES ('" + Course_ID + "', '" + 
                Group_ID + "', '" + Start_Time + "', '" + Date + "', '" + 
                Period + "', '" + Room_ID + "', '" + Test_Format + "', '" + Supervisor_ID + "');"; 
        dbInfo.dbexec(cmd);
        TestManagement tm = new TestManagement(Course_ID, Group_ID, Start_Time, Date, Period, Room_ID, Test_Format, Supervisor_ID);
        list.add(tm);
        getAll();
        jTextField1.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int del_index = jTable2.getSelectedRow();
        if(del_index == -1){
            JOptionPane.showMessageDialog(null, "Please select one line to delete");
        }else if(list.size() == 0){
            JOptionPane.showMessageDialog(null, "No data to delete");
        }else{
            TestManagement st_del = list.get(del_index);
            list.remove(del_index);
            dbInfo.setDbname(DB_NAME2);
            dbInfo.setDburl(DB_NAME2);
            String cmd = "DELETE FROM Test WHERE Group_ID = '" + st_del.Group_ID + "';";
            dbInfo.dbexec(cmd);
            getAll();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextField1.setText("");
        // lack jComboBox;
        jTextField3.setText(""); 
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        int edit_index = jTable2.getSelectedRow();
        if(edit_index == -1){
            JOptionPane.showMessageDialog(null, "Please select one line to edit");
        }else if(list.size() == 0){
            JOptionPane.showMessageDialog(null, "No data to edit");
        }else{
            dbInfo.setDbname(DB_NAME2);
            dbInfo.setDburl(DB_NAME2);            
            TestManagement st_edit = list.get(edit_index);
            list.remove(edit_index);
            String cmd = "DELETE FROM Test WHERE Group_ID = '" + st_edit.Group_ID + "';";
            dbInfo.dbexec(cmd);
            jTextField1.setText(st_edit.Course_ID);
            // lack jComboBox
            jTextField3.setText(st_edit.Test_StartTime);
            jTextField4.setText(st_edit.Test_Period);
            jTextField5.setText(st_edit.Test_Date);
            jTextField6.setText(st_edit.Room_ID);
            jTextField7.setText(st_edit.Test_Format);
            jTextField8.setText(st_edit.Supervisor_ID);    
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dbInfo.setDbname(DB_NAME2);
        dbInfo.setDburl(DB_NAME2);
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".CSV file", "csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        File location = null;
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            location = chooser.getSelectedFile();
        }
        
        try {
            Scanner sc = new Scanner(location);
            while(sc.hasNext()){
                String s = sc.nextLine();
                String st[] = s.trim().split(",");
                String Course_ID = st[0];
                String Group_ID = st[1];
                String Start_Time = st[2];
                String Date = st[3];
                String Period = st[4];
                String Room_ID = st[5];
                String Test_Format = st[6];
                String Supervisor_ID = st[7];
                
                String cmd = "INSERT INTO Test VALUES ('" + Course_ID + "', '" + 
                Group_ID + "', '" + Start_Time + "', '" + Date + "', '" + 
                Period + "', '" + Room_ID + "', '" + Test_Format + "', '" + Supervisor_ID + "');"; 
                dbInfo.dbexec(cmd);
                TestManagement tm = new TestManagement(Course_ID, Group_ID, Start_Time, Date, Period, Room_ID, Test_Format, Supervisor_ID);
                list.add(tm);              
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Student_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        getAll(); 
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(TestManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestManagement().setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
