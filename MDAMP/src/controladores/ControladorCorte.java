/**
 * Este controlador se encarga de manejar los MouseListeners,
 * algunos aspectos visuales que normalmente se aplican en el JFrame.
 * También permite conocer los pedidos generados el dia en que se realiza el corte
 * e incluye tambien el total que se genero, por ultimo, tambien se permite
 * la creacion del archivo pdf del la informacion recabada del corte
 * 
 */
package controladores;

import modelos.CreadorPDF;
import com.itextpdf.text.DocumentException;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelos.BDPedido;
import modelos.Pedido;
import vistas.CortePanel;

/**
 *
 * @author Inzunza Kevin
 * @author De La Cruz Joel
 * @author Pacheco Cesar
 * @version 24-04-2021
 */
public class ControladorCorte implements MouseListener {

    private final AudioClip sonidoDeBoton; //Audio para los botones
    private final AudioClip sonidoDeRegresar; //Audio reproducido para salir
    private final JPanel mPrincipal; //Panel de la ventana de menú principal
    private final CortePanel cortePanel; //Panel de la ventana de corte
    private DefaultTableModel modelo; // Modelo de la tabla de corte
    private int total; //Ganancia total del día
    private CreadorPDF cPDF; //Generar documento PDF
    
    /**
     * Constuctor que recibe parámetros desde el JPanel del menu principal,
     * además inicializa los eventos para el Mouse Listener.
     * 
     * @param cortePanel
     * @param sonidoDeBoton
     * @param sonidoDeRegresar
     * @param mPrincipal
     * @throws SQLException 
     */
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

    /**
     * Este método detecta a que botón hizo clic llamando a otro método para los
     * eventos de botón, si no fue el caso verificará si hizo clic hacia la
     * etiqueta que representa regresar al menú principal.
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().getClass().getTypeName().equalsIgnoreCase("javax.swing.JButton")) {
            try {
                eventosJButton(e);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCorte.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ControladorCorte.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
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
                if (!cortePanel.tablaCorte.getValueAt(cortePanel.tablaCorte.getSelectedRow(), cortePanel.tablaCorte.getSelectedColumn()).equals("")) {
                    JOptionPane.showMessageDialog(null, cortePanel.tablaCorte.getValueAt(cortePanel.tablaCorte.getSelectedRow(), cortePanel.tablaCorte.getSelectedColumn()), "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
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
     * MouseEntered detectará cuando el mouse está sobre algún botón y cual de
     * estos fue, cambiando el color de fondo del botón y reproduciendo un
     * sonido.
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(cortePanel.generar)) {
            cortePanel.generar.setBackground(new Color(0, 102, 102));
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
        if (e.getSource().equals(cortePanel.generar)) {
            cortePanel.generar.setBackground(new Color(0, 51, 51));
        }
    }
    /**
     * Este método buscará toda la información de los pedidos que se encuentre
     * dentro de la base de datos y así mostrarlo dentro de una tabla los
     * datos de cada pedido realizado
     * @throws SQLException 
     */
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
    
    /**
     * Se crea un modelo para la tabla, la cual contiene las columnas de
     * Id_Pedido, Paquete, Extra y subtotal, además se ajustan los valores del largo
     * de cada columna
     * @throws SQLException 
     */
    public void iniciarTabla() throws SQLException {
        modelo = new DefaultTableModel();
        cortePanel.tablaCorte.setModel(modelo);
        cortePanel.tablaCorte.setDefaultEditor(Object.class, null);
        modelo.addColumn("Id_Pedido");
        modelo.addColumn("Paquete");
        modelo.addColumn("Extra");
        modelo.addColumn("Subtotal");
        for (int i = 0; i < 4; i++) {
            cortePanel.tablaCorte.getColumnModel().getColumn(i).setMinWidth(140);
            cortePanel.tablaCorte.getColumnModel().getColumn(i).setMaxWidth(230);
        }
        consultar();
    }
    
    /**
     * Realiza una detección de algún evento realizado gracias al clic del mouse
     * con el propósito de generar el archivo PDF para el dueño
     * @param e
     * @throws SQLException
     * @throws IOException
     * @throws DocumentException 
     */
    public void eventosJButton(MouseEvent e) throws SQLException, IOException, DocumentException {
        if (e.getSource().equals(cortePanel.generar)) {
            crearArchivo();
        }
    }
    
    /**
     * Este método tomará el valor de subtotal de cada pedido para sumarlos y obtener
     * la total del día.
     */
    public void calcular() {
        total = 0;
        for (int i = 0; i < cortePanel.tablaCorte.getRowCount(); i++) {
            total = total + (int) cortePanel.tablaCorte.getValueAt(i, 3);
        }
        cortePanel.totalCorte.setText("$ " + String.valueOf(total));
    }
    
    /**
     * Evaluará la fecha de cada pedido contra la fecha del día en curso, esto con
     * el propósito de mostrar los pedidos de ese mismo día y calcular el total.
     * @param pedido
     * @return 
     */
    public Boolean verificarFecha(Pedido pedido) {
        long millis = System.currentTimeMillis();
        Date fecha = new Date(millis);
        return pedido.getFecha().equals(String.valueOf(fecha));
    }

    /**
     * Solicitará al usuario donde quisiera aguardar el archivo PDF y además
     * el como desea nombrarlo.
     * @throws IOException
     * @throws DocumentException 
     */
    public void crearArchivo() throws IOException, DocumentException {
        long millis = System.currentTimeMillis();
        Date fecha = new Date(millis);
        boolean opcion;
        cPDF = new CreadorPDF(cortePanel.tablaCorte, total);
        JFileChooser guardar = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".pdf", "pdf");
        guardar.setFileFilter(filtro);
        do {
            guardar.setSelectedFile(new File("Corte-AsaderoMiPollo_" + String.valueOf(fecha) + ".pdf"));
            opcion = false;
            int op = guardar.showSaveDialog(null);
            guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            if (op == JFileChooser.APPROVE_OPTION) {
                String nombre = guardar.getSelectedFile().toString();
                if (!nombre.endsWith(".pdf")) {
                    nombre += ".pdf";
                    guardar.setSelectedFile(new File(nombre));
                }
                if (guardar.getSelectedFile().exists()) {
                    op = JOptionPane.showConfirmDialog(null, "¿Desea sobrescribir el archivo pdf?", "Mensaje de Confirmación", JOptionPane.YES_NO_OPTION);
                    if (op == JOptionPane.YES_OPTION) {
                        generarArchivo(guardar);
                    } else {
                        opcion = true;
                    }
                } else {
                    generarArchivo(guardar);
                }
            }
        } while (opcion);
    }

    /**
     * Se realizará la creación de un archivo PDF para el dueño del asadero, este
     * contendrá la información mostrada en la ventana de corte.
     * @param guardar
     * @throws IOException
     * @throws DocumentException 
     */
    public void generarArchivo(JFileChooser guardar) throws IOException, DocumentException {
        File archivo = guardar.getSelectedFile();
        cPDF.createPDF(archivo);
        cPDF.watermark(archivo);
        cPDF.manipulatePdf(archivo);

        JOptionPane.showMessageDialog(null, "El archivo pdf ha sido generado", "PDF", JOptionPane.INFORMATION_MESSAGE);
    }
}
