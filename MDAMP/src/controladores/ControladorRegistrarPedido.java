/**
 * Este controlador se encarga de manejar los Mouse Listeners y Key Listeners,
 * algunos aspectos visuales que normalmente se aplican en el JFrame.
 * Además se encarga de registrar la información de los pedidos, calcular el total
 * que el cliente debe pagar y también consultar el cliente que está realizando la compra.
 * */
package controladores;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Math.abs;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import modelos.BDCliente;
import modelos.BDPedido;
import modelos.Cliente;
import modelos.Pedido;
import vistas.RegistrarPedidoPanel;

/**
 *
 * @author kevin
 * @version 16-04-2021
 */
public class ControladorRegistrarPedido implements ActionListener, MouseListener, ChangeListener, KeyListener {

    private RegistrarPedidoPanel registrarP; //Referencia del panel visual de Registrar Pedido
    private Pedido pedido; //Atributo que almacena la información del pedido
    private final AudioClip sonidoDePago; //Sonido al pagar
    private final AudioClip sonidoDeError; //Sonido al detectar algún error
    private final AudioClip sonidoDeBoton; //Sonido al tocar un botón
    private final AudioClip sonidoDeRegresar; //Sonido al regresar
    private JPanel principal; //Panel del menú principal

    /**
     * Constuctor que recibe parámetros desde el JPanel de registrar pedido,
     * además inicializa los eventos para el mouse y las teclas del computador.
     *
     * @param registrarP
     * @param sonidoDeBoton
     * @param sonidoDeRegresar
     * @param principal
     */
    public ControladorRegistrarPedido(RegistrarPedidoPanel registrarP, AudioClip sonidoDeBoton, AudioClip sonidoDeRegresar, JPanel principal) {
        pedido = new Pedido();
        sonidoDePago = java.applet.Applet.newAudioClip(getClass().getResource("../sonidos/pago-realizado.wav"));
        sonidoDeError = java.applet.Applet.newAudioClip(getClass().getResource("../sonidos/errorSonido.wav"));
        this.registrarP = registrarP;
        this.sonidoDeBoton = sonidoDeBoton;
        this.sonidoDeRegresar = sonidoDeRegresar;
        this.principal = principal;
        iniciar();
    }

    /**
     * Añade las acciones de los CheckBox, los cambios de los JSpinner, los
     * eventos para el mouse de los botones y los eventos para las teclas de los
     * campos de texto. Otra tarea es definir todo en nulo mediante otro método.
     */
    public void iniciar() {
        //CheckBox
        registrarP.paq1.addActionListener(this);
        registrarP.paq2.addActionListener(this);
        registrarP.paq3.addActionListener(this);
        registrarP.paq4.addActionListener(this);
        registrarP.paq5.addActionListener(this);
        registrarP.paq6.addActionListener(this);
        registrarP.extra1.addActionListener(this);
        registrarP.extra2.addActionListener(this);
        registrarP.extra3.addActionListener(this);
        registrarP.extra4.addActionListener(this);
        registrarP.extra5.addActionListener(this);
        //JSpinner
        registrarP.cantPaq1.addChangeListener(this);
        registrarP.cantPaq2.addChangeListener(this);
        registrarP.cantPaq3.addChangeListener(this);
        registrarP.cantPaq4.addChangeListener(this);
        registrarP.cantPaq5.addChangeListener(this);
        registrarP.cantPaq6.addChangeListener(this);
        registrarP.cantExt1.addChangeListener(this);
        registrarP.cantExt2.addChangeListener(this);
        registrarP.cantExt3.addChangeListener(this);
        registrarP.cantExt4.addChangeListener(this);
        registrarP.cantExt5.addChangeListener(this);

        //Boton
        registrarP.pagarBoton.addMouseListener(this);
        registrarP.buscarBoton.addMouseListener(this);
        registrarP.regresarImagen.addMouseListener(this);

        //JTextfield
        registrarP.numTelefono.addKeyListener(this);
        registrarP.totalCliente.addKeyListener(this);

        desactivar();
    }

    /**
     * Se utiliza para asignar un evento al método de eventosJCheckBox de todos
     * los componentes swing.JCheckBox
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JCheckBox")) {
            eventosJCheckBox(e);
        }
    }

    /**
     * Se utiliza para asignar un evento al método eventosJButton de todos los
     * componentes swing.JButton, el cual detecta cuando se realizó un clic
     * sobre un botón.
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JButton")) {
            try {
                eventosJButton(e);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRegistrarPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Detecta si se presionó la etiqueta con la imagen de regresar, reproduce
     * su respectido sonido y cierra la ventana en curso para abrir el menú
     * principal.
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource().equals(registrarP.regresarImagen)) {
            Icon icono = new ImageIcon(getClass().getResource("../imagenes/regreso.png"));
            sonidoDeRegresar.play();
            if (JOptionPane.showConfirmDialog(null, "¿Desea regresar al menu principal?", "Regresar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono) == 0) {
                registrarP.setVisible(false);
                principal.setVisible(true);
                limpiar();
            }
        }
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
        if (e.getSource().equals(registrarP.pagarBoton)) {
            sonidoDeBoton.play();
            registrarP.pagarBoton.setBackground(new Color(0, 102, 102));
        } else if (e.getSource().equals(registrarP.buscarBoton)) {
            registrarP.buscarBoton.setBackground(new Color(0, 102, 102));
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
        if (e.getSource().equals(registrarP.pagarBoton)) {
            registrarP.pagarBoton.setBackground(new Color(0, 51, 51));
        } else if (e.getSource().equals(registrarP.buscarBoton)) {
            registrarP.buscarBoton.setBackground(new Color(0, 51, 51));
        }
    }

    /**
     * Detecta si se realizó un cambio sobre el valor de algún JSpinner, además
     * se asignará el total de momento calculando el paquete seleccionado y
     * cuantos de estos seleccionó.
     *
     * @param e
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource().equals(registrarP.cantPaq1)) {
            if (registrarP.paq1.isSelected()) {
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(0, Integer.parseInt(registrarP.cantPaq1.getValue().toString()))));
            }
        } else if (e.getSource().equals(registrarP.cantPaq2)) {
            if (registrarP.paq2.isSelected()) {
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(1, Integer.parseInt(registrarP.cantPaq2.getValue().toString()))));
            } else if (e.getSource().equals(registrarP.cantPaq2)) {
                if (registrarP.paq2.isSelected()) {
                    registrarP.totalPagar.setText(String.valueOf(pedido.calcular(1, Integer.parseInt(registrarP.cantPaq2.getValue().toString()))));
                }
            }
        } else if (e.getSource().equals(registrarP.cantPaq3)) {
            if (registrarP.paq3.isSelected()) {
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(2, Integer.parseInt(registrarP.cantPaq3.getValue().toString()))));
            }
        } else if (e.getSource().equals(registrarP.cantPaq4)) {
            if (registrarP.paq4.isSelected()) {
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(3, Integer.parseInt(registrarP.cantPaq4.getValue().toString()))));
            }
        } else if (e.getSource().equals(registrarP.cantPaq5)) {
            if (registrarP.paq5.isSelected()) {
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(4, Integer.parseInt(registrarP.cantPaq5.getValue().toString()))));
            }
        } else if (e.getSource().equals(registrarP.cantPaq6)) {
            if (registrarP.paq6.isSelected()) {
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(5, Integer.parseInt(registrarP.cantPaq6.getValue().toString()))));
            }
        } else if (e.getSource().equals(registrarP.cantExt1)) {
            if (registrarP.extra1.isSelected()) {
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(6, Integer.parseInt(registrarP.cantExt1.getValue().toString()))));
            }
        } else if (e.getSource().equals(registrarP.cantExt2)) {
            if (registrarP.extra2.isSelected()) {
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(7, Integer.parseInt(registrarP.cantExt2.getValue().toString()))));
            }
        } else if (e.getSource().equals(registrarP.cantExt3)) {
            if (registrarP.extra3.isSelected()) {
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(8, Integer.parseInt(registrarP.cantExt3.getValue().toString()))));
            }
        } else if (e.getSource().equals(registrarP.cantExt4)) {
            if (registrarP.extra4.isSelected()) {
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(9, Integer.parseInt(registrarP.cantExt4.getValue().toString()))));
            }
        } else if (e.getSource().equals(registrarP.cantExt5)) {
            if (registrarP.extra5.isSelected()) {
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(10, Integer.parseInt(registrarP.cantExt5.getValue().toString()))));
            }
        }
    }

    /**
     * Desactiva cada uno de los JSpinner para que no puedan utilizarse si su
     * checkBox correspondiente no ha sido seleccionado.
     */
    public void desactivar() {
        registrarP.cantPaq1.setEnabled(false);
        registrarP.cantPaq2.setEnabled(false);
        registrarP.cantPaq3.setEnabled(false);
        registrarP.cantPaq4.setEnabled(false);
        registrarP.cantPaq5.setEnabled(false);
        registrarP.cantPaq6.setEnabled(false);
        registrarP.cantExt1.setEnabled(false);
        registrarP.cantExt2.setEnabled(false);
        registrarP.cantExt3.setEnabled(false);
        registrarP.cantExt4.setEnabled(false);
        registrarP.cantExt5.setEnabled(false);
    }

    /**
     * Regresa el estado nulo a todos los componentes de la ventana, así podrá
     * realizar un nuevo pedido.
     */
    public void limpiar() {
        desactivar();
        registrarP.paq1.setSelected(false);
        registrarP.paq2.setSelected(false);
        registrarP.paq3.setSelected(false);
        registrarP.paq4.setSelected(false);
        registrarP.paq5.setSelected(false);
        registrarP.paq6.setSelected(false);
        registrarP.extra1.setSelected(false);
        registrarP.extra2.setSelected(false);
        registrarP.extra3.setSelected(false);
        registrarP.extra4.setSelected(false);
        registrarP.extra5.setSelected(false);
        registrarP.cantPaq1.setValue(1);
        registrarP.cantPaq2.setValue(1);
        registrarP.cantPaq3.setValue(1);
        registrarP.cantPaq4.setValue(1);
        registrarP.cantPaq5.setValue(1);
        registrarP.cantPaq6.setValue(1);
        registrarP.cantExt1.setValue(1);
        registrarP.cantExt2.setValue(1);
        registrarP.cantExt3.setValue(1);
        registrarP.cantExt4.setValue(1);
        registrarP.cantExt5.setValue(1);

        registrarP.numTelefono.setText("");
        registrarP.nombre.setText("");
        registrarP.apellido.setText("");
        registrarP.direccion.setText("");
        registrarP.totalPagar.setText("");
        registrarP.totalCliente.setText("");
        pedido.comenzarCosto();
    }

    /**
     * Detecta si se seleccionó algún paquete representado por un checkBox,
     * además se asignará el total de momento calculando el paquete seleccionado
     * y cuantos de estos seleccionó.
     *
     * @param e
     */
    public void eventosJCheckBox(ActionEvent e) {
        if (e.getSource().equals(registrarP.paq1)) {
            if (registrarP.paq1.isSelected()) {
                registrarP.cantPaq1.setEnabled(true);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(0, Integer.parseInt(registrarP.cantPaq1.getValue().toString()))));
            } else {
                registrarP.cantPaq1.setEnabled(false);
                registrarP.cantPaq1.setValue(1);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(0, 0)));
            }
        } else if (e.getSource().equals(registrarP.paq2)) {
            if (registrarP.paq2.isSelected()) {
                registrarP.cantPaq2.setEnabled(true);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(1, Integer.parseInt(registrarP.cantPaq2.getValue().toString()))));
            } else {
                registrarP.cantPaq2.setEnabled(false);
                registrarP.cantPaq2.setValue(1);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(1, 0)));
            }

        } else if (e.getSource().equals(registrarP.paq3)) {
            if (registrarP.paq3.isSelected()) {
                registrarP.cantPaq3.setEnabled(true);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(2, Integer.parseInt(registrarP.cantPaq3.getValue().toString()))));
            } else {
                registrarP.cantPaq3.setEnabled(false);
                registrarP.cantPaq3.setValue(1);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(2, 0)));
            }
        } else if (e.getSource().equals(registrarP.paq4)) {
            if (registrarP.paq4.isSelected()) {
                registrarP.cantPaq4.setEnabled(true);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(3, Integer.parseInt(registrarP.cantPaq4.getValue().toString()))));
            } else {
                registrarP.cantPaq4.setEnabled(false);
                registrarP.cantPaq4.setValue(1);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(3, 0)));
            }
        } else if (e.getSource().equals(registrarP.paq5)) {
            if (registrarP.paq5.isSelected()) {
                registrarP.cantPaq5.setEnabled(true);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(4, Integer.parseInt(registrarP.cantPaq5.getValue().toString()))));
            } else {
                registrarP.cantPaq5.setEnabled(false);
                registrarP.cantPaq5.setValue(1);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(4, 0)));
            }
        } else if (e.getSource().equals(registrarP.paq6)) {
            if (registrarP.paq6.isSelected()) {
                registrarP.cantPaq6.setEnabled(true);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(5, Integer.parseInt(registrarP.cantPaq6.getValue().toString()))));
            } else {
                registrarP.cantPaq6.setEnabled(false);
                registrarP.cantPaq6.setValue(1);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(5, 0)));
            }
        } else if (e.getSource().equals(registrarP.extra1)) {
            if (registrarP.extra1.isSelected()) {
                registrarP.cantExt1.setEnabled(true);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(6, Integer.parseInt(registrarP.cantExt1.getValue().toString()))));
            } else {
                registrarP.cantExt1.setEnabled(false);
                registrarP.cantExt1.setValue(1);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(6, 0)));
            }
        } else if (e.getSource().equals(registrarP.extra2)) {
            if (registrarP.extra2.isSelected()) {
                registrarP.cantExt2.setEnabled(true);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(7, Integer.parseInt(registrarP.cantExt2.getValue().toString()))));
            } else {
                registrarP.cantExt2.setEnabled(false);
                registrarP.cantExt2.setValue(1);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(7, 0)));
            }
        } else if (e.getSource().equals(registrarP.extra3)) {
            if (registrarP.extra3.isSelected()) {
                registrarP.cantExt3.setEnabled(true);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(8, Integer.parseInt(registrarP.cantExt3.getValue().toString()))));
            } else {
                registrarP.cantExt3.setEnabled(false);
                registrarP.cantExt3.setValue(1);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(8, 0)));
            }
        } else if (e.getSource().equals(registrarP.extra4)) {
            if (registrarP.extra4.isSelected()) {
                registrarP.cantExt4.setEnabled(true);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(9, Integer.parseInt(registrarP.cantExt4.getValue().toString()))));
            } else {
                registrarP.cantExt4.setEnabled(false);
                registrarP.cantExt4.setValue(1);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(9, 0)));
            }
        } else if (e.getSource().equals(registrarP.extra5)) {
            if (registrarP.extra5.isSelected()) {
                registrarP.cantExt5.setEnabled(true);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(10, Integer.parseInt(registrarP.cantExt5.getValue().toString()))));
            } else {
                registrarP.cantExt5.setEnabled(false);
                registrarP.cantExt5.setValue(1);
                registrarP.totalPagar.setText(String.valueOf(pedido.calcular(10, 0)));
            }
        }
    }

    /**
     * Verificará el botón que se haya sido presionado, además llamará a otro
     * método para realizar la acción de pagar o buscar.
     *
     * @param e
     * @throws SQLException
     */
    public void eventosJButton(MouseEvent e) throws SQLException {
        if (e.getSource().equals(registrarP.pagarBoton)) {
            accionPagar();
        } else if (e.getSource().equals(registrarP.buscarBoton)) {
            accionBuscar();
        }
    }

    /**
     * Verificará que los campos correspondientes no estén vacíos, de ser así
     * solicitará que ingrese los datos faltanes, sino podrá verificar si el
     * dinero que brinda el cliente es igual o mayor al total para determinar si
     * es necesario regresar cambio. Además recolecta la información del pedido
     * para almacenarlo dentro de la base de datos.
     *
     * @throws SQLException
     */
    public void accionPagar() throws SQLException {
        Icon icono = new ImageIcon(getClass().getResource("../imagenes/pagar.png"));
        Icon icono2 = new ImageIcon(getClass().getResource("../imagenes/cancelar.png"));
        if (JOptionPane.showConfirmDialog(null, "Se efectuara el pago,¿Desea confirmar?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono) == 0) {
            if (!registrarP.totalPagar.getText().isEmpty() && !registrarP.totalCliente.getText().isEmpty() && !registrarP.totalPagar.getText().equals("0")) {
                int total = Integer.parseInt(registrarP.totalCliente.getText()) - Integer.parseInt(registrarP.totalPagar.getText());

                if (total > 0) {
                    sonidoDePago.play();
                    total = abs(total);
                    JOptionPane.showMessageDialog(null, "Gracias por su Compra!\n" + "Cambio: " + total, "Pago Exitoso", JOptionPane.INFORMATION_MESSAGE, icono);
                    registrar();
                    limpiar();
                } else if (total == 0) {
                    sonidoDePago.play();
                    JOptionPane.showMessageDialog(null, "Gracias por su Compra!", "Pago Exitoso", JOptionPane.INFORMATION_MESSAGE, icono);
                    registrar();
                    limpiar();
                } else {
                    sonidoDeError.play();
                    JOptionPane.showMessageDialog(null, "No se ha completado el monto a pagar", "Error", JOptionPane.INFORMATION_MESSAGE, icono2);
                }
            } else {
                sonidoDeError.play();
                JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten ingresados", "Datos faltantes", JOptionPane.INFORMATION_MESSAGE, icono2);
            }
        }
    }

    /**
     * Realizará la búsqueda del cliente con base al número de teléfono. Si el
     * cliente no existe mostrará un mensaje informado sobre esto.
     *
     * @throws SQLException
     */
    public void accionBuscar() throws SQLException {
        BDCliente clientes = new BDCliente();
        Cliente cliente;
        cliente = clientes.buscar(Integer.parseInt(registrarP.numTelefono.getText()));
        if (cliente.getTelefono() != null) {
            registrarP.nombre.setText(cliente.getNombre());
            registrarP.apellido.setText(cliente.getApellido());
            registrarP.direccion.setText(cliente.getDireccion());
        } else {
            JOptionPane.showMessageDialog(null, "No existe un cliente con este número de teléfono", "Consulta", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Realizará el registro del pedido con base a la información recabada del
     * pedido. Si en la búsqueda de cliente no ingresó nada, entonces asumirá
     * los datos de Cliente predeterminado.
     *
     * @throws SQLException
     */
    private void registrar() throws SQLException {
        BDPedido pedidos = new BDPedido();
        String paquete = validarPedido();
        String extra = validarExtra();
        int idCliente;
        long millis = System.currentTimeMillis();
        Date fecha = new Date(millis);
        if (registrarP.nombre.getText().equals("")) {
            idCliente = 1;
        } else {
            idCliente = Integer.parseInt(registrarP.numTelefono.getText());
        }
        pedido.setIdCliente(idCliente);
        pedido.setFecha(String.valueOf(fecha));
        pedido.setPaquete(paquete);
        pedido.setExtra(extra);
        pedidos.agregarDatos(pedido);
    }

    /**
     * Validará la información del pedido de los paquetes para mandarla a la
     * base de datos.
     *
     * @return
     */
    private String validarPedido() {
        String cadena = "";
        if (registrarP.paq1.isSelected()) {
            cadena += registrarP.paq1.getText() + ": " + registrarP.cantPaq1.getValue() + "\n";

        }
        if (registrarP.paq2.isSelected()) {
            cadena += registrarP.paq2.getText() + ": " + registrarP.cantPaq2.getValue() + "\n";
        }
        if (registrarP.paq3.isSelected()) {
            cadena += registrarP.paq3.getText() + ": " + registrarP.cantPaq3.getValue() + "\n";
        }
        if (registrarP.paq4.isSelected()) {
            cadena += registrarP.paq4.getText() + ": " + registrarP.cantPaq4.getValue() + "\n";
        }
        if (registrarP.paq5.isSelected()) {
            cadena += registrarP.paq5.getText() + ": " + registrarP.cantPaq5.getValue() + "\n";
        }
        if (registrarP.paq6.isSelected()) {
            cadena += registrarP.paq6.getText() + ": " + registrarP.cantPaq6.getValue() + "\n";
        }
        return cadena;
    }

    /**
     * Validará la información del pedido de los extras para mandarla a la base
     * de datos.
     *
     * @return
     */
    private String validarExtra() {
        String cadena = "";
        if (registrarP.extra1.isSelected()) {
            cadena += registrarP.extra1.getText() + ": " + registrarP.cantExt1.getValue() + "\n";
        }
        if (registrarP.extra2.isSelected()) {
            cadena += registrarP.extra2.getText() + ": " + registrarP.cantExt2.getValue() + "\n";
        }
        if (registrarP.extra3.isSelected()) {
            cadena += registrarP.extra3.getText() + ": " + registrarP.cantExt3.getValue() + "\n";
        }
        if (registrarP.extra4.isSelected()) {
            cadena += registrarP.extra4.getText() + ": " + registrarP.cantExt4.getValue() + "\n";
        }
        if (registrarP.extra5.isSelected()) {
            cadena += registrarP.extra5.getText() + ": " + registrarP.cantExt5.getValue() + "\n";
        }
        return cadena;
    }

    /**
     * KeyTyped primero verificará sobre que campo de texto se está escribiendo,
     * dependiendo de esto permitirá el uso de solo números en el caso para el
     * número de teléfono, letras y espacios para nombre y apellido, y en
     * dirreción puede incluir números, letras, espacios y comas.
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
        char car = e.getKeyChar();
        if (e.getSource().equals(registrarP.numTelefono) || e.getSource().equals(registrarP.totalCliente)) {
            if (!Character.isDigit(car)) {
                e.consume();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }
}
