/*
 * Prueba Unitaria aplicada al modelo 'CreadorPDF'
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
 * @author Inzunza Kevin
 * @version 29-04-2021
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
     * Test del metodo createPDF de la clase BDCliente para verificar que se ha
     * creado un nuevo pdf de la manera correcta
     */
    @Test
    public void testCreatePDF() {
        System.out.println("createPDF");
        instance.createPDF(pdfNewFile);
        assertTrue(pdfNewFile.length() != 0);
    }

    /**
     * Test del metodo watermark de la clase BDCliente para verificar que se ha
     * agregado una marca de agua al documento pdf existente.
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
     * Test del metodo manipulatePDF de la clase BDCliente para verificar que se ha
     * agregado un pie de pagina al documento pdf existente.
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