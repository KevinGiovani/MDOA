/**
 * Este controlador se encarga de manejar los MouseListeners,
 * algunos aspectos visuales que normalmente se aplican en el JFrame.
 * También permite realizar la seleccion de el tipo de consulta que se plantea 
 * realizar para ser observada en la vista de consultas.
 */
package controladores;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import vistas.ConsultarPanel;
import vistas.MenuConsultarPanel;
import vistas.PrincipalFrame;

/**
 *
 * @author Inzunza Kevin
 * @author De La Cruz Joel
 * @author Pacheco Cesar
 * @version 23-04-2021
 */
public class ControladorMenuConsultar implements MouseListener {

    private final AudioClip sonidoDeBoton; //Audio para los botones
    private final AudioClip sonidoDeRegresar; //Audio reproducido para salir
    private final PrincipalFrame principal; //Panel de la ventana de menú principal
    private final MenuConsultarPanel menuConsultar;
    private final ConsultarPanel cClienteP;

    /**
     * Constuctor que recibe parámetros desde el JPanel del menu principal,
     * además inicializa los eventos para el Mouse Listener.
     * 
     * @param menuConsultar
     * @param sonidoDeBoton
     * @param sonidoDeRegresar
     * @param principal
     * @throws SQLException
     */
    public ControladorMenuConsultar(MenuConsultarPanel menuConsultar, AudioClip sonidoDeBoton, AudioClip sonidoDeRegresar, PrincipalFrame principal) throws SQLException {
        this.menuConsultar = menuConsultar;
        this.principal = principal;
        this.sonidoDeBoton = sonidoDeBoton;
        this.sonidoDeRegresar = sonidoDeRegresar;
        cClienteP = new ConsultarPanel(sonidoDeBoton, sonidoDeRegresar, menuConsultar);
        inicializar();
    }
    
        /**
         * Da inicio a los eventos que pueden ser realizados por el mouse
         */
    public void inicializar() {
        //JPanel
        menuConsultar.derechaJPanel.addMouseListener(this);
        menuConsultar.izquierdaJPanel.addMouseListener(this);

        //Imagen
        menuConsultar.regresarImagen.addMouseListener(this);
    }
    /**
     *  Este método detecta a que botón hizo clic llamando a otro método para los
     * eventos de botón, si no fue el caso verificará si hizo clic hacia la
     * etiqueta que representa regresar al menú principal.
     *
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JPanel")) {
            try {
                tipoConsulta(e);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorMenuConsultar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JLabel")) {
            Icon icono = new ImageIcon(getClass().getResource("../imagenes/regreso.png"));
            sonidoDeRegresar.play();
            if (JOptionPane.showConfirmDialog(null, "¿Desea regresar al menu principal?", "Regresar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono) == 0) {
                menuConsultar.setVisible(false);
                principal.fondoJPanel.setVisible(true);
            }
        }
    }
    
    /**
     * Detectará cual fue la consulta seleccionada por el usuario con el propósito
     * de preparar la ventana para mostrar los datos que está buscando.
     * @param e
     * @throws SQLException 
     */
    public void tipoConsulta(MouseEvent e) throws SQLException {
        if (e.getSource().equals(menuConsultar.izquierdaJPanel)) {
            cClienteP.getCConsulta().inicializar(true);
            if (cClienteP.tablaConsultas.getRowCount() != 0) {
                principal.getContentPane().add(cClienteP);
                cClienteP.setSize(1045, 533); //Tamaño de la ventana asignada al JPanel
                menuConsultar.setVisible(false);
                mostrar(false, "Número de Teléfono", "Consultar Cliente");
                cClienteP.setVisible(true);
            } else {
                Icon icono = new ImageIcon(getClass().getResource("../imagenes/cancelar.png"));
                JOptionPane.showMessageDialog(null, "No se han registrado clientes", "Sin registro", JOptionPane.INFORMATION_MESSAGE, icono);
            }

        } else if (e.getSource().equals(menuConsultar.derechaJPanel)) {
            cClienteP.getCConsulta().inicializar(false);
            if (cClienteP.tablaConsultas.getRowCount() != 0) {
                mostrar(true, "Campo de búsqueda", "Consultar Pedido");
                principal.getContentPane().add(cClienteP);
                menuConsultar.setVisible(false);
                cClienteP.setSize(1045, 533); //Tamaño de la ventana asignada al JPanel
                cClienteP.setVisible(true);
            } else {
                Icon icono = new ImageIcon(getClass().getResource("../imagenes/cancelar.png"));
                JOptionPane.showMessageDialog(null, "No se han registrado pedidos", "Sin registro", JOptionPane.INFORMATION_MESSAGE, icono);
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
     *  MouseEntered detectará cuando el mouse está sobre algún botón y cual de
     * estos fue, cambiando el color de fondo del botón y reproduciendo un
     * sonido.
     *
     * @param e 
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(menuConsultar.derechaJPanel)) {
            menuConsultar.derechaJPanel.setBackground(new Color(0, 153, 153));
            sonidoDeBoton.play();
        } else if (e.getSource().equals(menuConsultar.izquierdaJPanel)) {
            menuConsultar.izquierdaJPanel.setBackground(new Color(0, 153, 153));
            sonidoDeBoton.play();
        }
    }
    
    /**
     * MouseExited detecta cuando el mouse ya no se encuentra dentro del botón
     * por lo que regresará el estado en el que se encontraba originalmente
     * @param e 
     */
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(menuConsultar.derechaJPanel)) {
            menuConsultar.derechaJPanel.setBackground(new Color(0, 102, 102));
        } else if (e.getSource().equals(menuConsultar.izquierdaJPanel)) {
            menuConsultar.izquierdaJPanel.setBackground(new Color(0, 102, 102));
        }
    }

    /**
     * Se determinará que elementos serán visibles y que se mostrará en pantalla,
     * esto dependiendo de la elección del usuario
     * @param estado
     * @param campo
     * @param titulo 
     */
    public void mostrar(Boolean estado, String campo, String titulo) {
        cClienteP.nPedido.setVisible(estado);
        cClienteP.nTelefono.setVisible(estado);
        cClienteP.campo.setText(campo);
        cClienteP.manejoOTexto.setText(titulo);
    }
}
