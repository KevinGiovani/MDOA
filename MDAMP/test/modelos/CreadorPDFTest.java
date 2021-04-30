/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kevin
 */
public class CreadorPDFTest {

    private File pdfNewFile;
    private final CreadorPDF instance;
    private final JTable tablaCorte;
    private final DefaultTableModel modelo;

    public CreadorPDFTest() {
        tablaCorte = new JTable();
        modelo = new DefaultTableModel();
        instance = new CreadorPDF(tablaCorte, 0);

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tablaCorte.setModel(modelo);

        modelo.addColumn("Id_Pedido");
        modelo.addColumn("Paquete");
        modelo.addColumn("Extra");
        modelo.addColumn("Subtotal");
        for (int i = 0; i < 4; i++) {
            tablaCorte.getColumnModel().getColumn(i).setMinWidth(140);
            tablaCorte.getColumnModel().getColumn(i).setMaxWidth(230);
        }
        pdfNewFile = new File("prueba.pdf");

    }

    @After
    public void tearDown() {
         pdfNewFile.deleteOnExit();
    }

    /**
     * Test of createPDF method, of class CreadorPDF.
     */
    @Test
    public void testCreatePDF() {
        System.out.println("createPDF");
        instance.createPDF(pdfNewFile);
        assertTrue(pdfNewFile.length() != 0);
    }

    /**
     * Test of watermark method, of class CreadorPDF.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWatermark() throws Exception {
        System.out.println("watermark");
        File aux = new File("aux.pdf");
        instance.createPDF(pdfNewFile);
        Files.copy(pdfNewFile.toPath(), aux.toPath(), StandardCopyOption.COPY_ATTRIBUTES);
        instance.watermark(pdfNewFile);
        assertNotSame(pdfNewFile, aux);
         aux.deleteOnExit();
    }

    /**
     * Test of manipulatePdf method, of class CreadorPDF.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testManipulatePdf() throws Exception {
        System.out.println("manipulatePdf");
         File aux=new File("aux2.pdf");
         instance.createPDF(pdfNewFile);
        instance.watermark(pdfNewFile);
         Files.copy(pdfNewFile.toPath(), aux.toPath(), StandardCopyOption.COPY_ATTRIBUTES);
        instance.manipulatePdf(pdfNewFile);
        assertNotSame(pdfNewFile, aux);
        aux.deleteOnExit();
    }

}
