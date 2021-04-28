/*
 * Controlador encargado de realizar todas las acciones necesarias para 
 * llevar a cabo la interaccion entre el cliente y el menu principal que se 
 * estara mostrando.
 * Para esto se implemento la clase de MouseListener y asi tener una interaccion 
 * mas amigable con el cliente.
 */
package controladores;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vistas.PrincipalFrame;
import modelos.Conexion;
import vistas.CortePanel;

/**
 * @author Pacheco Magdiel
 * @version 16-04-2021
 */
public class ControladorMenuPrincipal implements MouseListener {

    private final PrincipalFrame menu;
    private final AudioClip sonidoDeBoton;
    private final AudioClip sonidoDeSalir;
    private final JPanel registrarPedido;
    private final JPanel registrarCliente;
    private final JPanel menuConsultar;
    private final CortePanel corte;

    /**
     * Constructor de la clase con parametros inicializados
     *
     * @param menu Frame del menu principal
     * @param sonidoBoton Sonido integrado al momento de pasar el cursos por un
     * boton
     * @param salir Sonido integrado al momento de salir de la interfaz
     * @param registrarCliente JPanel utilizado para el registro del cliente
     * @param registrarPedido JPanel utilizado para el registro del pedido
     * @param menuConsultar
     * @param corte
     */
    public ControladorMenuPrincipal(PrincipalFrame menu, AudioClip sonidoBoton, AudioClip salir, JPanel registrarCliente, JPanel registrarPedido, JPanel menuConsultar, CortePanel corte) {
        this.menu = menu;
        sonidoDeBoton = sonidoBoton;
        sonidoDeSalir = salir;
        this.registrarCliente = registrarCliente;
        this.registrarPedido = registrarPedido;
        this.menuConsultar = menuConsultar;
        this.corte = corte;
        inicializar();
    }

    /**
     * Metodo principal para realizar la inicializacion de conexion hacia la
     * base de datos al igual que la implementacion de MouseListeners para cada
     * uno de los botones/imagenes inlcuidos
     */
    private void inicializar() {
        Conexion.getConnection();
        //Botones
        menu.registroPedidoBoton.addMouseListener(this);
        menu.registroClienteBoton.addMouseListener(this);
        menu.consultarBoton.addMouseListener(this);
        menu.corteBoton.addMouseListener(this);

        //Imagen
        menu.salirImagen.addMouseListener(this);
    }

    /**
     * Metodo utilizado para los eventos relacionados con el click del mouse,
     * dentro de el se presenta una condicion para diferenciar el estilo de
     * componente Swing utilizado y asi aplicarle el evento especial para el.
     * Para el caso de los botones se estara implementando el metodo
     * eventosJButton y para el caso de los labels, se presentara un mensaje de
     * confirmacion
     *
     * @param e Parametro utilizado para asignar el evento del mouse
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JButton")) {
            try {
                eventosJButton(e);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JLabel")) {
            Icon icono = new ImageIcon(getClass().getResource("../imagenes/salir.png"));
            sonidoDeSalir.play();
            if (JOptionPane.showConfirmDialog(null, "¿Desea finalizar el programa?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono) == 0) {
                try {
                    Conexion.desconectar();
                } catch (SQLException ex) {
                    Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);
            }
        }
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
        if (e.getSource().equals(menu.registroPedidoBoton)) {
            menu.registroPedidoBoton.setBackground(new Color(0, 102, 102));
            sonidoDeBoton.play();
        } else if (e.getSource().equals(menu.registroClienteBoton)) {
            menu.registroClienteBoton.setBackground(new Color(0, 102, 102));
            sonidoDeBoton.play();
        } else if (e.getSource().equals(menu.consultarBoton)) {
            menu.consultarBoton.setBackground(new Color(0, 102, 102));
            sonidoDeBoton.play();
        } else if (e.getSource().equals(menu.corteBoton)) {
            menu.corteBoton.setBackground(new Color(0, 102, 102));
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
        if (e.getSource().equals(menu.registroPedidoBoton)) {
            menu.registroPedidoBoton.setBackground(new Color(0, 51, 51));
        } else if (e.getSource().equals(menu.registroClienteBoton)) {
            menu.registroClienteBoton.setBackground(new Color(0, 51, 51));
        } else if (e.getSource().equals(menu.consultarBoton)) {
            menu.consultarBoton.setBackground(new Color(0, 51, 51));
        } else if (e.getSource().equals(menu.corteBoton)) {
            menu.corteBoton.setBackground(new Color(0, 51, 51));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Metodo utilizado para ser asignado a cada uno de los botones, los cuales
     * estaran presentando las diferentes vistas para el caso de Registrar
     * Pedido al igual que para registrar clientes.
     *
     * @param e Parametro utilizado para asignar el evento del mouse
     * @throws SQLException
     */
    public void eventosJButton(MouseEvent e) throws SQLException {
        if (e.getSource().equals(menu.registroPedidoBoton)) {
            menu.getContentPane().add(registrarPedido);
            registrarPedido.setSize(1045, 533); //Tamaño de la ventana asignada al JPanel
            menu.fondoJPanel.setVisible(false);
            registrarPedido.setVisible(true);
        } else if (e.getSource().equals(menu.registroClienteBoton)) {
            menu.getContentPane().add(registrarCliente);
            registrarCliente.setSize(1045, 490); //Tamaño de la ventana asignada al JPanel
            menu.fondoJPanel.setVisible(false);
            registrarCliente.setVisible(true);
        } else if (e.getSource().equals(menu.consultarBoton)) {
            menu.getContentPane().add(menuConsultar);
            menuConsultar.setSize(1045, 533); //Tamaño de la ventana asignada al JPanel
            menu.fondoJPanel.setVisible(false);
            menuConsultar.setVisible(true);
        } else if (e.getSource().equals(menu.corteBoton)) {
            corte.cCorte.iniciarTabla();
            if (corte.tablaCorte.getRowCount() != 0) {
                menu.getContentPane().add(corte);
                corte.setSize(1045, 533); //Tamaño de la ventana asignada al JPanel
                menu.fondoJPanel.setVisible(false);
                corte.setVisible(true);
            } else {
                Icon icono = new ImageIcon(getClass().getResource("../imagenes/cancelar.png"));
                JOptionPane.showMessageDialog(null, "No se han registrado pedidos", "Sin pedidos", JOptionPane.INFORMATION_MESSAGE, icono);
            }
        }
    }
}
