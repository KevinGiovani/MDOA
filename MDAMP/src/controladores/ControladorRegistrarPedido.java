/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 */
public class ControladorRegistrarPedido implements ActionListener, MouseListener, ChangeListener, KeyListener {

    private RegistrarPedidoPanel registrarP;
    private Pedido pedido;
    private final AudioClip sonidoDePago;
    private final AudioClip sonidoDeError;
    private final AudioClip sonidoDeBoton;
    private final AudioClip sonidoDeRegresar;
    private JPanel principal;

    public ControladorRegistrarPedido(RegistrarPedidoPanel registrarP, AudioClip sonidoDeBoton, AudioClip sonidoDeRegresar, JPanel principal) {
        pedido= new Pedido();
        sonidoDePago = java.applet.Applet.newAudioClip(getClass().getResource("../sonidos/pago-realizado.wav"));
        sonidoDeError = java.applet.Applet.newAudioClip(getClass().getResource("../sonidos/errorSonido.wav"));
        this.registrarP = registrarP;
        this.sonidoDeBoton = sonidoDeBoton;
        this.sonidoDeRegresar = sonidoDeRegresar;
        this.principal = principal;
        iniciar();
    }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JCheckBox")) {
            eventosJCheckBox(e);
        }
    }

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

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(registrarP.pagarBoton)) {
            registrarP.pagarBoton.setBackground(new Color(0, 51, 51));
        } else if (e.getSource().equals(registrarP.buscarBoton)) {
            registrarP.buscarBoton.setBackground(new Color(0, 51, 51));
        }
    }

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

    public void eventosJButton(MouseEvent e) throws SQLException {
        if (e.getSource().equals(registrarP.pagarBoton)) {
          accionPagar();
        }else if (e.getSource().equals(registrarP.buscarBoton)){
          accionBuscar();
        }
    }

    public void accionPagar() throws SQLException {
        Icon icono = new ImageIcon(getClass().getResource("../imagenes/pagar.png"));
        Icon icono2 = new ImageIcon(getClass().getResource("../imagenes/cancelar.png"));
        if (JOptionPane.showConfirmDialog(null, "Se efectuara el pago,¿Desea confirmar?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono) == 0) {
        if (!registrarP.totalPagar.getText().isEmpty() && !registrarP.totalCliente.getText().isEmpty()) {
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
    
    public void accionBuscar() throws SQLException{
        BDCliente clientes = new BDCliente();
        Cliente cliente;
        cliente = clientes.buscar(Integer.parseInt(registrarP.numTelefono.getText()));
        registrarP.nombre.setText(cliente.getNombre());
        registrarP.apellido.setText(cliente.getApellido());
        registrarP.direccion.setText(cliente.getDireccion());
    }

    private void registrar() throws SQLException {
        BDPedido pedidos = new BDPedido(); //ESTO NO VA AQUI!!!!
        String paquete = validarPedido();
        String extra = validarExtra();
        int idCliente;
        long millis = System.currentTimeMillis();
        Date fecha = new Date(millis);
        if (registrarP.numTelefono.getText().equals("")) {
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
