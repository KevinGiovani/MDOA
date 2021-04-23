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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import vistas.ConsultarClientePanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.BDCliente;
import modelos.Cliente;

/**
 *
 * @author kevin
 */
public class ControladorConsultarCliente implements MouseListener,KeyListener {

    private final AudioClip sonidoDeBoton; //Audio para los botones
    private final AudioClip sonidoDeRegresar; //Audio reproducido para salir
    private final JPanel mConsultar; //Panel de la ventana de menú principal
    private final ConsultarClientePanel consultarCliente;
    private DefaultTableModel modelo;

    public ControladorConsultarCliente(ConsultarClientePanel consultarCliente, AudioClip sonidoDeBoton, AudioClip sonidoDeRegresar, JPanel mConsultar) throws SQLException {
        this.consultarCliente = consultarCliente;
        this.mConsultar = mConsultar;
        this.sonidoDeBoton = sonidoDeBoton;
        this.sonidoDeRegresar = sonidoDeRegresar;
        
        inicializar();
    }

    public void inicializar() throws SQLException {
        iniciarTabla();
        //Botones
        consultarCliente.buscar.addMouseListener(this);
        consultarCliente.cancelar.addMouseListener(this);
        //Imagen
        consultarCliente.regresarImagen.addMouseListener(this);
        //Campos de texto
        consultarCliente.telefono.addKeyListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JButton")) {
            try {
                eventosJButton(e);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JLabel")) {
            Icon icono = new ImageIcon(getClass().getResource("../imagenes/regreso.png"));
            sonidoDeRegresar.play();
            if (JOptionPane.showConfirmDialog(null, "¿Desea regresar al menu de consultas?", "Regresar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono) == 0) {
                consultarCliente.setVisible(false);
                try {
                    cancelar();
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                mConsultar.setVisible(true);
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
        if (e.getSource().equals(consultarCliente.buscar)) {
            consultarCliente.buscar.setBackground(new Color(0, 102, 102));
            sonidoDeBoton.play();
        } else if (e.getSource().equals(consultarCliente.cancelar)) {
            consultarCliente.cancelar.setBackground(new Color(0, 102, 102));
            sonidoDeBoton.play();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(consultarCliente.buscar)) {
            consultarCliente.buscar.setBackground(new Color(0, 51, 51));
        } else if (e.getSource().equals(consultarCliente.cancelar)) {
            consultarCliente.cancelar.setBackground(new Color(0, 51, 51));
        }
    }

    public void consultar() throws SQLException {
        BDCliente bd = new BDCliente();
        ArrayList<Cliente> clientes;
        clientes = bd.consultar();

        for (int i = 0; i < clientes.size(); i++) {
            Object info[] = {clientes.get(i).getNombre(), clientes.get(i).getApellido(), clientes.get(i).getTelefono(), clientes.get(i).getDireccion()};
            modelo.addRow(info);
        }

    }

    public void iniciarTabla() throws SQLException {
        modelo = new DefaultTableModel();
        consultarCliente.tablaClientes.setModel(modelo);
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Dirección");
        for (int i = 0; i < 3; i++) {
            consultarCliente.tablaClientes.getColumnModel().getColumn(i).setMinWidth(100);
            consultarCliente.tablaClientes.getColumnModel().getColumn(i).setMaxWidth(100);
        }
        consultar();
    }

    public void buscar(long tel) throws SQLException {
        BDCliente bd = new BDCliente();
        Cliente cliente = bd.buscar(tel);
        if (cliente.getTelefono() != null) {
            Object info[] = {cliente.getNombre(), cliente.getApellido(), cliente.getTelefono(), cliente.getDireccion()};
            modelo.setRowCount(0);
            modelo.addRow(info);
        }else{
            JOptionPane.showMessageDialog(null, "No existe un cliente con este número de teléfono", "Consulta", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void cancelar() throws SQLException {
        modelo.setRowCount(0);
        consultarCliente.telefono.setText(null);
        consultar();
    }

    public void buscarCliente() throws SQLException {
        if (!consultarCliente.telefono.getText().isEmpty()) {
            buscar(Long.parseLong(consultarCliente.telefono.getText()));

        } else {
            Icon icono = new ImageIcon(getClass().getResource("../imagenes/cancelar.png"));
            JOptionPane.showMessageDialog(null, "Verifique que el número de teléfono sea el correcto", "Datos faltantes", JOptionPane.INFORMATION_MESSAGE, icono);
        }
    }

    public void eventosJButton(MouseEvent e) throws SQLException {
        if (e.getSource().equals(consultarCliente.buscar)) {
            buscarCliente();
        } else if (e.getSource().equals(consultarCliente.cancelar)) {
            cancelar();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char car = e.getKeyChar();
        if (e.getSource().equals(consultarCliente.telefono)) {
            if (!Character.isDigit(car)) {
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
