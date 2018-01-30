
package bigdataanalytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Preprocessing extends javax.swing.JFrame {
Connection con;
Statement st,st1,st2,st3,st4;
ResultSet rs,rs1,rs2,rs3;
public static String path=Loaddata.s;    
    public Preprocessing() {
        initComponents();
         try 
        {
             Class.forName("com.mysql.jdbc.Driver");    
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/analytics", "root", "");  
            st=con.createStatement();
            st1=con.createStatement();
            st2=con.createStatement();
            st3=con.createStatement();
            st4=con.createStatement();
        }
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println("Error in MySql Connection:::"+e.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jDesktopPane1.setOpaque(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Raw DataSet", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Raw DataSet");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 150, 33));

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setText("PreProcessing");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 150, 33));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 370, 310));

        jDesktopPane1.add(jPanel1);
        jPanel1.setBounds(20, 70, 430, 450);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Preprocessed DataSet", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setText("Preprocessed DataSet");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, 30));

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton4.setText("Next");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 140, 33));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 390, 310));

        jDesktopPane1.add(jPanel2);
        jPanel2.setBounds(470, 70, 450, 450);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("PreProcessing Form");
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(380, 10, 230, 50);

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try {
            int cunt = 0;
            String s2[] = new String[1000] ;
            int j = 0;
            int r = 0;         
            javax.swing.table.DefaultTableModel t = new javax.swing.table.DefaultTableModel();  
            jTable1.setModel(t);
            //jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            for (int i = 0; i <= 5617; i++) {
                t.insertRow(i, new Object[]{""});
            }
            String ss = "SHOW COLUMNS FROM `dtable1`";           
            rs1 = st1.executeQuery(ss);
            while (rs1.next()) {
                t.addColumn(rs1.getString(1));
            }
            String s1 = "SELECT * FROM  `dtable1`";
            rs1 = st1.executeQuery(s1);
            while (rs1.next()) {
                for (int i1 = 0; i1 < 10; i1++) {
                    s2[i1] = rs1.getString(i1 + 1);
                    t.setValueAt(s2[i1], r, j++);
                }
                r++;
                j = 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         try {
             System.out.println("Path is "+path);
            BufferedReader br = new BufferedReader(new FileReader(path));
            String str;
            while ((str = br.readLine()) != null) {
                String rtn = str.replaceAll("[\\-]", "null");
                String[] split = rtn.split(",");
               System.out.println(split[0]+split[1]+split[2]+split[3]);
                st.executeUpdate("insert into preprocess values('" + split[0] + "','" + split[1] + "','" + split[2] + "','" + split[3] + "','" + split[4] + "','" + split[5] + "','" + split[6] + "','" + split[7] + "','" + split[8] + "','" + split[9] + "')");
//               st1.executeUpdate("DELETE FROM `preprocess` WHERE `age`='null', `workclass`='null', `fnlwgt`='null' , `education`='null', `educationnum`='null', `marritalstatus`='null', `occupation`='null' , `relation`='null' , `race`='null' , `sex` ='null', `capitalgain`='null', `capitalloss`='null' , `hoursperweek`='null' , `nativecountry`='null' , `class`='null' ");
 
            }
            JOptionPane.showMessageDialog(this, " Symbols are converted into null ");
           st1.executeUpdate("DELETE FROM `preprocess` WHERE `sno`='null' OR `Network`='null' OR `Type`='null' OR `Source`='null' OR `Destination`='null' OR `Noofstations`='null' OR `Base1`='null' OR `Base2`='null' OR `Base3`='null' OR `Priority` ='null' ");
               
            JOptionPane.showMessageDialog(this, "Preprocessing successfully finished");
        } catch (Exception e) {
            System.err.println(e);         
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            int cunt = 0;
            String s2[] = new String[1000] ;    
            int j = 0;
            int r = 0;        
            javax.swing.table.DefaultTableModel t = new javax.swing.table.DefaultTableModel();
            jTable2.setModel(t);
            //jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            for (int i = 0; i <= 5617; i++) {
                t.insertRow(i, new Object[]{""});
            }
            String ss = "SHOW COLUMNS FROM `preprocess`";      
            rs1 = st2.executeQuery(ss);
            while (rs1.next()) {
                t.addColumn(rs1.getString(1));
            }
            String s1 = "SELECT * FROM  `preprocess`";
            rs1 = st2.executeQuery(s1);
            while (rs1.next()) {
                for (int i1 = 0; i1 < 10; i1++) {
                    s2[i1] = rs1.getString(i1 + 1);
                    t.setValueAt(s2[i1], r, j++);
                }
                r++;
                j = 0;  
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      //  new Classification().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

  
    public static void main(String args[]) {
       
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
            java.util.logging.Logger.getLogger(Preprocessing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Preprocessing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Preprocessing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Preprocessing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

     
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Preprocessing().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
