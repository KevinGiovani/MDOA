/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelos.BDCliente;
import modelos.Cliente;
import vistas.RegistrarClientePanel;

/**
 *
 * @author kevin
 */
public class ControladorRegistrarCliente implements MouseListener,KeyListener{

    private RegistrarClientePanel registrarC;
    private final AudioClip sonidoDeBoton;
    private final AudioClip sonidoDeRegresar;
    private final JPanel principal;

    public ControladorRegistrarCliente(RegistrarClientePanel registrarC, AudioClip sonidoDeBoton, AudioClip sonidoDeRegresar, JPanel principal) {
        this.principal = principal;
        this.registrarC = registrarC;
        this.sonidoDeBoton = sonidoDeBoton;
        this.sonidoDeRegresar = sonidoDeRegresar;
        inicializar();
    }

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


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JButton")) {
            eventosJButton(e);
        } else if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JLabel")) {
            Icon icono = new ImageIcon(getClass().getResource("../imagenes/regreso.png"));
            sonidoDeRegresar.play();
            if (JOptionPane.showConfirmDialog(null, "¿Desea regresar al menu principal?", "Regresar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono) == 0) {
                registrarC.setVisible(false);
                principal.setVisible(true);
            }
        }
    }

    public void eventosJButton(MouseEvent e) {
        if (e.getSource().equals(registrarC.aceptarBoton)) {
            aceptar();
        } else if (e.getSource().equals(registrarC.cancelarBoton)) {
            Icon icono = new ImageIcon(getClass().getResource("../imagenes/cancelar.png"));
            if (JOptionPane.showConfirmDialog(null, "¿Desea cancelar el registro del cliente?", "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono) == 0) {
                limpiar();
            }
        }
    }

    public void aceptar() {
        if (!registrarC.nombre.getText().isEmpty() && !registrarC.apellido.getText().isEmpty() && !registrarC.numTelefono.getText().isEmpty() && !registrarC.direccion.getText().isEmpty()) {
            Icon icono = new ImageIcon(getClass().getResource("../imagenes/usuarioOk.png"));
            if(JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea registrarse?", "Confirmacion", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icono)==0){
            BDCliente clientes = new BDCliente(); //ESTE NO VA AQUI!!!!
            Cliente cliente = new Cliente(registrarC.nombre.getText(), registrarC.apellido.getText(), registrarC.numTelefono.getText(), registrarC.direccion.getText());
            clientes.agregarDatos(cliente);
            JOptionPane.showMessageDialog(null, "Operación Exitosa", "Datos agregados", JOptionPane.INFORMATION_MESSAGE, icono);
            limpiar();
            }
        } else {
            Icon icono = new ImageIcon(getClass().getResource("../imagenes/cancelar.png"));
            JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten ingresados", "Datos faltantes", JOptionPane.INFORMATION_MESSAGE, icono);
        }
    }

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

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(registrarC.aceptarBoton)) {
            registrarC.aceptarBoton.setBackground(new Color(0, 51, 51));
        } else if (e.getSource().equals(registrarC.cancelarBoton)) {
            registrarC.cancelarBoton.setBackground(new Color(0, 51, 51));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
         char car = e.getKeyChar();
        if (e.getSource().equals(registrarC.numTelefono)) {
            if (!Character.isDigit(car)) {
                e.consume();
            }
        }else if(e.getSource().equals(registrarC.nombre) || e.getSource().equals(registrarC.apellido)) {
            if (!Character.isLetter(car) && !Character.isWhitespace(car)) {
                e.consume();
            }
        }else if(e.getSource().equals(registrarC.direccion)) {
            if (!Character.isLetter(car) && !Character.isWhitespace(car) && !Character.isDigit(car) && car!='#' && car!=',') {
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
