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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vistas.ConsultarClientePanel;
import vistas.MenuConsultarPanel;

/**
 *
 * @author kevin
 */
public class ControladorMenuConsultar implements MouseListener {

    private final AudioClip sonidoDeBoton; //Audio para los botones
    private final AudioClip sonidoDeRegresar; //Audio reproducido para salir
    private final JPanel principal; //Panel de la ventana de menú principal
    private final MenuConsultarPanel menuConsultar;
    private final ConsultarClientePanel cClienteP;

    public ControladorMenuConsultar(MenuConsultarPanel menuConsultar, AudioClip sonidoDeBoton, AudioClip sonidoDeRegresar, JPanel principal) {
        this.menuConsultar = menuConsultar;
        this.principal = principal;
        this.sonidoDeBoton = sonidoDeBoton;
        this.sonidoDeRegresar = sonidoDeRegresar;
        cClienteP = new ConsultarClientePanel(sonidoDeBoton,sonidoDeRegresar,menuConsultar);
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
            tipoConsulta(e);
        } else if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JLabel")) {
            Icon icono = new ImageIcon(getClass().getResource("../imagenes/regreso.png"));
            sonidoDeRegresar.play();
            if (JOptionPane.showConfirmDialog(null, "¿Desea regresar al menu principal?", "Regresar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono) == 0) {
                menuConsultar.setVisible(false);
                principal.setVisible(true);
            }
        }
    }
    
    public void tipoConsulta(MouseEvent e){
        if(e.getSource().getClass().getTypeName().equals(menuConsultar.izquierdaJPanel)){
         principal.;
         cClienteP.setSize(1045, 533); //Tamaño de la ventana asignada al JPanel
         menuConsultar.setVisible(false);
         cClienteP.setVisible(true);
        }else if(e.getSource().getClass().getTypeName().equals(menuConsultar.derechaJPanel)){
            
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

}
