package com.stockControl.components;

import com.stockControl.controller.ProductsController;
import com.stockControl.models.Product;
import com.stockControl.utils.ObserverUtils.Subject;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Formp extends javax.swing.JPanel{

        public Formp() {
                initComponents();
                setOpaque(false);
                setBackground(new Color(0, 0, 0, 0));

        }

     
        private void initComponents() {

                nameField = new javax.swing.JTextField();
                jScrollPane1 = new javax.swing.JScrollPane();
                descriptionField = new javax.swing.JTextArea();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                stockInp = new javax.swing.JSpinner();
                resetBtn = new javax.swing.JButton();
                saveBtn = new javax.swing.JButton();

                nameField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 3, 3, 1));
                nameField.setPreferredSize(new java.awt.Dimension(50, 23));
               
                descriptionField.setColumns(20);
                descriptionField.setRows(5);
                jScrollPane1.setViewportView(descriptionField);

                jLabel1.setFont(new java.awt.Font("Noto Sans Mono Medium", 0, 14)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(255, 255, 255));
                jLabel1.setText("Product Name");

                jLabel2.setFont(new java.awt.Font("Noto Sans Mono Medium", 0, 14)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(255, 255, 255));
                jLabel2.setText("Description");

                jLabel3.setFont(new java.awt.Font("Noto Sans Mono Medium", 0, 14)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                jLabel3.setText("Stock");

                resetBtn.setBackground(new java.awt.Color(242, 242, 242));
                resetBtn.setFont(new java.awt.Font("Noto Sans Mono Medium", 1, 14)); // NOI18N
                resetBtn.setForeground(new java.awt.Color(51, 51, 51));
                resetBtn.setText("reset");
                resetBtn.setBorder(null);
                resetBtn.setBorderPainted(false);

                saveBtn.setBackground(new java.awt.Color(29, 53, 87));
                saveBtn.setFont(new java.awt.Font("Noto Sans Mono Medium", 1, 14)); // NOI18N
                saveBtn.setForeground(new java.awt.Color(255, 255, 255));
                saveBtn.setText("save");
                saveBtn.setBorder(null);
                saveBtn.setBorderPainted(false);
                saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                saveBtnMouseClicked(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(23, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(jLabel1)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel3)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(stockInp,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                76,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(jScrollPane1)
                                                                                .addComponent(nameField,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(resetBtn,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(saveBtn,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(23, 23, 23)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addGap(29, 29, 29)
                                                                .addComponent(jLabel1)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(nameField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel2)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(stockInp,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(28, 28, 28)
                                                                .addComponent(resetBtn,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(saveBtn,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(14, Short.MAX_VALUE)));
        }

       

        private void saveBtnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_saveBtnMouseClicked
                String nameProduct = nameField.getText();
                int valueSpinner = (Integer) stockInp.getValue();
                String description = descriptionField.getText();
                Product product = new Product();
                product.setName(nameProduct);
                product.setDescription(description);
                product.setStock(valueSpinner);
                try {
                        if(nameProduct.length()<1){
                                throw new Exception("please,name valid");
                        }
                        if(valueSpinner<1){
                                throw new Exception("please,input a stock number valid");
                        }
                        if(description.length()<5){
                                throw new Exception("please,a god description help understend this product");
                        }
                        ProductsController.saveOneProduct(product);
                        Alert.alertMessage(saveBtn.getParent().getParent().getParent(), "save successfully", "info", 1);
                        Subject.getInstance().notifyAction();
                } catch (Exception ex) {
                        Logger.getLogger(Formp.class.getName()).log(Level.SEVERE, null, ex);
                        Alert.alertMessage(saveBtn.getParent().getParent().getParent(), ex.getMessage(), "error", 0);
                }finally{
                    cleanForm();
                }
                

        }

        private void cleanForm(){
            nameField.setText("");
            descriptionField.setText("");
            stockInp.setValue(0);
        }                    
        private javax.swing.JTextArea descriptionField;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTextField nameField;
        private javax.swing.JButton resetBtn;
        private javax.swing.JButton saveBtn;
        private javax.swing.JSpinner stockInp;

}
