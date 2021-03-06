
package empresa_combustible;

import java.util.Observable;
import java.util.Observer;

public class InterfazSucursal extends javax.swing.JFrame implements Observer{
    
    private Servidor servidor;
    private Sucursal sucursal;
    private Dialog_setIp_Sucursal dialog;
    private int puerto_server;
    private int puerto_cliente;
    private String nombreProductoActual;
    private Double factorActual;
    private String idSucursal = "SSAL";
    
    public InterfazSucursal() {
        setLocationRelativeTo(null);
        initComponents();
        this.setVisible(true);
        abrirDialog("Sucursal");
        puerto_server = Integer.parseInt(dialog.getPuerto_server());
        sucursal = new Sucursal(puerto_server, dialog.getDireccion_ip());
        puerto_cliente = Integer.parseInt(dialog.getPuerto_cliente());
        servidor = new Servidor(puerto_cliente);        
        sucursal.addObserver(this);
        idSucursal+=dialog.getIdKey();
        idSucursalField.setText(idSucursal);
        labelIPDataRecibe.setText(dialog.getDireccion_ip()+":"+dialog.getPuerto_server());
        labelIPDataEnvia.setText("localhost"+":"+dialog.getPuerto_cliente());
        Thread t = new Thread(sucursal);
        t.start();
        servidor.setIdServidor(idSucursal);
        Thread t2 = new Thread(servidor);
        t2.start();
        
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
        textFactor = new javax.swing.JTextField();
        setFactor = new javax.swing.JButton();
        tag97 = new javax.swing.JLabel();
        text97 = new javax.swing.JTextField();
        tag93 = new javax.swing.JLabel();
        text93 = new javax.swing.JTextField();
        tag95 = new javax.swing.JLabel();
        text95 = new javax.swing.JTextField();
        tag98 = new javax.swing.JLabel();
        textDiesel = new javax.swing.JTextField();
        tag99 = new javax.swing.JLabel();
        textKerosene = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idSucursalField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        labelIPDataRecibe = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelIPDataEnvia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sucursal");
        setResizable(false);

        jLabel1.setText("Factor Ajuste (%)");

        textFactor.setToolTipText("");

        setFactor.setText("Actualizar");
        setFactor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFactorActionPerformed(evt);
            }
        });

        tag97.setText("97");

        text97.setFocusable(false);
        text97.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text97ActionPerformed(evt);
            }
        });

        tag93.setText("93");

        text93.setFocusable(false);

        tag95.setText("95");

        text95.setFocusable(false);

        tag98.setText("Diesel");

        textDiesel.setFocusable(false);
        textDiesel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDieselActionPerformed(evt);
            }
        });

        tag99.setText("Kerosene");

        textKerosene.setFocusable(false);
        textKerosene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textKeroseneActionPerformed(evt);
            }
        });

        jLabel2.setText("Precios Live:");

        jLabel3.setText("ID Sucursal:");

        idSucursalField.setEditable(false);
        idSucursalField.setFocusable(false);
        idSucursalField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idSucursalFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Recibiendo Datos de:");

        labelIPDataRecibe.setText("IP");

        jLabel6.setText("Enviando Datos a:");

        labelIPDataEnvia.setText("IP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tag99)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textKerosene, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tag98)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textDiesel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(30, 30, 30)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(labelIPDataEnvia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelIPDataRecibe))
                                .addContainerGap(143, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(idSucursalField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tag93)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(text93, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(tag97)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(text97))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(tag95)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(text95, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(textFactor, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(11, 11, 11))
                                .addComponent(jLabel1))
                            .addComponent(setFactor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tag93)
                    .addComponent(text93, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tag95)
                    .addComponent(text95, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text97, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tag97))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tag98)
                    .addComponent(textDiesel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tag99)
                    .addComponent(textKerosene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFactor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setFactor)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIPDataRecibe)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labelIPDataEnvia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(idSucursalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setFactorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setFactorActionPerformed
        System.out.println("Boton Actualizar presionado..");
        this.factorActual = Double.parseDouble(this.textFactor.getText())/100;
        double noventatres = Double.parseDouble(text93.getText())*(1+factorActual);
        double noventacinco = Double.parseDouble(text95.getText())*(1+factorActual);
        double noventasiete = Double.parseDouble(text97.getText())*(1+factorActual);
        double diesel = Double.parseDouble(textDiesel.getText())*(1+factorActual);
        double kerosene = Double.parseDouble(textKerosene.getText())*(1+factorActual);  
        String[] nombres = {"93","95","97","diesel","kerosene"};
        
        double[] valores = {(double)Math.round(noventatres * 100d) / 100d,
            (double)Math.round(noventacinco * 100d) / 100d,
            (double)Math.round(noventasiete * 100d) / 100d,
            (double)Math.round(diesel * 100d) / 100d,
            (double)Math.round(kerosene * 100d) / 100d};
        servidor.enviarInfo(nombres, valores);
    }//GEN-LAST:event_setFactorActionPerformed

    private void text97ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text97ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text97ActionPerformed

    private void textDieselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDieselActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDieselActionPerformed

    private void textKeroseneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textKeroseneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textKeroseneActionPerformed

    private void idSucursalFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idSucursalFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idSucursalFieldActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazSucursal();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idSucursalField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel labelIPDataEnvia;
    private javax.swing.JLabel labelIPDataRecibe;
    private javax.swing.JButton setFactor;
    private javax.swing.JLabel tag93;
    private javax.swing.JLabel tag95;
    private javax.swing.JLabel tag97;
    private javax.swing.JLabel tag98;
    private javax.swing.JLabel tag99;
    private javax.swing.JTextField text93;
    private javax.swing.JTextField text95;
    private javax.swing.JTextField text97;
    private javax.swing.JTextField textDiesel;
    private javax.swing.JTextField textFactor;
    private javax.swing.JTextField textKerosene;
    // End of variables declaration//GEN-END:variables
    private void abrirDialog(String tipo){

        dialog = new Dialog_setIp_Sucursal(this, true, tipo);
        dialog.setLocationRelativeTo(null);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);        
    }
    
    @Override
    public void update(Observable arg0, Object arg1) {
        if (arg1 instanceof String) {
            nombreProductoActual = (String) arg1;
        }else{          
            double valor = (double) arg1;
            switch(nombreProductoActual){
                case "93":
                    this.text93.setText(valor+"");
                    break;         
                case "95":
                    this.text95.setText(valor+"");
                    break;
                case "97":
                    this.text97.setText(valor+"");
                    break;
                case "diesel":
                    this.textDiesel.setText(valor+"");
                    break;
                case "kerosene":
                    this.textKerosene.setText(valor+"");
                    break;
                 
            }          
        }
    }
}
