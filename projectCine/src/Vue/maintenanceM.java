/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vue;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author arthur
 */
public class maintenanceM extends javax.swing.JFrame {
    
    private Fenetre mafenetre = new Fenetre(false);
    String u;
    /**
     * Creates new form maintenanceM
     */
    public maintenanceM(String username)  throws SQLException, ClassNotFoundException{
        initComponents();
        u=username;
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
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ancienne adresse mail");

        jLabel2.setText("Nouvelle adresse mail");

        jLabel3.setText("Nouveau mot de passe");

        jButton1.setText("Valider");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Retour");

        jLabel4.setText("Ancien mot de passe");

        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jButton1)
                        .addGap(90, 90, 90)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)))
                                .addGap(62, 62, 62))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(74, 74, 74)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(183, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(88, 88, 88))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(jTextField1.getText().equals("") && jPasswordField1.getText().equals("")){ 
          
          JOptionPane.showMessageDialog(this, "enter username and password");
          
       }
       
       else if (!(jTextField1.getText().equals("")) && jPasswordField1.getText().equals("") ){
           
           JOptionPane.showMessageDialog(this, "enter password");
       }
       
       else if ((jTextField1.getText().equals("")) && !jPasswordField1.getText().equals("")) {
           
           JOptionPane.showMessageDialog(this, "enter username");
       } 
       else try {
            // TODO add your handling code here:
            if (mafenetre.veri(jTextField1.getText(), jPasswordField1.getText())==true)
            {
                mafenetre.NMember(jTextField1.getText(), jTextField2.getText(), jTextField3.getText());
                JOptionPane.showMessageDialog(this, "changement opéré");
                new accueilEmploye(u).setVisible(true); 
            }
            else if(mafenetre.veri(jTextField1.getText(), jPasswordField1.getText())==false)
            {
               JOptionPane.showMessageDialog(this, "wrong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(maintenanceM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(maintenanceM.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MouseEntered
        // TODO add your handling code here:
        jPasswordField1.setEchoChar('\u0000');
    }//GEN-LAST:event_jPasswordField1MouseEntered

    private void jPasswordField1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MouseExited
        // TODO add your handling code here:
        jPasswordField1.setEchoChar('\u25cf');
    }//GEN-LAST:event_jPasswordField1MouseExited

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
