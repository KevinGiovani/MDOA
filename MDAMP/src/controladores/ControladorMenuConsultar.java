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
 * @author kevin
 */
public class ControladorMenuConsultar implements MouseListener {

    private final AudioClip sonidoDeBoton; //Audio para los botones
    private final AudioClip sonidoDeRegresar; //Audio reproducido para salir
    private final PrincipalFrame principal; //Panel de la ventana de menú principal
    private final MenuConsultarPanel menuConsultar;
    private final ConsultarPanel cClienteP;

    public ControladorMenuConsultar(MenuConsultarPanel menuConsultar, AudioClip sonidoDeBoton, AudioClip sonidoDeRegresar, PrincipalFrame principal) throws SQLException {
        this.menuConsultar = menuConsultar;
        this.principal = principal;
        this.sonidoDeBoton = sonidoDeBoton;
        this.sonidoDeRegresar = sonidoDeRegresar;
        cClienteP = new ConsultarPanel(sonidoDeBoton, sonidoDeRegresar, menuConsultar);
        inicializar();
    }

    public void inicializar() {
        //JPanel
        menuConsultar.derechaJPanel.addMouseListener(this);
        menuConsultar.izquierdaJPanel.addMouseListener(this);

        //Imagen
        menuConsultar.regresarImagen.addMouseListener(this);
    }

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

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(menuConsultar.derechaJPanel)) {
            menuConsultar.derechaJPanel.setBackground(new Color(0, 102, 102));
        } else if (e.getSource().equals(menuConsultar.izquierdaJPanel)) {
            menuConsultar.izquierdaJPanel.setBackground(new Color(0, 102, 102));
        }
    }

    public void mostrar(Boolean estado, String campo, String titulo) {
        cClienteP.nPedido.setVisible(estado);
        cClienteP.nTelefono.setVisible(estado);
        cClienteP.campo.setText(campo);
        cClienteP.manejoOTexto.setText(titulo);
    }
}
