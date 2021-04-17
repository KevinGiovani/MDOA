/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import db.BDCliente;
import modelos.Cliente;
import java.applet.AudioClip;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Inzunza Kevin
 */
public class RegistrarClientePanel extends javax.swing.JPanel {

    private final JPanel mPrincipal;
    private final AudioClip sonidoBoton;
    private final AudioClip regresar;
    /**
     * Creates new form RegistrarPedidoFrame
     *
     * @param mPrincipal
     * @param regresar
     * @param sonidoBoton
     */
    public RegistrarClientePanel(AudioClip sonidoBoton,AudioClip regresar,JPanel mPrincipal) {
        initComponents();
        this.sonidoBoton = sonidoBoton;
        this.mPrincipal = mPrincipal;
        this.regresar=regresar;
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cLittleImagen = new javax.swing.JLabel();
        registroClienteTitulo = new javax.swing.JPanel();
        manejoOTexto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        direccionJLabel = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        nombreJLabel = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        apellidoJLabel = new javax.swing.JLabel();
        apellido = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        numTelJLabel = new javax.swing.JLabel();
        numTelefono = new javax.swing.JTextField();
        cancelarBoton = new javax.swing.JButton();
        aceptarBoton = new javax.swing.JButton();
        regresarImagen = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 51));
        setPreferredSize(new java.awt.Dimension(1045, 490));

        cLittleImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoInicioLogo.gif"))); // NOI18N
        cLittleImagen.setText("jLabel1");

        registroClienteTitulo.setBackground(new java.awt.Color(0, 153, 153));

        manejoOTexto.setFont(new java.awt.Font("EB Garamond 08", 1, 24)); // NOI18N
        manejoOTexto.setForeground(new java.awt.Color(153, 255, 204));
        manejoOTexto.setText("REGISTRO DE CLIENTES");

        javax.swing.GroupLayout registroClienteTituloLayout = new javax.swing.GroupLayout(registroClienteTitulo);
        registroClienteTitulo.setLayout(registroClienteTituloLayout);
        registroClienteTituloLayout.setHorizontalGroup(
            registroClienteTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroClienteTituloLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(manejoOTexto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        registroClienteTituloLayout.setVerticalGroup(
            registroClienteTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroClienteTituloLayout.createSequentialGroup()
                .addComponent(manejoOTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        direccionJLabel.setFont(new java.awt.Font("Comfortaa Light", 1, 14)); // NOI18N
        direccionJLabel.setForeground(new java.awt.Color(153, 255, 153));
        direccionJLabel.setText("Direccion:");

        direccion.setBackground(new java.awt.Color(153, 255, 204));
        direccion.setFont(new java.awt.Font("Comfortaa Light", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(direccionJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccionJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        nombreJLabel.setFont(new java.awt.Font("Comfortaa Light", 1, 14)); // NOI18N
        nombreJLabel.setForeground(new java.awt.Color(153, 255, 153));
        nombreJLabel.setText("Nombre:");

        nombre.setBackground(new java.awt.Color(153, 255, 204));
        nombre.setFont(new java.awt.Font("Comfortaa Light", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nombreJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        apellidoJLabel.setFont(new java.awt.Font("Comfortaa Light", 1, 14)); // NOI18N
        apellidoJLabel.setForeground(new java.awt.Color(153, 255, 153));
        apellidoJLabel.setText("Apellido:");

        apellido.setBackground(new java.awt.Color(153, 255, 204));
        apellido.setFont(new java.awt.Font("Comfortaa Light", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(apellidoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        numTelJLabel.setFont(new java.awt.Font("Comfortaa Light", 1, 14)); // NOI18N
        numTelJLabel.setForeground(new java.awt.Color(153, 255, 153));
        numTelJLabel.setText("Num. de telefono:");

        numTelefono.setBackground(new java.awt.Color(153, 255, 204));
        numTelefono.setFont(new java.awt.Font("Comfortaa Light", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(numTelJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(numTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numTelJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        cancelarBoton.setBackground(new java.awt.Color(0, 51, 51));
        cancelarBoton.setFont(new java.awt.Font("Gayathri", 1, 8)); // NOI18N
        cancelarBoton.setForeground(new java.awt.Color(153, 255, 204));
        cancelarBoton.setText("Cancelar");
        cancelarBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelarBotonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelarBotonMouseEntered(evt);
            }
        });
        cancelarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBotonActionPerformed(evt);
            }
        });

        aceptarBoton.setBackground(new java.awt.Color(0, 51, 51));
        aceptarBoton.setFont(new java.awt.Font("Gayathri", 1, 8)); // NOI18N
        aceptarBoton.setForeground(new java.awt.Color(153, 255, 204));
        aceptarBoton.setText("Aceptar");
        aceptarBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aceptarBotonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aceptarBotonMouseEntered(evt);
            }
        });
        aceptarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBotonActionPerformed(evt);
            }
        });

        regresarImagen.setBackground(new java.awt.Color(0, 153, 204));
        regresarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regreso.png"))); // NOI18N
        regresarImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regresarImagenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(registroClienteTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)))
                .addComponent(cLittleImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regresarImagen)
                .addGap(4, 4, 4))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(aceptarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(772, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cLittleImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(registroClienteTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(regresarImagen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(398, Short.MAX_VALUE)
                    .addComponent(aceptarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(52, 52, 52)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarBotonMouseExited
        cancelarBoton.setBackground(new Color(0, 51, 51));
    }//GEN-LAST:event_cancelarBotonMouseExited

    private void cancelarBotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarBotonMouseEntered
        cancelarBoton.setBackground(new Color(0, 102, 102));
        sonidoBoton.play();
    }//GEN-LAST:event_cancelarBotonMouseEntered

    private void cancelarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBotonActionPerformed
        Icon icono = new ImageIcon(getClass().getResource("../imagenes/cancelar.png"));
        if (JOptionPane.showConfirmDialog(null, "¿Desea cancelar el registro del cliente?","Cancelar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icono) == 0) {
            nombre.setText(null);
            apellido.setText(null);
            numTelefono.setText(null);
            direccion.setText(null);
        }
    }//GEN-LAST:event_cancelarBotonActionPerformed

    private void aceptarBotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarBotonMouseExited
        aceptarBoton.setBackground(new Color(0, 51, 51));
    }//GEN-LAST:event_aceptarBotonMouseExited

    private void aceptarBotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarBotonMouseEntered
        aceptarBoton.setBackground(new Color(0, 102, 102));
        sonidoBoton.play();
    }//GEN-LAST:event_aceptarBotonMouseEntered

    private void aceptarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBotonActionPerformed
        aceptar();
    }//GEN-LAST:event_aceptarBotonActionPerformed
    
    public void aceptar(){
       if(!nombre.getText().isEmpty() && !apellido.getText().isEmpty() && !numTelefono.getText().isEmpty() && !direccion.getText().isEmpty()){
         BDCliente clientes=new BDCliente();
         Cliente cliente=new Cliente(nombre.getText(),apellido.getText(),numTelefono.getText(),direccion.getText());
        clientes.agregarDatos(cliente);
          JOptionPane.showMessageDialog(null, "Operación Exitosa","Datos agregados", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten ingresados","Datos faltantes", JOptionPane.INFORMATION_MESSAGE);
        }  
    }
    
    private void regresarImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarImagenMouseClicked
        Icon icono = new ImageIcon(getClass().getResource("../imagenes/regreso.png"));
        regresar.play();
        if(JOptionPane.showConfirmDialog(null, "¿Desea regresar al menu principal?","Regresar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icono) == 0) {
            this.setVisible(false);
            mPrincipal.setVisible(true);
        }
    }//GEN-LAST:event_regresarImagenMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBoton;
    private javax.swing.JTextField apellido;
    private javax.swing.JLabel apellidoJLabel;
    private javax.swing.JLabel cLittleImagen;
    private javax.swing.JButton cancelarBoton;
    private javax.swing.JTextField direccion;
    private javax.swing.JLabel direccionJLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel manejoOTexto;
    private javax.swing.JTextField nombre;
    private javax.swing.JLabel nombreJLabel;
    private javax.swing.JLabel numTelJLabel;
    private javax.swing.JTextField numTelefono;
    private javax.swing.JPanel registroClienteTitulo;
    private javax.swing.JLabel regresarImagen;
    // End of variables declaration//GEN-END:variables
}
