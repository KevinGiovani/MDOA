/**
 * Este controlador se encarga de manejar los Mouse Listeners y Key Listeners,
 * algunos aspectos visuales que normalmente se aplican en el JFrame.
 * También permite realizar el registro de la información de un nuevo cliente
 * hacia una base de datos manejado por MySQL.
 * */
package controladores;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelos.BDCliente;
import modelos.Cliente;
import vistas.RegistrarClientePanel;

/**
 * @author Inzunza Kevin
 * @version 16-04-2021
 */
public class ControladorRegistrarCliente implements MouseListener, KeyListener {

    private RegistrarClientePanel registrarC; //Referencia del panel visual de Cliente
    private final AudioClip sonidoDeBoton; //Audio para los botones
    private final AudioClip sonidoDeRegresar; //Audio reproducido para salir
    private final JPanel principal; //Panel de la ventana de menú principal

    /**
     * Constuctor que recibe parámetros desde el JPanel de registrar cliente,
     * además inicializa los eventos para el mouse y las teclas del computador.
     *
     * @param registrarC
     * @param sonidoDeBoton
     * @param sonidoDeRegresar
     * @param principal
     */
    public ControladorRegistrarCliente(RegistrarClientePanel registrarC, AudioClip sonidoDeBoton, AudioClip sonidoDeRegresar, JPanel principal) {
        this.principal = principal;
        this.registrarC = registrarC;
        this.sonidoDeBoton = sonidoDeBoton;
        this.sonidoDeRegresar = sonidoDeRegresar;
        inicializar();
    }

    /**
     * Este método permite añadir los MouseListener para los botones de la
     * ventana y KeyListener para los campos de texto.
     */
    public void inicializar() {
        //Botones
        registrarC.aceptarBoton.addMouseListener(this);
        registrarC.cancelarBoton.addMouseListener(this);

        //JTextfield
        registrarC.numTelefono.addKeyListener(this);
        registrarC.nombre.addKeyListener(this);
        registrarC.apellido.addKeyListener(this);
        registrarC.direccion.addKeyListener(this);

        //Imagen
        registrarC.regresarImagen.addMouseListener(this);
    }

    /**
     * Este método detecta a que botón hizo clic llamando a otro método para los
     * eventos de botón, si no fue el caso verificará si hizo clic hacia la
     * etiqueta que representa regresar al menú principal.
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JButton")) {
            try {
                eventosJButton(e);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRegistrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JLabel")) {
            Icon icono = new ImageIcon(getClass().getResource("../imagenes/regreso.png"));
            sonidoDeRegresar.play();
            if (JOptionPane.showConfirmDialog(null, "¿Desea regresar al menu principal?", "Regresar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono) == 0) {
                registrarC.setVisible(false);
                principal.setVisible(true);
            }
        }
    }

    /**
     * Verifica si el botón presionado fue aceptar o cancelar mediante el uso de
     * condiciones, donde dependiendo de la condición que se cumpla dirigirá a
     * su método correspondiente para realizar su acción descrita.
     *
     * @param e
     * @throws SQLException
     */
    public void eventosJButton(MouseEvent e) throws SQLException {
        if (e.getSource().equals(registrarC.aceptarBoton)) {
            aceptar();
        } else if (e.getSource().equals(registrarC.cancelarBoton)) {
            Icon icono = new ImageIcon(getClass().getResource("../imagenes/cancelar.png"));
            if (JOptionPane.showConfirmDialog(null, "¿Desea cancelar el registro del cliente?", "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono) == 0) {
                limpiar();
            }
        }
    }

    /**
     * El método aceptar primero validará que los campos no estén vacíos, de ser
     * esto falso permitirá registrar un nuevo cliente en la base de datos, si
     * resultó ser verdadero entonces el sistema solicitará que ingrese todos
     * los campos que se encuentren vacíos. El usuario también puede seleccionar
     * si realmente desea registrar.
     *
     * @throws SQLException
     */
    public void aceptar() throws SQLException {
        if (!registrarC.nombre.getText().isEmpty() && !registrarC.apellido.getText().isEmpty() && !registrarC.numTelefono.getText().isEmpty() && !registrarC.direccion.getText().isEmpty()) {
            Icon icono = new ImageIcon(getClass().getResource("../imagenes/usuarioOk.png"));
            if (JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea registrarse?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono) == 0) {
                BDCliente clientes = new BDCliente(); //ESTE NO VA AQUI!!!!
                Cliente cliente = new Cliente(registrarC.nombre.getText(), registrarC.apellido.getText(), registrarC.numTelefono.getText(), registrarC.direccion.getText());
                Cliente busqueda = clientes.buscar(Integer.parseInt(cliente.getTelefono()));
                if (busqueda.getTelefono() != null && busqueda.getTelefono().equals(cliente.getTelefono())) {
                    JOptionPane.showMessageDialog(null, "Este número de teléfono ya existe", "consulta", JOptionPane.WARNING_MESSAGE);
                } else {
                    clientes.agregarDatos(cliente);
                    JOptionPane.showMessageDialog(null, "Operación Exitosa", "Datos agregados", JOptionPane.INFORMATION_MESSAGE, icono);
                    limpiar();
                }
            }
        } else {
            Icon icono = new ImageIcon(getClass().getResource("../imagenes/cancelar.png"));
            JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten ingresados", "Datos faltantes", JOptionPane.INFORMATION_MESSAGE, icono);
        }
    }

    /**
     * Limpiar hace que los campos de textos regresen a su estado principal, en
     * este caso vacío.
     */
    public void limpiar() {
        registrarC.nombre.setText(null);
        registrarC.apellido.setText(null);
        registrarC.numTelefono.setText(null);
        registrarC.direccion.setText(null);
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
        if (e.getSource().equals(registrarC.aceptarBoton)) {
            registrarC.aceptarBoton.setBackground(new Color(0, 102, 102));
            sonidoDeBoton.play();
        } else if (e.getSource().equals(registrarC.cancelarBoton)) {
            registrarC.cancelarBoton.setBackground(new Color(0, 102, 102));
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
        if (e.getSource().equals(registrarC.aceptarBoton)) {
            registrarC.aceptarBoton.setBackground(new Color(0, 51, 51));
        } else if (e.getSource().equals(registrarC.cancelarBoton)) {
            registrarC.cancelarBoton.setBackground(new Color(0, 51, 51));
        }
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
        if (e.getSource().equals(registrarC.numTelefono)) {
            if (!Character.isDigit(car)) {
                e.consume();
            }
        } else if (e.getSource().equals(registrarC.nombre) || e.getSource().equals(registrarC.apellido)) {
            if (!Character.isLetter(car) && !Character.isWhitespace(car)) {
                e.consume();
            }
        } else if (e.getSource().equals(registrarC.direccion)) {
            if (!Character.isLetter(car) && !Character.isWhitespace(car) && !Character.isDigit(car) && car != '#' && car != ',') {
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
