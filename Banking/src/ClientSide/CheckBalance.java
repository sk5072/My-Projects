/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientSide;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Sunil
 */
public class CheckBalance extends javax.swing.JFrame {

    /**
     * Creates new form CheckBalance
     */
    String username,who;
    String accountno;
    
    boolean set;
    public CheckBalance() {
        initComponents();
    }
    
    
    
    public CheckBalance(String username,String who)
    {
        initComponents();
        this.username=username;
        this.who=who;
        this.user.setText(username);
//        setTextofAccount(acc);
    }
    
//    public CheckBalance(String username,String who,String acc)
//    {
//        this(username,who);
//        setTextofAccount(acc);
//    }
    
    int setTextofAccount(String acc)
    {
        this.accountnotf.setText(acc);
        this.accountnotf.disable();
        return 1;
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
        accountnotf = new javax.swing.JTextField();
        user = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        checkbalance = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Account no:");

        accountnotf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountnotfActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        checkbalance.setText("Check Balance");
        checkbalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbalanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 46, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkbalance)
                            .addComponent(accountnotf, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(150, 150, 150))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountnotf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(51, 51, 51)
                .addComponent(checkbalance)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkbalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbalanceActionPerformed
        // TODO add your handling code here:
        accountno=accountnotf.getText();
        ClientStub client=new ClientStub();
        int balance = 0;
        if(!accountno.equals(""))
        {

            try {
                set = client.stub.checkAccountno(accountno);
            } catch (RemoteException ex) {
                Logger.getLogger(CheckBalance.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(set==true)
            {
                try {
                balance = client.stub.checkBalance(accountno);
                JOptionPane.showMessageDialog(this,balance);
                if(who.equals("employee"))
                {
                    this.setVisible(false);
                    Employee e=new Employee(username,who);
                    e.setVisible(true);
                }
                else
                {
                    this.setVisible(false);
                    Customer c=new Customer(username,who);
                    c.setVisible(true);
                }
                } catch (RemoteException ex) {
                    Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                                JOptionPane.showMessageDialog(this,"Wrong account info");
            }
//           
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Please enter account no.");
        }
        
        
        
        
//        try {
//                balance = client.stub.checkBalance();
//                JOptionPane.showMessageDialog(this,balance);
//        } catch (RemoteException ex) {
//            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_checkbalanceActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Employee e=new Employee(username,who);
        e.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void accountnotfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountnotfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountnotfActionPerformed

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
            java.util.logging.Logger.getLogger(CheckBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckBalance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountnotf;
    private javax.swing.JButton back;
    private javax.swing.JButton checkbalance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
