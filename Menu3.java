/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewer.window;

import javax.swing.JOptionPane;
import s_n.add.AddPerson;
import s_n.add.AddRelation;
import s_n.connection.Couple;
import s_n.connection.Family;
import s_n.method.LookUp;
import s_n.connection.Relationship;
import viewer.MethodImp;

/**
 *
 * @author Leo
 */
public class Menu3 extends javax.swing.JFrame {

    /**
     * Creates new form Menu3
     */
    public Menu3() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lb1.setText("Find Parents or Children");

        jLabel1.setText("First Name:");

        jButton1.setText("Find");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(60, 60, 60)
                                .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addGap(223, 223, 223))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(133, 133, 133))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new MethodImp().goM(this);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
        if(new MethodImp().checkStr(fname.getText().trim())){
        String fname = this.fname.getText().trim();
        int id=-1;
        try{
         id = new LookUp().lookUp(fname);
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(this, "Without this person");
            return;
        }
        if(id==-1){
            return;
        }
        if (AddPerson.per[id].getChild() == false) {
            String boy="";
            String girl="";
            String children = "";
            String couple = null;
            for (int i = 0; i < AddRelation.numre; i++) {
                if (AddRelation.re[i] instanceof Couple) {

                    String check = AddRelation.re[i].family(AddPerson.per[id].getFname());

                   
                    if (check != null) {
                        children = children + check;
                        couple=AddRelation.re[i].checkFriend(fname);

                    }
                }
            }
            
            
            String p[];
            p = children.trim().split(",");
            
            for(int i=0;i<p.length;i++){
                if(p[i].startsWith("1")){
                    boy=boy+p[i].substring(1)+" ";
                }
                if(p[i].startsWith("0")){
                    girl=girl+p[i].substring(1)+" ";
                }
                
                
            }
                     
              new Menu3_1_Parent(fname,couple,boy,girl).setVisible(true);
              this.dispose();
        } else {
            String parent = null;
            for (int i = 0; i < AddRelation.numre; i++) {
                if (AddRelation.re[i] instanceof Relationship) {
                    String check = AddRelation.re[i].family(AddPerson.per[id].getFname());
                    if (check != null) {
                        parent = check;
                    }
                }
            }

            String p[];
         
            p = parent.split(",");

            String father = p[0];
            String mother = p[1];

            new Menu3_1_Child(father, mother, fname).setVisible(true);
            this.dispose();
        }}else{JOptionPane.showMessageDialog(this, "Error input");}

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb1;
    // End of variables declaration//GEN-END:variables
}
