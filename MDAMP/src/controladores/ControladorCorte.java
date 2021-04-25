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
import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.BDPedido;
import modelos.Pedido;
import vistas.CortePanel;



/**
 *
 * @author kevin
 */
public class ControladorCorte implements MouseListener {

    private final AudioClip sonidoDeBoton; //Audio para los botones
    private final AudioClip sonidoDeRegresar; //Audio reproducido para salir
    private final JPanel mPrincipal; //Panel de la ventana de menú principal
    private final CortePanel cortePanel;
    private DefaultTableModel modelo;
    private int total;
    private ControladorPDF cPDF;

    public ControladorCorte(CortePanel cortePanel, AudioClip sonidoDeBoton, AudioClip sonidoDeRegresar, JPanel mPrincipal) throws SQLException {
        this.cortePanel = cortePanel;
        this.mPrincipal = mPrincipal;
        this.sonidoDeBoton = sonidoDeBoton;
        this.sonidoDeRegresar = sonidoDeRegresar;
        //Botones
        cortePanel.generar.addMouseListener(this);
        //Imagen
        cortePanel.regresarImagen.addMouseListener(this);
        //Tabla
        cortePanel.tablaCorte.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JButton")) {
            try {
                eventosJButton(e);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCorte.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JLabel")) {
            Icon icono = new ImageIcon(getClass().getResource("../imagenes/regreso.png"));
            sonidoDeRegresar.play();
            if (JOptionPane.showConfirmDialog(null, "¿Desea regresar al menu principal?", "Regresar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono) == 0) {
                cortePanel.setVisible(false);
                mPrincipal.setVisible(true);
            }
        } else if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JTable")) {
            if (cortePanel.tablaCorte.getSelectedColumn() == 1 || cortePanel.tablaCorte.getSelectedColumn() == 2) {
                JOptionPane.showMessageDialog(null, cortePanel.tablaCorte.getValueAt(cortePanel.tablaCorte.getSelectedRow(), cortePanel.tablaCorte.getSelectedColumn()));
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
        if (e.getSource().equals(cortePanel.generar)) {
            cortePanel.generar.setBackground(new Color(0, 102, 102));
            sonidoDeBoton.play();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(cortePanel.generar)) {
            cortePanel.generar.setBackground(new Color(0, 51, 51));
        }
    }

    public void consultar() throws SQLException {
        BDPedido bd = new BDPedido();
        ArrayList<Pedido> pedidos;
        pedidos = bd.consultar();
        for (int i = 0; i < pedidos.size(); i++) {
            if (verificarFecha(pedidos.get(i))) {
                Object info[] = {pedidos.get(i).getIdPedido(), pedidos.get(i).getPaquete(), pedidos.get(i).getExtra(), pedidos.get(i).getTotal()};
                modelo.addRow(info);
            }
        }
        calcular();
    }

    public void iniciarTabla() throws SQLException {
        modelo = new DefaultTableModel();
        cortePanel.tablaCorte.setModel(modelo);
        modelo.addColumn("Id_Pedido");
        modelo.addColumn("Paquete");
        modelo.addColumn("Extra");
        modelo.addColumn("Total");
        for (int i = 0; i < 4; i++) {
            cortePanel.tablaCorte.getColumnModel().getColumn(i).setMinWidth(140);
            cortePanel.tablaCorte.getColumnModel().getColumn(i).setMaxWidth(230);
        }
        consultar();
    }

    public void eventosJButton(MouseEvent e) throws SQLException {
        if (e.getSource().equals(cortePanel.generar)) {
            crearArchivo();
        }
    }

    public void calcular() {
        total = 0;
        for (int i = 0; i < cortePanel.tablaCorte.getRowCount(); i++) {
            total = total + (int) cortePanel.tablaCorte.getValueAt(i, 3);
        }
        cortePanel.totalCorte.setText("$ " + String.valueOf(total));
    }

    public Boolean verificarFecha(Pedido pedido) {
        long millis = System.currentTimeMillis();
        Date fecha = new Date(millis);
        return pedido.getFecha().equals(String.valueOf(fecha));
    }
    
    public void crearArchivo(){
        cPDF = new ControladorPDF(cortePanel.tablaCorte);
        File nuevo;
        nuevo = new File("C:/Users/Saul/Desktop/prueba.pdf");
        cPDF.createPDF(nuevo);
    }
}
