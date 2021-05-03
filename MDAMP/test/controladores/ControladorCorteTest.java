/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import javax.swing.JPanel;
import modelos.CreadorPDF;
import modelos.Pedido;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.itextpdf.text.*;
import java.applet.AudioClip;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import vistas.CortePanel;

/**
 *
 * @author naum1
 */
public class ControladorCorteTest {
    
    private final JPanel mPrincipal;
    private final CortePanel cortePanel;
    private DefaultTableModel modelo; // Modelo de la tabla de corte
    private CreadorPDF cPDF;
    private final Pedido pedido;
    private final ControladorCorte instance;
    AudioClip sonidoDeBoton; 
    AudioClip sonidoDeRegresar;

    public ControladorCorteTest() throws SQLException {
        mPrincipal = new JPanel();
        cortePanel = new CortePanel(sonidoDeBoton, sonidoDeRegresar, mPrincipal);
        pedido = new Pedido(0, "", "", String.valueOf(new Date(System.currentTimeMillis())), 0);
        instance = new ControladorCorte(cortePanel, sonidoDeBoton, sonidoDeRegresar, mPrincipal);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        modelo = new DefaultTableModel();
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of consultar method, of class ControladorCorte.
     * @throws java.lang.Exception
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("consultar");
        instance.consultar();
        int total = 0;
        for (int i = 0; i < cortePanel.tablaCorte.getRowCount(); i++) {
            total = total + (int) cortePanel.tablaCorte.getValueAt(i, 3);
        }
        String expResult = "$ " + String.valueOf(total);
        assertEquals(cortePanel.totalCorte.getText(), expResult);
        
    }

    /**
     * Test of iniciarTabla method, of class ControladorCorte.
     * @throws java.lang.Exception
     */
    @Test
    public void testIniciarTabla() throws Exception {
        System.out.println("iniciarTabla");
        instance.iniciarTabla();
        assertTrue(
                cortePanel.tablaCorte.getColumnModel().
                        getColumn(3).getMinWidth() > 139
                && cortePanel.tablaCorte.getColumnModel().
                        getColumn(3).getMaxWidth() < 231);
    }

    /**
     * Test of verificarFecha method, of class ControladorCorte.
     */
    @Test
    public void testVerificarFecha() {
        System.out.println("verificarFecha");
        assertTrue(instance.verificarFecha(pedido));
    }

    /**
     * Test of crearArchivo method, of class ControladorCorte.
     * @throws java.lang.Exception
     */
    @Test
    public void testCrearArchivo() throws Exception {
        System.out.println("crearArchivo");
        try{
            instance.crearArchivo();
            assertTrue(true);
        }catch(DocumentException | IOException e){
            assertTrue(false);
        }
    }

}
