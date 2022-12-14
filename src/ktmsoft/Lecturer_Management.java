/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktmsoft;
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
/**
 *
 * @author nguyenanhkiet
 */
public class Lecturer_Management extends javax.swing.JDialog {
    static class lecturer{
        private String lec_id;
        private String lec_name;
        private String dept_id;
        public lecturer(String lec_id, String lec_name, String dept_id){
            this.lec_id = lec_id;
            this.lec_name = lec_name;
            this.dept_id = dept_id;
        }

        public String getLec_id() {
            return lec_id;
        }

        public String getLec_name() {
            return lec_name;
        }

        public String getDept_id() {
            return dept_id;
        }
        
    }
    private ArrayList<lecturer> list;
    DefaultTableModel model;
    String DB_NAME = "info";  
    public Lecturer_Management() {
        list = ReadAll();
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        getAll();
    }
    public Lecturer_Management(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        list = ReadAll();
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        getAll();
    }
    public ArrayList ReadAll(){
        ArrayList<lecturer> result = new ArrayList<>();
        dbInfo.setDbname(DB_NAME);
        dbInfo.setDburl(DB_NAME);
        try{
            String cmd = "SELECT * FROM lecturer";
            ResultSet rs = dbInfo.dbquery(cmd);
            while(rs.next()){
                String lec_id = rs.getString("lec_id");
                String lec_name = rs.getString("lec_name");
                String dept_id = rs.getString("dept_id");
                lecturer st = new lecturer(lec_id, lec_name, dept_id);
                result.add(st);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
        
    }
    public void getAll(){
        model.setRowCount(0);
        for(lecturer s : list){
            model.addRow(new Object[]{
                s.getLec_id(), s.getLec_name(), s.getDept_id()
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Lecturer Management");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        jTable1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Lecturer ID", "Lecturer Name", "Department ID"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("Lecturer Name");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Lecturer ID");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Department ID");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

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

        jLabel2.setText("Sort By");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name Ascending", "Name Descending", "ID Ascending", "ID Descending", "Department Ascending", "Department Descending" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
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
                .addGap(16, 16, 16)
                .addComponent(jButton5)
                .addGap(259, 259, 259)
                .addComponent(jLabel1)
                .addGap(153, 153, 153))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                .addGap(171, 171, 171))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton5)))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        dbInfo.setDbname(DB_NAME);
        dbInfo.setDburl(DB_NAME);
        String lec_name = jTextField1.getText();
        String lec_id = jTextField2.getText();
        String dept_id = jTextField3.getText();
        if(lec_name == ""){
            JOptionPane.showMessageDialog(null, "Lecturer name cannot be empty");
        }else if(lec_id == ""){
            JOptionPane.showMessageDialog(null, "Lecturer ID cannot be empty");
        }else if(dept_id == ""){
            JOptionPane.showMessageDialog(null, "Department ID cannot be empty");
        }        
        String cmd = "INSERT INTO lecturer VALUES ('" + lec_id + "' , '" + lec_name + "' , '" + dept_id + "');" ;
        dbInfo.dbexec(cmd);
        lecturer stnew = new lecturer(lec_id, lec_name, dept_id);
        list.add(stnew);
        getAll();
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int del_index = jTable1.getSelectedRow();
        if(del_index == -1){
            JOptionPane.showMessageDialog(null, "Please select one line to delete");
        }else if(list.size() == 0){
            JOptionPane.showMessageDialog(null, "No data to delete");
        }else{
            lecturer st_del = list.get(del_index);
            list.remove(del_index);
            dbInfo.setDbname(DB_NAME);
            dbInfo.setDburl(DB_NAME);
            String cmd = "DELETE FROM lecturer WHERE lec_id = '" + st_del.lec_id + "';";
            dbInfo.dbexec(cmd);
            getAll();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");        
        int edit_index = jTable1.getSelectedRow();
        if(edit_index == -1){
            JOptionPane.showMessageDialog(null, "Please select one line to edit");
        }else if(list.size() == 0){
            JOptionPane.showMessageDialog(null, "No data to edit");
        }else{
            dbInfo.setDbname(DB_NAME);
            dbInfo.setDburl(DB_NAME);            
            lecturer st_edit = list.get(edit_index);
            list.remove(edit_index);
            String cmd = "DELETE FROM lecturer WHERE lec_id = '" + st_edit.lec_id + "';";
            dbInfo.dbexec(cmd);
            jTextField1.setText(st_edit.lec_name);
            jTextField2.setText(st_edit.lec_id);
            jTextField3.setText(st_edit.dept_id);
        } 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int selected_index = jComboBox1.getSelectedIndex();
        if(selected_index == 0){
            list.sort(Comparator.comparing(lecturer::getLec_name));
            
        }else if(selected_index == 1){
            list.sort(Comparator.comparing(lecturer::getLec_name).reversed());
                       
        }else if(selected_index == 2){
            list.sort(Comparator.comparing(lecturer::getLec_id));
                        
        }else if(selected_index == 3){
            list.sort(Comparator.comparing(lecturer::getLec_id).reversed());
                     
        }else if(selected_index == 4){
            list.sort(Comparator.comparing(lecturer::getDept_id));
                    
        }else if(selected_index == 5){
            list.sort(Comparator.comparing(lecturer::getDept_id).reversed());
                        
        }
        getAll();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dbInfo.setDbname(DB_NAME);
        dbInfo.setDburl(DB_NAME);
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
                String lec_id = st[0];
                String lec_name = st[1];
                String dept_id = st[2];
                String cmd = "INSERT INTO lecturer VALUES ('" + lec_id + "' , '" + lec_name + "' , '" + dept_id + "');" ;
                dbInfo.dbexec(cmd);
                lecturer stim = new lecturer(lec_id, lec_name, dept_id);
                list.add(stim);                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lecturer_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        getAll();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Lecturer_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lecturer_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lecturer_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lecturer_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Lecturer_Management dialog = new Lecturer_Management(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
