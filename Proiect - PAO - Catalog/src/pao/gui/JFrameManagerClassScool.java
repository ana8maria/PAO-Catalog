
package pao.gui;

import java.time.LocalDateTime;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;
import pao.entities.SchoolClass;
import pao.entities.Specialization;
import pao.table_data.TableSpecialization;

public class JFrameManagerClassScool extends javax.swing.JFrame {

    /**
     * Creates new form JFrameManagerClassScool
     */
    
     private SchoolClass editItem;
     
     private boolean  isEdit=false;

    public SchoolClass getEditItem() {
        return editItem;
    }
    
     public boolean getIsEdit() {
        return isEdit;
    }
     
     
     
    public JFrameManagerClassScool( SchoolClass editItem) {
        initComponents();
        
        this.setResizable(false);
        this.editItem=editItem;
        
        comboBoxSpecialization.setModel(new ComboBoxModel<String>() {
            
            Object curentSelect;
       
            TableSpecialization tabel= TableSpecialization.getInstance();
            
           @Override
            public void setSelectedItem(Object anItem) {
               curentSelect=anItem;
            }

            @Override
            public Object getSelectedItem() {
              return curentSelect;
            }

            @Override
            public int getSize() {
               return  tabel.size();
            }

            @Override
            public String getElementAt(int index) {
               return  tabel.get(index).toString();
            }

            @Override
            public void addListDataListener(ListDataListener l) {
               
            }

            @Override
            public void removeListDataListener(ListDataListener l) {
                 
            }
   });
   
       setControlScoolClass();
        
    }
    
    
    private void setControlScoolClass(){
        if(editItem==null){
            editItem= new SchoolClass();
        }
        
        
        comboBoxSpecialization.setSelectedItem(editItem.getSpecialization());
        
        comboBoxIndicator.setSelectedItem(editItem.getIndicator());
        
        textYearFounding.setText(editItem.getClasa()+"");
        
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
        comboBoxSpecialization = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        textYearFounding = new javax.swing.JTextField();
        comboBoxIndicator = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnAddSpecializtion = new javax.swing.JButton();
        btnDeleteSpecializare = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Profil");

        comboBoxSpecialization.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Clasa");

        comboBoxIndicator.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" }));
        comboBoxIndicator.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setText("Indicator");

        btnAddSpecializtion.setText("Adauga");
        btnAddSpecializtion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSpecializtionActionPerformed(evt);
            }
        });

        btnDeleteSpecializare.setText("Sterge");
        btnDeleteSpecializare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSpecializareActionPerformed(evt);
            }
        });

        btnSave.setText("Salveaza");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Anuleaza");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addGap(38, 38, 38)
                                .addComponent(btnCancel))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxSpecialization, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textYearFounding, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxIndicator, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnAddSpecializtion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteSpecializare)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddSpecializtion)
                    .addComponent(btnDeleteSpecializare))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textYearFounding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addGap(39, 39, 39))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSpecializtionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSpecializtionActionPerformed
     
        
        String rez= JOptionPane.showInputDialog(this, "");
     
        if(rez!=null){
            
            TableSpecialization t=TableSpecialization.getInstance();
            
             if(!t.contains(rez)){
                 
                 t.add(new Specialization(rez));
                 t.SaveChanges();
                 
             }else{
                 
                 JOptionPane.showMessageDialog(this,   "Aceasta specializare exista deja");
             }
             
            
        }

    }//GEN-LAST:event_btnAddSpecializtionActionPerformed

    private void btnDeleteSpecializareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSpecializareActionPerformed
     
        
        int curentSelect=comboBoxSpecialization.getSelectedIndex();
        
        if(curentSelect!=-1){
            
              Specialization s=TableSpecialization.getInstance().get(curentSelect);
              TableSpecialization.getInstance().remove(s);
              if(comboBoxSpecialization.getItemCount()==0){
                  comboBoxSpecialization.setSelectedIndex(-1);
              }else comboBoxSpecialization.setSelectedIndex(1);
              
              TableSpecialization.getInstance().SaveChanges();
              
        }
      
        
        
    }//GEN-LAST:event_btnDeleteSpecializareActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       
         try{
        
        if(comboBoxIndicator.getSelectedIndex()==-1){
             throw  new Exception(" Selecteaza te rog un indicator");
        }    
        
        
         if(comboBoxSpecialization.getSelectedIndex()==-1){
            throw  new Exception(" Selecteaza te rog o specialitate");
         }
         

             int rez= Integer.parseInt(textYearFounding.getText());
             
             if(rez<5) throw new Exception("Clasa incorecta");
             
             
             LocalDateTime  d = LocalDateTime.now();  
             if(rez>d.getYear()) throw new Exception("Anul trebuie sa fie mai mic decat "+d.getYear());
             
             
                editItem.setSpecialization(comboBoxSpecialization.getSelectedItem().toString());
        
                editItem.setIndicator(comboBoxIndicator.getSelectedItem().toString());

                editItem.setClasa(rez);

                isEdit=true;
                this.dispose();
             
         }catch(Exception e){
             
              JOptionPane.showMessageDialog(this,  e.getMessage());
         }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
         isEdit=false;
         this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSpecializtion;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeleteSpecializare;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comboBoxIndicator;
    private javax.swing.JComboBox<String> comboBoxSpecialization;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField textYearFounding;
    // End of variables declaration//GEN-END:variables

  
}
