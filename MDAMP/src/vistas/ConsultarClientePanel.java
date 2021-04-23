/**
 * Ventana para mostrar al usuario una interacción visual, aunque solo
 * muestra, ya que para esto contiene su controlador.
 * */
package vistas;

import controladores.ControladorConsultarCliente;
import java.applet.AudioClip;
import java.sql.SQLException;
import javax.swing.JPanel;

/**
 * @author kevin
 * @version 16-04-2021
 */
public class ConsultarClientePanel extends javax.swing.JPanel {

   private final ControladorConsultarCliente cConsultarC; //Atributo para utilizar el controlador

    /**
     *
     * Constuctor para iniciar el panel de registrar pedido, el cual recibe el
     * sonido para los botones, el sonido para regresar y le ventana del menú
     * principal, componentes necesarios para utilizar el controlador.
     *
     * @param sonidoBoton
     * @param regresar
     * @param mConsultar
     * @param principal
     */
    public ConsultarClientePanel(AudioClip sonidoBoton, AudioClip regresar, JPanel mConsultar) throws SQLException {
      initComponents();
      cConsultarC = new ControladorConsultarCliente(this, sonidoBoton, regresar, mConsultar);
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registroClienteTitulo = new javax.swing.JPanel();
        manejoOTexto = new javax.swing.JLabel();
        regresarImagen = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 51));
        setForeground(new java.awt.Color(255, 255, 0));
        setPreferredSize(new java.awt.Dimension(1045, 490));

        registroClienteTitulo.setBackground(new java.awt.Color(0, 153, 153));

        manejoOTexto.setFont(new java.awt.Font("EB Garamond 08", 1, 24)); // NOI18N
        manejoOTexto.setForeground(new java.awt.Color(153, 255, 204));
        manejoOTexto.setText("CONSULTAR CLIENTE");

        javax.swing.GroupLayout registroClienteTituloLayout = new javax.swing.GroupLayout(registroClienteTitulo);
        registroClienteTitulo.setLayout(registroClienteTituloLayout);
        registroClienteTituloLayout.setHorizontalGroup(
            registroClienteTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroClienteTituloLayout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addComponent(manejoOTexto)
                .addGap(139, 139, 139))
        );
        registroClienteTituloLayout.setVerticalGroup(
            registroClienteTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(manejoOTexto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        regresarImagen.setBackground(new java.awt.Color(0, 153, 204));
        regresarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regreso.png"))); // NOI18N

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Telefono", "Dirección"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaClientes);
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(10);
            tablaClientes.getColumnModel().getColumn(1).setPreferredWidth(10);
            tablaClientes.getColumnModel().getColumn(2).setPreferredWidth(10);
        }

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel3.setFont(new java.awt.Font("Comfortaa Light", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 153));
        jLabel3.setText("Numero de Telefono:");

        telefono.setBackground(new java.awt.Color(153, 255, 204));

        buscar.setBackground(new java.awt.Color(0, 51, 51));
        buscar.setFont(new java.awt.Font("Gayathri", 1, 8)); // NOI18N
        buscar.setForeground(new java.awt.Color(153, 255, 204));
        buscar.setText("Buscar");

        cancelar.setBackground(new java.awt.Color(0, 51, 51));
        cancelar.setFont(new java.awt.Font("Gayathri", 1, 8)); // NOI18N
        cancelar.setForeground(new java.awt.Color(153, 255, 204));
        cancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel3)
                .addGap(71, 71, 71)
                .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelar)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar)
                    .addComponent(cancelar))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registroClienteTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221)
                .addComponent(regresarImagen)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registroClienteTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regresarImagen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton buscar;
    public javax.swing.JButton cancelar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel manejoOTexto;
    private javax.swing.JPanel registroClienteTitulo;
    public javax.swing.JLabel regresarImagen;
    public javax.swing.JTable tablaClientes;
    public javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
