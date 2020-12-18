/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa_combustible;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;


/**
 *
 * @author mrroj
 */
public class InterfazCargar extends javax.swing.JFrame {

    /**
     * Creates new form InterfazCargar
     */
    
    double precioCombustible;
    double precioCalculado;
    double litros;
    double litrosCargados;
    String combustible;
    String idSurtidor;
    String idSucursal;
    Report_File reporte = new Report_File();
    
    public InterfazCargar(String combustible, double precioActual, String idSurtidor, String idSucursal) {
        setResizable(false);
        setTitle("Estación de Cargado");
        setLocationRelativeTo(null);
        initComponents();
        this.idSurtidor=idSurtidor;
        this.idSucursal=idSucursal;
        cargandoLabel.setVisible(false);
        precioField.setText(String.valueOf(precioActual));
        precioCombustible=precioActual;
        this.combustible=combustible;
        combustibleLabel.setText(combustible);
    }

    public Report_File getReporte() {
        return reporte;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cargandoBarra = new javax.swing.JProgressBar();
        cargarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        precioLabel = new javax.swing.JLabel();
        precioField = new javax.swing.JTextField();
        litrosLabel = new javax.swing.JLabel();
        litrosField = new javax.swing.JTextField();
        cargandoLabel = new javax.swing.JLabel();
        mainTextLabel = new javax.swing.JLabel();
        combustibleLabel = new javax.swing.JLabel();
        finalPriceLabel = new javax.swing.JLabel();
        finalPriceField = new javax.swing.JTextField();
        updateFinalPriceButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cargarButton.setText("Cargar Combustible");
        cargarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        precioLabel.setText("Precio Combustible:");

        precioField.setEditable(false);
        precioField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioFieldActionPerformed(evt);
            }
        });

        litrosLabel.setText("Litros a Cargar:");

        cargandoLabel.setText("Cargando...");

        mainTextLabel.setText("Realizar carga de");

        combustibleLabel.setText("<Combustible>");

        finalPriceLabel.setText("Precio Final:");

        finalPriceField.setEditable(false);
        finalPriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPriceFieldActionPerformed(evt);
            }
        });

        updateFinalPriceButton.setText("Actualizar");
        updateFinalPriceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateFinalPriceButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelarButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cargarButton))
                            .addComponent(cargandoBarra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(mainTextLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combustibleLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(cargandoLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(litrosLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(precioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(litrosField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precioField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(finalPriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(37, 37, 37)
                        .addComponent(finalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(updateFinalPriceButton)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combustibleLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precioLabel)
                    .addComponent(precioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(litrosLabel)
                    .addComponent(litrosField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalPriceLabel)
                    .addComponent(finalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateFinalPriceButton))
                .addGap(36, 36, 36)
                .addComponent(cargandoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cargandoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarButton)
                    .addComponent(cargarButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarButtonActionPerformed
        // TODO add your handling code here:
        cargarButton.setVisible(false);
        cancelarButton.setVisible(false);
        cargandoLabel.setVisible(true);
        BarraCargando barra = new BarraCargando();
        barra.setBar(cargandoBarra);
        Thread hilo = new Thread(barra);
        hilo.start();
    }//GEN-LAST:event_cargarButtonActionPerformed

    private void precioFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioFieldActionPerformed

    private void finalPriceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPriceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalPriceFieldActionPerformed

    private void updateFinalPriceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateFinalPriceButtonActionPerformed
        // TODO add your handling code here:
        
        litros = Double.valueOf(litrosField.getText());
        precioCalculado =(double)Math.round(precioCombustible*litros * 100d) / 100d ;    
        finalPriceField.setText(String.valueOf(precioCalculado));
       
    }//GEN-LAST:event_updateFinalPriceButtonActionPerformed
    
    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    public int getRandom(int max){
       // return (int) (Math.random()*max);  //incorrect always return zero
        return (int) (Math.random()*max);
    }   
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
            java.util.logging.Logger.getLogger(InterfazCargar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazCargar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazCargar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazCargar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazCargar("Test", 2.5,"TEST", "SSAL01").setVisible(true);
            }
        });
    }
    

    
    class BarraCargando implements Runnable {
    JProgressBar bar;
    
    int num_bar = 1;
    
    
    
    
    
    @Override
    @SuppressWarnings("null")
    public void run() {
        int random1 = getRandom(10);
        int random2 = -1;
        int progressBarFinal = 100;
        
        if (random1>6) {
            random2 = getRandom(99);
            litrosCargados = litros*(random2*0.01);
            progressBarFinal = random2;
        }
        
        else {
            litrosCargados = litros;
        }
        
        
        for (int i = 1; i <= progressBarFinal; i++)
        {   
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(InterfazCargar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

            this.getBar().setValue(i);
            
            if (this.getBar().getValue() == random2) {
                //JOptionPane.showMessageDialog("Ha terminado el Jbar No: "+num_bar);
                JOptionPane.showMessageDialog(rootPane, "No ha alcanzado el combustible\nSe han cargado "+litrosCargados+" litros de un total de "+litros+" litros.");
                crearReporte();
                dispose();
            }
            
            else if (this.getBar().getValue() == 100) {
                //JOptionPane.showMessageDialog("Ha terminado el Jbar No: "+num_bar);
                JOptionPane.showMessageDialog(rootPane, "Combustible cargado exitosamente");
                crearReporte();
                dispose();
            }
            
            
        }        
        num_bar++;
    }
    
    private void crearReporte(){
        reporte.setCombustible(combustible);
        reporte.setEstadoCarga("Completado");
        reporte.setIdSucursal(idSucursal);
        reporte.setIdSurtidor(idSurtidor);
        reporte.setLitrosSolicitados(litros);
        reporte.setLitrosVendidos(litrosCargados);
        reporte.setPrecioLitro(precioCalculado);
        reporte.setPrecioVenta(precioCalculado);
    }
    
    

    public void setBar(JProgressBar bar) {
        this.bar = bar;
    }
    
    public JProgressBar getBar() {
        return bar;
    }
    
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarButton;
    private javax.swing.JProgressBar cargandoBarra;
    private javax.swing.JLabel cargandoLabel;
    private javax.swing.JButton cargarButton;
    private javax.swing.JLabel combustibleLabel;
    private javax.swing.JTextField finalPriceField;
    private javax.swing.JLabel finalPriceLabel;
    private javax.swing.JTextField litrosField;
    private javax.swing.JLabel litrosLabel;
    private javax.swing.JLabel mainTextLabel;
    private javax.swing.JTextField precioField;
    private javax.swing.JLabel precioLabel;
    private javax.swing.JButton updateFinalPriceButton;
    // End of variables declaration//GEN-END:variables
}
