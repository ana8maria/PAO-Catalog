
package pao.gui;

import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;
import pao.entities.CourseType;
import pao.entities.Professor;
import pao.entities.SchoolClass;
import pao.table_data.TableCourseType;
import pao.table_data.TableSchoolClass;
import pao.table_data.TableSpecialization;


public class JFrameManagerProfesor extends javax.swing.JFrame {

    /**
     * Creates new form JFrameManagerProfesor
     */
    
    
      private Professor editItem;
     private boolean  isEdit=false;

    public Professor getEditItem() {
        return editItem;
    }
    
     public boolean getIsEdit() {
        return isEdit;
    }
    
    public JFrameManagerProfesor(Professor p) {
        initComponents();
        
        editItem=p;
        
        
           comboBoxSpecialization.setModel(new ComboBoxModel<String>() {
            
            Object curentSelect;
       
            TableCourseType tabel= TableCourseType.getInstance();
            
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
            comboBoxScoolClass.setModel(new ComboBoxModel<SchoolClass>() {
            
            Object curentSelect;
            
       
              TableSchoolClass tabel= TableSchoolClass.getInstance();
            
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
            public SchoolClass getElementAt(int index) {
               return  tabel.get(index);
            }

            @Override
            public void addListDataListener(ListDataListener l) {
               
            }

            @Override
            public void removeListDataListener(ListDataListener l) {
                 
            }
   });
        
        
        setControlProfesor();
    }
    
       private void setControlProfesor(){
        if(editItem==null){
            editItem= new Professor();
        }
        
       txtStudentName.setText(editItem.getName());

       txtStudentLastName.setText(editItem.getLastName());
        
       txtStudentCity.setText(editItem.getCity());
       
       comboBoxScoolClass.setSelectedItem(editItem.getSchoolClass());
       
       comboBoxSpecialization.setSelectedItem(editItem.getCourseType());
 
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
        jLabel4 = new javax.swing.JLabel();
        btnStudentSave = new javax.swing.JButton();
        btnStudentCancel = new javax.swing.JButton();
        comboBoxScoolClass = new javax.swing.JComboBox<>();
        txtStudentName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtStudentLastName = new javax.swing.JTextField();
        txtStudentCity = new javax.swing.JTextField();
        comboBoxSpecialization = new javax.swing.JComboBox<>();
        btnAddSpecializtion = new javax.swing.JButton();
        btnDeleteSpecializare = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Prenume");

        jLabel2.setText("Nume");

        jLabel4.setText("Oras");

        btnStudentSave.setText("Save");
        btnStudentSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentSaveActionPerformed(evt);
            }
        });

        btnStudentCancel.setText("Cancel");
        btnStudentCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentCancelActionPerformed(evt);
            }
        });

        jLabel5.setText("Clasa");

        txtStudentLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentLastNameActionPerformed(evt);
            }
        });

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

        jLabel6.setText("Materie");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnStudentSave)
                        .addGap(59, 59, 59)
                        .addComponent(btnStudentCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxScoolClass, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(0, 223, Short.MAX_VALUE))
                                        .addComponent(comboBoxSpecialization, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnAddSpecializtion)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnDeleteSpecializare))
                                .addComponent(jLabel5)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(txtStudentLastName)
                                .addComponent(txtStudentName, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
                            .addComponent(jLabel4)
                            .addComponent(txtStudentCity, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddSpecializtion)
                    .addComponent(btnDeleteSpecializare))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtStudentLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addComponent(comboBoxScoolClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStudentCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStudentSave)
                    .addComponent(btnStudentCancel))
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnStudentSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentSaveActionPerformed
        try{

            if(txtStudentName.getText().trim().length()==0){
                throw  new Exception("Adaugati numele complet");
            }

            if(txtStudentLastName.getText().trim().length()==0){
                throw  new Exception("Adaugati prenumele complet");
            }

            if(txtStudentCity.getText().trim().length()==0){
                throw  new Exception("Adaugati orasul complet");
            }

            if(comboBoxScoolClass.getSelectedIndex()==-1){
                throw  new Exception("Selectati o clasa");
            }
            
             if(comboBoxSpecialization.getSelectedIndex()==-1){
                throw  new Exception("Selectati o specializare");
            }

            editItem.setName(txtStudentName.getText().trim());
            editItem.setLastName(txtStudentLastName.getText().trim());
            editItem.setCity(txtStudentCity.getText().trim());

            editItem.setScoolClass((SchoolClass)comboBoxScoolClass.getSelectedItem());
            
            editItem.setCourseType(comboBoxSpecialization.getSelectedItem().toString());

            this.isEdit=true;
            this.dispose();

        }catch(Exception e){
            JOptionPane.showMessageDialog(this,  e.getMessage());
        }

    }//GEN-LAST:event_btnStudentSaveActionPerformed

    private void btnStudentCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentCancelActionPerformed
        this.isEdit=false;
        this.dispose();
    }//GEN-LAST:event_btnStudentCancelActionPerformed

    private void txtStudentLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentLastNameActionPerformed

    private void btnAddSpecializtionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSpecializtionActionPerformed

        String rez= JOptionPane.showInputDialog(this, "");

        if(rez!=null){

            TableCourseType t=TableCourseType.getInstance();

            if(!t.contains(rez)){

                t.add(new CourseType(rez));
                t.SaveChanges();

            }else{

                JOptionPane.showMessageDialog(this,   "Aceasta specializare exista deja");
            }

        }

    }//GEN-LAST:event_btnAddSpecializtionActionPerformed

    private void btnDeleteSpecializareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSpecializareActionPerformed

        int curentSelect=comboBoxSpecialization.getSelectedIndex();

        if(curentSelect!=-1){

            CourseType s=TableCourseType.getInstance().get(curentSelect);
            TableCourseType.getInstance().remove(s);
            if(comboBoxSpecialization.getItemCount()==0){
                comboBoxSpecialization.setSelectedIndex(-1);
            }else comboBoxScoolClass.setSelectedIndex(1);

            TableCourseType.getInstance().SaveChanges();

        }

    }//GEN-LAST:event_btnDeleteSpecializareActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSpecializtion;
    private javax.swing.JButton btnDeleteSpecializare;
    private javax.swing.JButton btnStudentCancel;
    private javax.swing.JButton btnStudentSave;
    private javax.swing.JComboBox<pao.entities.SchoolClass> comboBoxScoolClass;
    private javax.swing.JComboBox<String> comboBoxSpecialization;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtStudentCity;
    private javax.swing.JTextField txtStudentLastName;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
