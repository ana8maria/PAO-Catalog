
package pao.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import pao.entities.Professor;
import pao.entities.SchoolClass;
import pao.entities.Student;
import pao.table_data.TableProfesor;
import pao.table_data.TableSchoolClass;
import pao.table_data.TableStudents;

public class JFrmaeManagerLists extends javax.swing.JFrame {

    JFrame thisParinte=this;

    /**
     * Creates new form JFrmaeStudentsList
     */
    public JFrmaeManagerLists() {
        initComponents();
        
         this.setResizable(false);

       repaint();
    
    }

    @Override
    public void repaint() {
         
           listScoolClass.setModel(new AbstractListModel<SchoolClass>() {
           
           TableSchoolClass tableSchoolClass= TableSchoolClass.getInstance();
           
           
            @Override
            public int getSize() {
              return tableSchoolClass.size();
            }

            @Override
            public SchoolClass getElementAt(int index) {
               return tableSchoolClass.get(index);
            }
       });
           
           
           listStudent.setModel(new AbstractListModel<Student>() {
           
           TableStudents tableStudent= TableStudents.getInstance();
           
           
            @Override
            public int getSize() {
              return tableStudent.size();
            }

            @Override
            public Student getElementAt(int index) {
               return tableStudent.get(index);
            }
       });
           
           
            listProfesor.setModel(new AbstractListModel<Professor>() {
           
             TableProfesor tableStudent= TableProfesor.getInstance();
           
           
             @Override
             public int getSize() {
                  return tableStudent.size();
            }

            @Override
            public Professor getElementAt(int index) {
               return tableStudent.get(index);
            }
       });
           
           super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }

    
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabMain = new javax.swing.JTabbedPane();
        ScoolClassTabs = new javax.swing.JPanel();
        btnScoolClassDelete = new java.awt.Button();
        btnScoolClassEdit = new java.awt.Button();
        btnScoolClassAdd = new java.awt.Button();
        jScrollPane4 = new javax.swing.JScrollPane();
        listScoolClass = new javax.swing.JList<>();
        StudentsTabs = new javax.swing.JPanel();
        btnStundetAdd = new java.awt.Button();
        btnStudentEdit = new java.awt.Button();
        btnStudentDelete = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        listStudent = new javax.swing.JList<>();
        ProfessorsTabs = new javax.swing.JPanel();
        btnProfesorDelete = new java.awt.Button();
        btnProfesorEdit = new java.awt.Button();
        btnProfesorAdd = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        listProfesor = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnScoolClassDelete.setLabel("Delete");
        btnScoolClassDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScoolClassDeleteActionPerformed(evt);
            }
        });

        btnScoolClassEdit.setLabel("Edit");
        btnScoolClassEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScoolClassEditActionPerformed(evt);
            }
        });

        btnScoolClassAdd.setActionCommand("Add");
        btnScoolClassAdd.setLabel("Add");
        btnScoolClassAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnScoolClassAddMouseClicked(evt);
            }
        });
        btnScoolClassAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScoolClassAddActionPerformed(evt);
            }
        });

        listScoolClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listScoolClassMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(listScoolClass);

        javax.swing.GroupLayout ScoolClassTabsLayout = new javax.swing.GroupLayout(ScoolClassTabs);
        ScoolClassTabs.setLayout(ScoolClassTabsLayout);
        ScoolClassTabsLayout.setHorizontalGroup(
            ScoolClassTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScoolClassTabsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ScoolClassTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnScoolClassEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnScoolClassDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnScoolClassAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        ScoolClassTabsLayout.setVerticalGroup(
            ScoolClassTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScoolClassTabsLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnScoolClassAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnScoolClassEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnScoolClassDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(452, Short.MAX_VALUE))
            .addComponent(jScrollPane4)
        );

        TabMain.addTab("Clase", ScoolClassTabs);

        btnStundetAdd.setActionCommand("Add");
        btnStundetAdd.setLabel("Add");
        btnStundetAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStundetAddActionPerformed(evt);
            }
        });

        btnStudentEdit.setLabel("Edit");
        btnStudentEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentEditActionPerformed(evt);
            }
        });

        btnStudentDelete.setLabel("Delete");
        btnStudentDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentDeleteActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listStudent);

        javax.swing.GroupLayout StudentsTabsLayout = new javax.swing.GroupLayout(StudentsTabs);
        StudentsTabs.setLayout(StudentsTabsLayout);
        StudentsTabsLayout.setHorizontalGroup(
            StudentsTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentsTabsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StudentsTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnStudentEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStudentDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStundetAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        StudentsTabsLayout.setVerticalGroup(
            StudentsTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentsTabsLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnStundetAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStudentEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStudentDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(452, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );

        TabMain.addTab("Elevi", StudentsTabs);

        btnProfesorDelete.setLabel("Delete");
        btnProfesorDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfesorDeleteActionPerformed(evt);
            }
        });

        btnProfesorEdit.setLabel("Edit");
        btnProfesorEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfesorEditActionPerformed(evt);
            }
        });

        btnProfesorAdd.setActionCommand("Add");
        btnProfesorAdd.setLabel("Add");
        btnProfesorAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfesorAddActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listProfesor);

        javax.swing.GroupLayout ProfessorsTabsLayout = new javax.swing.GroupLayout(ProfessorsTabs);
        ProfessorsTabs.setLayout(ProfessorsTabsLayout);
        ProfessorsTabsLayout.setHorizontalGroup(
            ProfessorsTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfessorsTabsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProfessorsTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnProfesorEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProfesorDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProfesorAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        ProfessorsTabsLayout.setVerticalGroup(
            ProfessorsTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfessorsTabsLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnProfesorAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProfesorEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProfesorDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(452, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );

        TabMain.addTab("Profesori", ProfessorsTabs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(TabMain, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(TabMain, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnScoolClassAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnScoolClassAddMouseClicked
       
       
        
        showEditSchoolClass(null);
        
    }//GEN-LAST:event_btnScoolClassAddMouseClicked

    private void btnScoolClassEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScoolClassEditActionPerformed
       
        
        if(listScoolClass.getSelectedIndex()!=-1){
            showEditSchoolClass(listScoolClass.getSelectedValue());
             
        }
        
    }//GEN-LAST:event_btnScoolClassEditActionPerformed

    private void btnScoolClassDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScoolClassDeleteActionPerformed
      
        
        if(listScoolClass.getSelectedIndex()!=-1){
            
            TableSchoolClass.getInstance().remove(listScoolClass.getSelectedValue());
            TableSchoolClass.getInstance().SaveChanges();
            
            this.repaint();
        }

    }//GEN-LAST:event_btnScoolClassDeleteActionPerformed

    private void btnStundetAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStundetAddActionPerformed
     
        showEditStudentClass(null);
    }//GEN-LAST:event_btnStundetAddActionPerformed

    private void btnStudentEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentEditActionPerformed
      
        if(listStudent.getSelectedIndex()!=-1){
             showEditStudentClass(listStudent.getSelectedValue());
             
        }
       
    }//GEN-LAST:event_btnStudentEditActionPerformed

    private void btnStudentDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentDeleteActionPerformed
        if(listStudent.getSelectedIndex()!=-1){
           Student st=  listStudent.getSelectedValue();
           TableStudents.getInstance().remove(st);
           TableStudents.getInstance().SaveChanges();
           this.repaint();
             
        }
    }//GEN-LAST:event_btnStudentDeleteActionPerformed

    private void btnProfesorAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfesorAddActionPerformed
       showEditProfessorClass(null);
       
    }//GEN-LAST:event_btnProfesorAddActionPerformed

    private void btnProfesorEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfesorEditActionPerformed
       
        
        if(listProfesor.getSelectedIndex()!=-1){
             showEditProfessorClass(listProfesor.getSelectedValue());
             
        }
        
       
    }//GEN-LAST:event_btnProfesorEditActionPerformed

    private void btnProfesorDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfesorDeleteActionPerformed
        if(listProfesor.getSelectedIndex()!=-1){
           Professor st=  listProfesor.getSelectedValue();
           TableProfesor.getInstance().remove(st);
           TableProfesor.getInstance().SaveChanges();
           this.repaint();
             
        }
    }//GEN-LAST:event_btnProfesorDeleteActionPerformed

    private void btnScoolClassAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScoolClassAddActionPerformed
     showEditSchoolClass(null);
    }//GEN-LAST:event_btnScoolClassAddActionPerformed

    private void listScoolClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listScoolClassMouseClicked
     
    }//GEN-LAST:event_listScoolClassMouseClicked

     public void  showEditProfessorClass(Professor sc){
         thisParinte.setVisible(false);
      
        
         JFrameManagerProfesor jFrameManagerClassScool= new JFrameManagerProfesor(sc);
         
        jFrameManagerClassScool.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
       
        jFrameManagerClassScool.setAlwaysOnTop(true);
        jFrameManagerClassScool.show();

        jFrameManagerClassScool.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               thisParinte.setVisible(true);
                 thisParinte.repaint();
               
               
            }

             @Override
             public void windowDeactivated(WindowEvent e) {
                 thisParinte.setVisible(true);
                 
                 if(jFrameManagerClassScool.getIsEdit()){
                     
                     Professor aux =jFrameManagerClassScool.getEditItem();
                    
                     TableProfesor.getInstance().AddOrEdit(aux);
                     
                    TableProfesor.getInstance().SaveChanges();
                     
                 }
                 
                   thisParinte.repaint();
                 
             }
            
            
        });
         
    }
    
    
      public void  showEditStudentClass(Student sc){
         thisParinte.setVisible(false);
      
        
         JFrameManagerStudent jFrameManagerClassScool= new JFrameManagerStudent(sc);
         
        jFrameManagerClassScool.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
       
        jFrameManagerClassScool.setAlwaysOnTop(true);
        jFrameManagerClassScool.show();

        jFrameManagerClassScool.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               thisParinte.setVisible(true);
                 thisParinte.repaint();
               
               
            }

             @Override
             public void windowDeactivated(WindowEvent e) {
                 thisParinte.setVisible(true);
                 
                 if(jFrameManagerClassScool.getIsEdit()){
                     
                     Student aux =jFrameManagerClassScool.getEditItem();
                    
                     TableStudents.getInstance().AddOrEdit(aux);
                     
                    TableStudents.getInstance().SaveChanges();
                     
                 }
                 
                   thisParinte.repaint();
                 
             }
            
            
        });
         
    }
    
    
    public void  showEditSchoolClass(SchoolClass sc){
         thisParinte.setVisible(false);
      
        
         JFrameManagerClassScool jFrameManagerClassScool= new JFrameManagerClassScool(sc);
         
        jFrameManagerClassScool.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
       
        jFrameManagerClassScool.setAlwaysOnTop(true);
        jFrameManagerClassScool.show();

        jFrameManagerClassScool.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               thisParinte.setVisible(true);
                 thisParinte.repaint();
               
               
            }

             @Override
             public void windowDeactivated(WindowEvent e) {
                 thisParinte.setVisible(true);
                 
                 if(jFrameManagerClassScool.getIsEdit()){
                     
                     SchoolClass aux =jFrameManagerClassScool.getEditItem();
                    
                     TableSchoolClass.getInstance().AddOrEdit(aux);
                     
                    TableSchoolClass.getInstance().SaveChanges();
                     
                 }
                 
                   thisParinte.repaint();
                 
             }
            
            
        });
         
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ProfessorsTabs;
    private javax.swing.JPanel ScoolClassTabs;
    private javax.swing.JPanel StudentsTabs;
    private javax.swing.JTabbedPane TabMain;
    private java.awt.Button btnProfesorAdd;
    private java.awt.Button btnProfesorDelete;
    private java.awt.Button btnProfesorEdit;
    private java.awt.Button btnScoolClassAdd;
    private java.awt.Button btnScoolClassDelete;
    private java.awt.Button btnScoolClassEdit;
    private java.awt.Button btnStudentDelete;
    private java.awt.Button btnStudentEdit;
    private java.awt.Button btnStundetAdd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<Professor> listProfesor;
    private javax.swing.JList<pao.entities.SchoolClass> listScoolClass;
    private javax.swing.JList<Student> listStudent;
    // End of variables declaration//GEN-END:variables
}
