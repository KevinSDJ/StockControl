
package com.stockControl.views;

import com.stockControl.components.Alert;
import com.stockControl.controller.ProductsController;
import com.stockControl.models.Product;
import com.stockControl.utils.ObserverUtils.Observer;
import com.stockControl.utils.ObserverUtils.Subject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class ProductsSection extends javax.swing.JPanel implements Observer {
   

    public ProductsSection() {
        initComponents();
        loadTable();
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        id = new javax.swing.JTable();
        stockOptionsTool = new javax.swing.JToolBar();
        deleteBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Noto Sans Mono Medium", 1, 14)); // NOI18N
        jLabel1.setText("Products in Store");

        id.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        id.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        id.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Product Name", "Description", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        id.setSelectionBackground(new java.awt.Color(29, 53, 87));
        id.setSelectionForeground(new java.awt.Color(255,255,255));
        jScrollPane1.setViewportView(id);

        stockOptionsTool.setRollover(true);

        deleteBtn.setFont(new java.awt.Font("Noto Sans Mono Medium", 0, 14)); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 10, 4, 10));
        deleteBtn.setBorderPainted(false);
        deleteBtn.setFocusable(false);
        deleteBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        /* Delete action Event */
        deleteBtn.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if(id.getSelectedRow()<0){
                    Alert.alertMessage(jLabel1.getParent().getParent(),"item not selected","warning",2);
                    return;
                }
                deleteItem(String.valueOf(id.getModel().getValueAt(id.getSelectedRow(), 0)));
                
            }
        });
        stockOptionsTool.add(deleteBtn);

        editBtn.setFont(new java.awt.Font("Noto Sans Mono Medium", 0, 14)); // NOI18N
        editBtn.setText("Edit");
        editBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 10, 4, 10));
        editBtn.setBorderPainted(false);
        editBtn.setFocusable(false);
        editBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        
        stockOptionsTool.add(editBtn);

        jButton3.setFont(new java.awt.Font("Noto Sans Mono Medium", 0, 14)); // NOI18N
        jButton3.setText("");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 10, 4, 10));
        jButton3.setBorderPainted(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        stockOptionsTool.add(jButton3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(stockOptionsTool, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stockOptionsTool, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2d =(Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(new Color(0,0,0,0));
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintChildren(g); 
    }
    private void loadTable(){
        List<Product> products = ProductsController.listAllProducts();
        DefaultTableModel model= (DefaultTableModel) id.getModel();
        for(Product product:products){
            model.addRow(new Object[]{product.getCode(),product.getName(),product.getDescription(),product.getStock()});
        }
    }
   
    private void refresh(){
        DefaultTableModel model= (DefaultTableModel) id.getModel();
        model.setRowCount(0);
        loadTable();
    }

    @Override
    public void update() {
        refresh();
    }

    private void deleteItem(String code) {
        try {
            ProductsController.deleteOneProduct(code);
            Alert.alertMessage(this.getParent(), "item deleted", "info", 1);
            Subject.getInstance().notifyAction();
        } catch (Exception e) {
            Alert.alertMessage(this.getParent(), e.getMessage(), "error", 0);
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable id;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar stockOptionsTool;
    // End of variables declaration//GEN-END:variable
    
}
