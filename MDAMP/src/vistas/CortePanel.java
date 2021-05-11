/**
 * Ventana para mostrar al usuario una interacción visual, aunque solo
 * muestra, ya que para esto contiene su controlador.
 * */
package vistas;

import controladores.ControladorCorte;
import java.applet.AudioClip;
import java.sql.SQLException;
import javax.swing.JPanel;

/**
 *
 * @author Inzunza Kevin
 * @author De La Cruz Joel
 * @author Pacheco Cesar
 * @version 25-04-2021
 */
public class CortePanel extends javax.swing.JPanel {

   public final ControladorCorte cCorte; //Atributo para utilizar el controlador

    /**
     *
     * Constuctor para iniciar el panel de consultar cliente, el cual recibe el
     * sonido para los botones, el sonido para regresar y le ventana del menú
     * principal, componentes necesarios para utilizar el controlador.
     *
     * @param sonidoBoton
     * @param regresar
     * @param mPrincipal
     * @throws java.sql.SQLException
     */
    public CortePanel(AudioClip sonidoBoton, AudioClip regresar,JPanel mPrincipal) throws SQLException {
      initComponents();
      cCorte = new ControladorCorte(this, sonidoBoton, regresar,mPrincipal);
      generar.setName("generar");
     }
    //Obtención del atributo de cCorte, que es el controlador de corte.
    public ControladorCorte getcCorte() {
        return cCorte;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        registroCorteTitulo = new javax.swing.JPanel();
        manejoOTexto = new javax.swing.JLabel();
        regresarImagen = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCorte = new javax.swing.JTable();
        panelInf = new javax.swing.JPanel();
        generar = new javax.swing.JButton();
        totalCorte = new javax.swing.JTextField();
        totalJLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 51));
        setForeground(new java.awt.Color(255, 255, 0));
        setPreferredSize(new java.awt.Dimension(1045, 490));

        registroCorteTitulo.setBackground(new java.awt.Color(0, 153, 153));

        manejoOTexto.setFont(new java.awt.Font("EB Garamond 08", 1, 24)); // NOI18N
        manejoOTexto.setForeground(new java.awt.Color(153, 255, 204));
        manejoOTexto.setText("REALIZAR CORTE");

        javax.swing.GroupLayout registroCorteTituloLayout = new javax.swing.GroupLayout(registroCorteTitulo);
        registroCorteTitulo.setLayout(registroCorteTituloLayout);
        registroCorteTituloLayout.setHorizontalGroup(
            registroCorteTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroCorteTituloLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(manejoOTexto)
                .addGap(139, 139, 139))
        );
        registroCorteTituloLayout.setVerticalGroup(
            registroCorteTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(manejoOTexto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        regresarImagen.setBackground(new java.awt.Color(0, 153, 204));
        regresarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regreso.png"))); // NOI18N

        tablaCorte.setBackground(new java.awt.Color(215, 215, 215));
        tablaCorte.setFont(new java.awt.Font("Comfortaa Light", 0, 12)); // NOI18N
        tablaCorte.setForeground(new java.awt.Color(0, 0, 0));
        tablaCorte.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaCorte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaCorte.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tablaCorte.setSelectionForeground(new java.awt.Color(153, 255, 153));
        tablaCorte.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaCorte);
        if (tablaCorte.getColumnModel().getColumnCount() > 0) {
            tablaCorte.getColumnModel().getColumn(0).setPreferredWidth(10);
            tablaCorte.getColumnModel().getColumn(1).setPreferredWidth(10);
            tablaCorte.getColumnModel().getColumn(2).setPreferredWidth(10);
        }

        panelInf.setBackground(new java.awt.Color(0, 153, 153));

        generar.setBackground(new java.awt.Color(0, 51, 51));
        generar.setFont(new java.awt.Font("Gayathri Thin", 1, 12)); // NOI18N
        generar.setForeground(new java.awt.Color(153, 255, 204));
        generar.setText("Generar PDF");

        totalCorte.setEditable(false);
        totalCorte.setBackground(new java.awt.Color(153, 255, 204));

        totalJLabel.setFont(new java.awt.Font("Comfortaa Light", 1, 14)); // NOI18N
        totalJLabel.setForeground(new java.awt.Color(153, 255, 153));
        totalJLabel.setText("Total:");

        javax.swing.GroupLayout panelInfLayout = new javax.swing.GroupLayout(panelInf);
        panelInf.setLayout(panelInfLayout);
        panelInfLayout.setHorizontalGroup(
            panelInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(generar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(totalJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        panelInfLayout.setVerticalGroup(
            panelInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalCorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(registroCorteTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202)
                        .addComponent(regresarImagen)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelInf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(regresarImagen))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(registroCorteTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JButton generar;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel manejoOTexto;
    private javax.swing.JPanel panelInf;
    private javax.swing.JPanel registroCorteTitulo;
    public javax.swing.JLabel regresarImagen;
    public javax.swing.JTable tablaCorte;
    public javax.swing.JTextField totalCorte;
    private javax.swing.JLabel totalJLabel;
    // End of variables declaration//GEN-END:variables
}
