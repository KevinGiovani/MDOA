/**
 * Este controlador se encarga de manejar los MouseListeners y KeyListeners,
 * algunos aspectos visuales que normalmente se aplican en el JFrame.
 * También permite realizar las consultas de pedido a partir del numero de identificacion que se le
 * asigno a su orden o realizar su busqueda a partir del num. de telefono del cliente,
 * y por ultimo, permite realizar la consulta de datos de un cliente a partir del numero de telefono.
 */
package controladores;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import vistas.ConsultarPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.BDCliente;
import modelos.BDPedido;
import modelos.Cliente;
import modelos.Pedido;

/**
 *
 * @author Inzunza Kevin
 * @author De La Cruz Joel
 * @author Pacheco Cesar
 * @version 23-04-2021
 */
public class ControladorConsultar implements MouseListener, KeyListener {
    
    private final AudioClip sonidoDeBoton; //Audio para los botones
    private final AudioClip sonidoDeRegresar; //Audio reproducido para salir
    private final JPanel mConsultar; //Panel de la ventana de menú principal
    private final ConsultarPanel consultarCliente;
    private DefaultTableModel modelo;
    private Boolean tipoConsulta;

    /**
     * Constuctor que recibe parámetros desde el controlador menu consultar ,
     * además inicializa los eventos para el mouse y las teclas del computador.
     *
     * @param consultarCliente
     * @param sonidoDeBoton
     * @param sonidoDeRegresar
     * @param mConsultar
     * @throws SQLException
     */
    public ControladorConsultar(ConsultarPanel consultarCliente, AudioClip sonidoDeBoton, AudioClip sonidoDeRegresar, JPanel mConsultar) throws SQLException {
        this.consultarCliente = consultarCliente;
        this.mConsultar = mConsultar;
        this.sonidoDeBoton = sonidoDeBoton;
        this.sonidoDeRegresar = sonidoDeRegresar;
        //Botones
        consultarCliente.buscar.addMouseListener(this);
        consultarCliente.cancelar.addMouseListener(this);
        //Imagen
        consultarCliente.regresarImagen.addMouseListener(this);
        //Campos de texto
        consultarCliente.telefono.addKeyListener(this);
        //Tabla
        consultarCliente.tablaConsultas.addMouseListener(this);
    }

    /**
     * Obtiene la variable booleana de tipoConsulta con la cual se decide la
     * forma en la cual estara trabajando el controlador y realiza el llamado de
     * el metodo iniciarTabla()
     *
     * @param tipoConsulta
     * @throws SQLException
     */
    public void inicializar(Boolean tipoConsulta) throws SQLException {
        this.tipoConsulta = tipoConsulta;
        iniciarTabla();
    }

    /**
     * Dado el MouseEvent que se presente en este metodo, se procede a realizar
     * el llamado a demas metodos en los cuales actuara dado el tipo de
     * componente con el cual se actue y que dicho componente coincida con la
     * condicion que se tiene.
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JButton")) {
            try {
                eventosJButton(e);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorConsultar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JLabel")) {
            Icon icono = new ImageIcon(getClass().getResource("../imagenes/regreso.png"));
            sonidoDeRegresar.play();
            if (JOptionPane.showConfirmDialog(null, "¿Desea regresar al menu de consultas?", "Regresar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono) == 0) {
                consultarCliente.setVisible(false);
                try {
                    cancelar();
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorConsultar.class.getName()).log(Level.SEVERE, null, ex);
                }
                mConsultar.setVisible(true);
            }
        } else if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JTable")) {
            if (!tipoConsulta) {
                if (consultarCliente.tablaConsultas.getSelectedColumn() == 2 || consultarCliente.tablaConsultas.getSelectedColumn() == 3) {
                    if (!consultarCliente.tablaConsultas.getValueAt(consultarCliente.tablaConsultas.getSelectedRow(), consultarCliente.tablaConsultas.getSelectedColumn()).equals("")) {
                        JOptionPane.showMessageDialog(null, consultarCliente.tablaConsultas.getValueAt(consultarCliente.tablaConsultas.getSelectedRow(), consultarCliente.tablaConsultas.getSelectedColumn()), "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * MouseEntered detectará cuando el mouse está sobre algún botón y cual de
     * estos fue, cambiando el color de fondo del botón y reproduciendo un
     * sonido.
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(consultarCliente.buscar)) {
            consultarCliente.buscar.setBackground(new Color(0, 102, 102));
            sonidoDeBoton.play();
        } else if (e.getSource().equals(consultarCliente.cancelar)) {
            consultarCliente.cancelar.setBackground(new Color(0, 102, 102));
            sonidoDeBoton.play();
        }
    }

    /**
     * MouseExited detecta cuando el mouse ya no se encuentra dentro del botón
     * por lo que regresará el estado en el que se encontraba originalmente
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(consultarCliente.buscar)) {
            consultarCliente.buscar.setBackground(new Color(0, 51, 51));
        } else if (e.getSource().equals(consultarCliente.cancelar)) {
            consultarCliente.cancelar.setBackground(new Color(0, 51, 51));
        }
    }

    /**
     * Segun la variable booleana tipoConsulta se procede a mostrar la
     * informacion en la tabla que se recabo dada la busqueda realiza en la base
     * de datos
     *
     * @throws SQLException
     */
    public void consultar() throws SQLException {
        if (tipoConsulta == true) {
            BDCliente bd = new BDCliente();
            ArrayList<Cliente> clientes;
            clientes = bd.consultar();
            for (int i = 0; i < clientes.size(); i++) {
                Object info[] = {clientes.get(i).getNombre(), clientes.get(i).getApellido(), clientes.get(i).getTelefono(), clientes.get(i).getDireccion()};
                modelo.addRow(info);
            }
        } else {
            BDPedido bd = new BDPedido();
            ArrayList<Pedido> pedidos;
            pedidos = bd.consultar();
            for (int i = 0; i < pedidos.size(); i++) {
                Object info[] = {pedidos.get(i).getIdPedido(), pedidos.get(i).getIdCliente(), pedidos.get(i).getPaquete(), pedidos.get(i).getExtra(), pedidos.get(i).getFecha(), pedidos.get(i).getTotal()};
                modelo.addRow(info);
            }
        }
        
    }

    /**
     * Realiza la implementacion de la tabla en el JPanel con las
     * caracteristicas con las cuales se estara trabajando a apartir de la
     * varible booleana de tipoConsulta, y procede a mostrar la informacion con
     * el metodo consultar()
     *
     * @throws SQLException
     */
    public void iniciarTabla() throws SQLException {
        modelo = new DefaultTableModel();
        consultarCliente.tablaConsultas.setModel(modelo);
        consultarCliente.tablaConsultas.setDefaultEditor(Object.class, null);
        if (tipoConsulta) {
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Teléfono");
            modelo.addColumn("Dirección");
            for (int i = 0; i < 3; i++) {
                consultarCliente.tablaConsultas.getColumnModel().getColumn(i).setMinWidth(100);
                consultarCliente.tablaConsultas.getColumnModel().getColumn(i).setMaxWidth(100);
            }
        } else {
            modelo.addColumn("Id_Pedido");
            modelo.addColumn("Id_Cliente");
            modelo.addColumn("Paquete");
            modelo.addColumn("Extra");
            modelo.addColumn("Fecha");
            modelo.addColumn("Subtotal");
            for (int i = 0; i < 6; i++) {
                consultarCliente.tablaConsultas.getColumnModel().getColumn(i).setMinWidth(140);
                consultarCliente.tablaConsultas.getColumnModel().getColumn(i).setMaxWidth(150);
            }
        }
        consultar();
    }

    /**
     * Se realiza una consulta en la base de datos dada la informacion que se proporciono
     * para poder ser mostrada los datos obtenidos, en caso de que no se encuentre en la busqueda
     * se mostrara mensaje de error de busqueda en la pantalla del usuario.
     *
     * @param tel
     * @throws SQLException
     */
    public void buscar(long tel) throws SQLException {
        if (tipoConsulta) {
            BDCliente bd = new BDCliente();
            Cliente cliente = bd.buscar(tel);
            if (cliente.getTelefono() != null) {
                Object info[] = {cliente.getNombre(), cliente.getApellido(), cliente.getTelefono(), cliente.getDireccion()};
                modelo.setRowCount(0);
                modelo.addRow(info);
            } else {
                JOptionPane.showMessageDialog(null, "No existe un cliente con este número de teléfono", "Consulta", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            if (consultarCliente.nTelefono.isSelected()) {
                BDPedido bd = new BDPedido();
                ArrayList<Pedido> pedidos;
                pedidos = bd.consultarPedidosPorNumTel(consultarCliente.telefono.getText());
                if (!pedidos.isEmpty()) {
                    modelo.setRowCount(0);
                    for (int i = 0; i < pedidos.size(); i++) {
                        Object info[] = {pedidos.get(i).getIdPedido(), pedidos.get(i).getIdCliente(), pedidos.get(i).getPaquete(), pedidos.get(i).getExtra(), pedidos.get(i).getFecha(), pedidos.get(i).getTotal()};
                        modelo.addRow(info);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El cliente no está asociado a ningun pedido", "Consulta", JOptionPane.WARNING_MESSAGE);
                }
            } else if (consultarCliente.nPedido.isSelected()) {
                BDPedido bd = new BDPedido();
                Pedido pedido = bd.buscar(consultarCliente.telefono.getText());
                if (pedido.getPaquete() != null) {
                    Object info[] = {pedido.getIdPedido(), pedido.getIdCliente(), pedido.getPaquete(), pedido.getExtra(), pedido.getFecha(), pedido.getTotal()};
                    modelo.setRowCount(0);
                    modelo.addRow(info);
                } else {
                    JOptionPane.showMessageDialog(null, "No existe un pedido con este número", "Consulta", JOptionPane.WARNING_MESSAGE);
                }                
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna opción del tipo de consulta", "Consulta", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /**
     * Al presionar el boton de cancelar se procede a realizar una limpia de la
     * vista del JPanel de Corte para que se muestre en su estado original
     * predeterminado
     *
     * @throws SQLException
     */
    public void cancelar() throws SQLException {
        modelo.setRowCount(0);
        consultarCliente.telefono.setText(null);
        consultar();
    }

    /**
     * Si el textField cuenta con el ingreso de la informacion necesaria para la
     * busqueda del cliente se procede a llamar el metodo buscar(), caso
     * contrario, muestra mensaje en pantalla de que no se procedio a realizar
     * la consulta debido a informacion faltante.
     *
     * @throws SQLException
     */
    public void buscarCliente() throws SQLException {
        if (!consultarCliente.telefono.getText().isEmpty()) {
            buscar(Long.parseLong(consultarCliente.telefono.getText())); 
        } else {
            Icon icono = new ImageIcon(getClass().getResource("../imagenes/cancelar.png"));
            JOptionPane.showMessageDialog(null, "Verifique los datos ingresados", "Datos faltantes", JOptionPane.INFORMATION_MESSAGE, icono);
        }
    }

    /**
     * Segun el boton que se haya presionado, el MouseEvent se encarga de
     * compararlo para saber cual fue escogido y entra a una condicion para
     * proceder a otra el metodo buscarCliente() o cancelar()
     */
    public void eventosJButton(MouseEvent e) throws SQLException {
        if (e.getSource().equals(consultarCliente.buscar)) {
            buscarCliente();
        } else if (e.getSource().equals(consultarCliente.cancelar)) {
            cancelar();
        }
    }

    /**
     * KeyTyped verifica el uso de solo números en el caso para el número de
     * teléfono o numero de pedido con el cual se plantea la busqueda
     *
     * @param e
     */
    public void keyTyped(KeyEvent e) {
        char car = e.getKeyChar();
        if (e.getSource().equals(consultarCliente.telefono)) {
            if (!Character.isDigit(car)) {
                e.consume();
            }
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
