/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewer.window;

import javax.swing.JOptionPane;

import main.DatabaseHandler;
import main.Output;
import s_n.add.AddPerson;
import s_n.add.AddRelation;
import s_n.connection.Couple;
import s_n.connection.Family;
import s_n.connection.Relationship;
import viewer.MethodImp;

/**
 *
 * @author Leo
 */
public class Menu2_1 extends javax.swing.JFrame {

    int id;

    /**
     * Creates new form Menu2_1
     */
    public Menu2_1(int id) {
        this.id = id;

        initComponents();
        lb1.setText(AddPerson.per[id].getFname().trim());
        new MethodImp().init(this, lb1.getText().trim());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lb1.setText("Select a person");

        jButton1.setText("back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("List Profile");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete This");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(288, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton4)
                    .addComponent(lb1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(278, 278, 278))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lb1)
                .addGap(99, 99, 99)
                .addComponent(jButton2)
                .addGap(83, 83, 83)
                .addComponent(jButton4)
                .addGap(107, 107, 107)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Menu2().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (AddPerson.per[id].getChild() == false) {
            new Menue2_1_1_Adult(id).setVisible(true);
        } else {
            new Menue2_1_1_Child(id).setVisible(true);
        }

        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //warning
        int option = JOptionPane.showOptionDialog(null, "Are you sure to delete this person?", AddPerson.per[id].getFname().trim(), JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
        boolean can = true;//if can delete
        if (option == 0) {//if choose delete
            for (int t = 0; t < AddRelation.numre; t++) {
                if (AddRelation.re[t] instanceof Relationship) {//get all relationship we have
                    String ret = AddRelation.re[t].checkFriend(AddPerson.per[id].getFname());//find relationship he has
                    if (ret != null) {//if has relation

                        if (AddRelation.re[t] instanceof Couple) {//if it belong to Couple

                            Couple s = (Couple) AddRelation.re[t];

                            if (s.getChild() == null || s.getChild().isEmpty()) {//if don'has children
                                AddRelation.re[t] = null;
                            } else {//if has children

                                JOptionPane.showMessageDialog(this, "You can't delect a person with child", "Error", JOptionPane.ERROR_MESSAGE);

                                can = false;
                                continue;
                            }
                        }

                        AddRelation.re[t] = null;

                    } else {
                        if (AddRelation.re[t] instanceof Family) {
                            if (((Family) AddRelation.re[t]).getChild() == AddPerson.per[id].getFname()) {

                                ((Family) AddRelation.re[t]).deletChild();
                                AddRelation.re[t] = null;
                            }
                        }
                    }

                }
            }
            if (can) {
                AddPerson.per[id] = null;
                AddPerson.setList(id, null);
                if (Output.fileAccessPassed){
                	Output.outPeople(new Output().getFile());//output to txt
                	Output.outRelation(new Output().getFileRe());
                }
                else {
                	DatabaseHandler.writePeople();
                	DatabaseHandler.writeRelationship();
                }
                new Menu2().setVisible(true);
                this.dispose();
            }
    }//GEN-LAST:event_jButton4ActionPerformed
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel lb1;
    // End of variables declaration//GEN-END:variables
}
