/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author magdielo-pacheco
 */
public class ControladorMenuPrincipal implements MouseListener {

    private final PrincipalFrame menu;
    private final AudioClip sonidoDeBoton;
    private final AudioClip sonidoDeSalir;
    private final JPanel registrarPedido;
    private final JPanel registrarCliente;

    public ControladorMenuPrincipal(PrincipalFrame menu, AudioClip sonidoBoton, AudioClip salir, JPanel registrarCliente, JPanel registrarPedido) {
        this.menu = menu;
        sonidoDeBoton = sonidoBoton;
        sonidoDeSalir = salir;
        this.registrarCliente = registrarCliente;
        this.registrarPedido = registrarPedido;
        iniciarlizar();
    }

    private void iniciarlizar() {
        Connection con=Conexion.getConnection();
        //Botones
        menu.registroPedidoBoton.addMouseListener(this);
        menu.registroClienteBoton.addMouseListener(this);
        menu.consultarBoton.addMouseListener(this);
        menu.corteBoton.addMouseListener(this);

        //Imagen
        menu.salirImagen.addMouseListener(this);
    }

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

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(menu.registroPedidoBoton)) {
            menu.registroPedidoBoton.setBackground(new Color(0, 51, 51));
        } else if (e.getSource().equals(menu.registroClienteBoton)) {
            menu.registroClienteBoton.setBackground(new Color(0, 51, 51));
        }else if (e.getSource().equals(menu.consultarBoton)) {
            menu.consultarBoton.setBackground(new Color(0, 51, 51));
        }else if (e.getSource().equals(menu.corteBoton)) {
            menu.corteBoton.setBackground(new Color(0, 51, 51));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

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

        } else if (e.getSource().equals(menu.corteBoton)) {

        }
    }
}
