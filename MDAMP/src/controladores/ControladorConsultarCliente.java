/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.applet.AudioClip;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import vistas.ConsultarClientePanel;

/**
 *
 * @author kevin
 */
public class ControladorConsultarCliente implements MouseListener {

    private final AudioClip sonidoDeBoton; //Audio para los botones
    private final AudioClip sonidoDeRegresar; //Audio reproducido para salir
    private final JPanel mConsultar; //Panel de la ventana de menú principal
    private final ConsultarClientePanel consultarCliente;

    public ControladorConsultarCliente(ConsultarClientePanel consultarCliente, AudioClip sonidoDeBoton, AudioClip sonidoDeRegresar, JPanel mConsultar) {
        this.consultarCliente = consultarCliente;
        this.mConsultar = mConsultar;
        this.sonidoDeBoton = sonidoDeBoton;
        this.sonidoDeRegresar = sonidoDeRegresar;
        inicializar();
    }
    
    public void inicializar(){
                
        //Imagen
        consultarCliente.regresarImagen.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
