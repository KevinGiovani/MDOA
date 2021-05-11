/**
 * Interfaz principal del programa, muestra en pantalla las opciones correspondientes
 * a las interfaces a las cuales el usuario puede interacturar las cuales son:
 * - Registrar un pedido
 * - Registrar un cliente
 * - Consultar
 * - Realizar corte
 */
package vistas;

import controladores.ControladorMenuPrincipal;
import modelos.CreadorPDF;
import java.applet.AudioClip;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Inzunza Kevin
 * @version 16-04-2021
 */
public class PrincipalFrame extends javax.swing.JFrame {

    private final ControladorMenuPrincipal cMenu;
    private final AudioClip sonidoDeBoton;
    private final AudioClip sonidoDeSalir;
    private final JPanel registrarPedido;
    private final JPanel registrarCliente;
    private final JPanel menuConsultar;
    private final CortePanel corte;
    private CreadorPDF ts;

    /**
     * Constructor utilizado para inicializar todos los componentes del frame al
     * igual que habilitar los sonidos para cada uno de los botones.
     */
    public PrincipalFrame() throws SQLException {
        initComponents();
        sonidoDeBoton = java.applet.Applet.newAudioClip(getClass().getResource("../sonidos/sonido_boton.wav"));
        sonidoDeSalir = java.applet.Applet.newAudioClip(getClass().getResource("../sonidos/salir.wav"));
        this.registrarPedido = new RegistrarPedidoPanel(sonidoDeBoton, sonidoDeSalir, fondoJPanel);
        this.registrarCliente = new RegistrarClientePanel(sonidoDeBoton, sonidoDeSalir, fondoJPanel);
        this.menuConsultar = new MenuConsultarPanel(sonidoDeBoton, sonidoDeSalir, this);
        this.corte = new CortePanel(sonidoDeBoton, sonidoDeSalir, fondoJPanel);
        cMenu = new ControladorMenuPrincipal(this, sonidoDeBoton, sonidoDeSalir, registrarCliente, registrarPedido, menuConsultar, corte);
        registroClienteBoton.setName("registroClienteBoton");
        registroPedidoBoton.setName("registroPedidoBoton");
        consultarBoton.setName("consultarBoton");
        corteBoton.setName("corteBoton");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoJPanel = new javax.swing.JPanel();
        consultarBoton = new javax.swing.JButton();
        registroClienteBoton = new javax.swing.JButton();
        registroPedidoBoton = new javax.swing.JButton();
        consultarJPanel = new javax.swing.JPanel();
        consultaIcono = new javax.swing.JLabel();
        clienteJPanel = new javax.swing.JPanel();
        clienteIcono = new javax.swing.JLabel();
        polloJPanel = new javax.swing.JPanel();
        polloIcono = new javax.swing.JLabel();
        manejoOrdenesLabel = new javax.swing.JPanel();
        opcionesTexto = new javax.swing.JLabel();
        tituloJPanel = new javax.swing.JPanel();
        manejoOTexto = new javax.swing.JLabel();
        inferiorJPanel = new javax.swing.JPanel();
        corteJPanel = new javax.swing.JPanel();
        corteIcono = new javax.swing.JLabel();
        corteBoton = new javax.swing.JButton();
        imagenIzq_jLabel = new javax.swing.JLabel();
        salirImagen = new javax.swing.JLabel();
        cLittleImagen = new javax.swing.JLabel();
        izquierdo_JPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        fondoJPanel.setBackground(new java.awt.Color(255, 204, 0));
        fondoJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        consultarBoton.setBackground(new java.awt.Color(0, 51, 51));
        consultarBoton.setFont(new java.awt.Font("Gayathri", 1, 8)); // NOI18N
        consultarBoton.setForeground(new java.awt.Color(153, 255, 204));
        consultarBoton.setText("CONSULTAR");
        fondoJPanel.add(consultarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 190, 40));

        registroClienteBoton.setBackground(new java.awt.Color(0, 51, 51));
        registroClienteBoton.setFont(new java.awt.Font("Gayathri", 1, 8)); // NOI18N
        registroClienteBoton.setForeground(new java.awt.Color(153, 255, 204));
        registroClienteBoton.setText("REGISTRAR CLIENTE");
        fondoJPanel.add(registroClienteBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 190, 40));

        registroPedidoBoton.setBackground(new java.awt.Color(0, 51, 51));
        registroPedidoBoton.setFont(new java.awt.Font("Gayathri", 1, 8)); // NOI18N
        registroPedidoBoton.setForeground(new java.awt.Color(153, 255, 204));
        registroPedidoBoton.setText("REGISTRAR PEDIDO");
        fondoJPanel.add(registroPedidoBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 190, 40));

        consultarJPanel.setBackground(new java.awt.Color(0, 51, 51));

        consultaIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/consulta-de-busqueda.png"))); // NOI18N

        javax.swing.GroupLayout consultarJPanelLayout = new javax.swing.GroupLayout(consultarJPanel);
        consultarJPanel.setLayout(consultarJPanelLayout);
        consultarJPanelLayout.setHorizontalGroup(
            consultarJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultarJPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(consultaIcono)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        consultarJPanelLayout.setVerticalGroup(
            consultarJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultarJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(consultaIcono)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fondoJPanel.add(consultarJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 80, 50));

        clienteJPanel.setBackground(new java.awt.Color(0, 51, 51));

        clienteIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro.png"))); // NOI18N

        javax.swing.GroupLayout clienteJPanelLayout = new javax.swing.GroupLayout(clienteJPanel);
        clienteJPanel.setLayout(clienteJPanelLayout);
        clienteJPanelLayout.setHorizontalGroup(
            clienteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clienteJPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(clienteIcono)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        clienteJPanelLayout.setVerticalGroup(
            clienteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clienteJPanelLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(clienteIcono)
                .addContainerGap())
        );

        fondoJPanel.add(clienteJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 80, 50));

        polloJPanel.setBackground(new java.awt.Color(0, 51, 51));

        polloIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pollo.png"))); // NOI18N

        javax.swing.GroupLayout polloJPanelLayout = new javax.swing.GroupLayout(polloJPanel);
        polloJPanel.setLayout(polloJPanelLayout);
        polloJPanelLayout.setHorizontalGroup(
            polloJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(polloJPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(polloIcono)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        polloJPanelLayout.setVerticalGroup(
            polloJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, polloJPanelLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(polloIcono)
                .addContainerGap())
        );

        fondoJPanel.add(polloJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 80, 50));

        manejoOrdenesLabel.setBackground(new java.awt.Color(255, 204, 0));

        opcionesTexto.setFont(new java.awt.Font("EB Garamond 08", 1, 18)); // NOI18N
        opcionesTexto.setForeground(new java.awt.Color(0, 153, 0));
        opcionesTexto.setText("OPCIONES:");

        javax.swing.GroupLayout manejoOrdenesLabelLayout = new javax.swing.GroupLayout(manejoOrdenesLabel);
        manejoOrdenesLabel.setLayout(manejoOrdenesLabelLayout);
        manejoOrdenesLabelLayout.setHorizontalGroup(
            manejoOrdenesLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manejoOrdenesLabelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(opcionesTexto)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        manejoOrdenesLabelLayout.setVerticalGroup(
            manejoOrdenesLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manejoOrdenesLabelLayout.createSequentialGroup()
                .addComponent(opcionesTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        fondoJPanel.add(manejoOrdenesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 150, 40));

        tituloJPanel.setBackground(new java.awt.Color(255, 204, 0));

        manejoOTexto.setFont(new java.awt.Font("EB Garamond 08", 1, 24)); // NOI18N
        manejoOTexto.setForeground(new java.awt.Color(0, 153, 0));
        manejoOTexto.setText("MANEJO DE ORDENES");

        javax.swing.GroupLayout tituloJPanelLayout = new javax.swing.GroupLayout(tituloJPanel);
        tituloJPanel.setLayout(tituloJPanelLayout);
        tituloJPanelLayout.setHorizontalGroup(
            tituloJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tituloJPanelLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(manejoOTexto)
                .addGap(42, 42, 42))
        );
        tituloJPanelLayout.setVerticalGroup(
            tituloJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloJPanelLayout.createSequentialGroup()
                .addComponent(manejoOTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        fondoJPanel.add(tituloJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 350, 40));

        inferiorJPanel.setBackground(new java.awt.Color(102, 51, 0));

        corteJPanel.setBackground(new java.awt.Color(0, 51, 51));

        corteIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/corte.png"))); // NOI18N

        javax.swing.GroupLayout corteJPanelLayout = new javax.swing.GroupLayout(corteJPanel);
        corteJPanel.setLayout(corteJPanelLayout);
        corteJPanelLayout.setHorizontalGroup(
            corteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, corteJPanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(corteIcono)
                .addGap(23, 23, 23))
        );
        corteJPanelLayout.setVerticalGroup(
            corteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(corteJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(corteIcono)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        corteBoton.setBackground(new java.awt.Color(0, 51, 51));
        corteBoton.setFont(new java.awt.Font("Gayathri", 1, 8)); // NOI18N
        corteBoton.setForeground(new java.awt.Color(153, 255, 204));
        corteBoton.setText("REALIZAR CORTE");

        javax.swing.GroupLayout inferiorJPanelLayout = new javax.swing.GroupLayout(inferiorJPanel);
        inferiorJPanel.setLayout(inferiorJPanelLayout);
        inferiorJPanelLayout.setHorizontalGroup(
            inferiorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inferiorJPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(corteJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(corteBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        inferiorJPanelLayout.setVerticalGroup(
            inferiorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inferiorJPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(inferiorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(corteJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corteBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        fondoJPanel.add(inferiorJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 540, 120));

        imagenIzq_jLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoInicio.png"))); // NOI18N
        fondoJPanel.add(imagenIzq_jLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 380));

        salirImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        fondoJPanel.add(salirImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, -1, -1));

        cLittleImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoInicioLogo.gif"))); // NOI18N
        cLittleImagen.setText("jLabel1");
        fondoJPanel.add(cLittleImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 480, 490));

        javax.swing.GroupLayout izquierdo_JPanelLayout = new javax.swing.GroupLayout(izquierdo_JPanel);
        izquierdo_JPanel.setLayout(izquierdo_JPanelLayout);
        izquierdo_JPanelLayout.setHorizontalGroup(
            izquierdo_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        izquierdo_JPanelLayout.setVerticalGroup(
            izquierdo_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        fondoJPanel.add(izquierdo_JPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1045, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PrincipalFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cLittleImagen;
    private javax.swing.JLabel clienteIcono;
    private javax.swing.JPanel clienteJPanel;
    private javax.swing.JLabel consultaIcono;
    public javax.swing.JButton consultarBoton;
    private javax.swing.JPanel consultarJPanel;
    public javax.swing.JButton corteBoton;
    private javax.swing.JLabel corteIcono;
    private javax.swing.JPanel corteJPanel;
    public javax.swing.JPanel fondoJPanel;
    private javax.swing.JLabel imagenIzq_jLabel;
    private javax.swing.JPanel inferiorJPanel;
    private javax.swing.JPanel izquierdo_JPanel;
    private javax.swing.JLabel manejoOTexto;
    private javax.swing.JPanel manejoOrdenesLabel;
    private javax.swing.JLabel opcionesTexto;
    private javax.swing.JLabel polloIcono;
    private javax.swing.JPanel polloJPanel;
    public javax.swing.JButton registroClienteBoton;
    public javax.swing.JButton registroPedidoBoton;
    public javax.swing.JLabel salirImagen;
    private javax.swing.JPanel tituloJPanel;
    // End of variables declaration//GEN-END:variables
}
