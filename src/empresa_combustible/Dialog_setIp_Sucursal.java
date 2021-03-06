package empresa_combustible;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Camilo
 */
public class Dialog_setIp_Sucursal extends javax.swing.JDialog {
    
    private String direccion_ip;
    private String puerto_server;
    private String puerto_cliente;
    private String idKey;  
    /**
     * Creates new form Dialog_setIP_Sucursal
     */
    public Dialog_setIp_Sucursal(java.awt.Frame parent, boolean modal, String tipo) {
        super(parent, modal);
        initComponents();
        labelType.setText(tipo);
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
        text_puerto_server = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idKeyField = new javax.swing.JTextField();
        labelType = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        text_IP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        text_puerto_cliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Ingrese la direccion IP y Puerto de Servidor");

        text_puerto_server.setText("5000");
        text_puerto_server.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_puerto_serverActionPerformed(evt);
            }
        });

        jLabel3.setText("Puerto:");

        jLabel4.setText("Ingrese Identificador de");

        idKeyField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idKeyField.setText("001");
        idKeyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idKeyFieldActionPerformed(evt);
            }
        });

        labelType.setText("TIPO");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        text_IP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_IP.setText("localhost");
        text_IP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_IPActionPerformed(evt);
            }
        });

        jLabel2.setText("Ingrese puerto de conexion para Clientes:");

        jLabel5.setText("Puerto:");

        text_puerto_cliente.setText("5001");
        text_puerto_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_puerto_clienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(text_IP, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_puerto_server, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(idKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelType))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_puerto_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_IP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(text_puerto_server, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(text_puerto_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void text_puerto_serverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_puerto_serverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_puerto_serverActionPerformed

    private void idKeyFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idKeyFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idKeyFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.direccion_ip = text_IP.getText();
        this.puerto_cliente = text_puerto_cliente.getText();
        this.puerto_server = text_puerto_server.getText();
        this.idKey = idKeyField.getText();
        System.out.println("direccion ip seteada: "+direccion_ip);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void text_IPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_IPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_IPActionPerformed

    private void text_puerto_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_puerto_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_puerto_clienteActionPerformed
    
    /**
     * @param args the command line arguments
     */

    public String getDireccion_ip() {
        return direccion_ip;
    }

    public void setDireccion_ip(String direccion_ip) {
        this.direccion_ip = direccion_ip;
    }

    public String getPuerto_server() {
        return puerto_server;
    }

    public void setPuerto_server(String puerto_server) {
        this.puerto_server = puerto_server;
    }

    public String getPuerto_cliente() {
        return puerto_cliente;
    }

    public void setPuerto_cliente(String puerto_cliente) {
        this.puerto_cliente = puerto_cliente;
    }

    public String getIdKey() {
        return idKey;
    }

    public void setIdKey(String idKey) {
        this.idKey = idKey;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idKeyField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelType;
    private javax.swing.JTextField text_IP;
    private javax.swing.JTextField text_puerto_cliente;
    private javax.swing.JTextField text_puerto_server;
    // End of variables declaration//GEN-END:variables
}
