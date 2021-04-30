/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author naum1
 */
public class CreadorPDFTest {
    
    public CreadorPDFTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    /**
     * Test of createPDF method, of class CreadorPDF.
     */
    @Test
    public void testCreatePDF() {
        System.out.println("createPDF");
        File pdfNewFile = null;
        CreadorPDF instance = null;
        instance.createPDF(pdfNewFile);
        JTable tabla = new JTable();
        try {
            Document document = new Document();
            try {

                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));

            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No se encontró el fichero para generar el pdf" + fileNotFoundException);
            }
            document.open();
            Date objDate = new Date(); // Sistema actual La fecha y la hora se asignan a objDate 
            String strDateFormat = "dd-MMM-yyyy"; // El formato de fecha está especificado  
            SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 

            // Añadimos los metadatos del PDF
            document.addTitle("Fecha de prueba (" + objSDF.format(objDate));
            document.addSubject("Subject****1234****5678****abcd"); //Asunto
            document.addKeywords("KeyWords****1234****5678****abcd");
            document.addAuthor("Author****1234****5678****abcd");

            // Primera página 
            Chunk chunk = new Chunk("Chunk****1234****5678****abcd");
            chunk.setBackground(BaseColor.MAGENTA);
            // Creemos el primer capítulo
            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
            chapter.setNumberDepth(0);

            Image image;
            try {
                image = Image.getInstance(getClass().getResource("../imagenes/MiPolloLogo.png"));
                image.setAbsolutePosition(450, 500);
                image.scaleAbsolute(100, 80);
                chapter.add(image);
            } catch (BadElementException | IOException ex) {
                Logger.getLogger(CreadorPDF.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Utilización de PdfPTable
            // Usamos varios elementos para añadir título y subtítulo
            Paragraph paragraphLorem = new Paragraph();
            strDateFormat = "dd-MMM-yyyy hh:mm:ss a (z)"; // El formato de fecha está especificado  
            objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 
            paragraphLorem.add("\n****1234****5678****abcd " + objSDF.format(objDate) + "\n");

            Integer numColumns = tabla.getColumnCount();
            Integer numRows = tabla.getRowCount();
            // Creamos la tabla
            PdfPTable table = new PdfPTable(numColumns);
            // Ahora llenamos la tabla del PDF
            PdfPCell columnHeader;
            // Rellenamos las filas de la tabla                
            for (int column = 0; column < numColumns; column++) {
                columnHeader = new PdfPCell(new Phrase(tabla.getColumnName(column)));
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(columnHeader);
            }
            table.setHeaderRows(1);
            // Llenamos las filas de la tabla
            for (int row = 0; row < numRows; row++) {
                for (int column = 0; column < numColumns; column++) {
                    table.addCell(String.valueOf(tabla.getValueAt(row, column)));
                }
            }
            // Añadimos la tabla
            paragraphLorem.add(table);
            paragraphLorem.add("***1234****5678****abcd");
            paragraphLorem.setAlignment(Element.ALIGN_RIGHT);
            //Añadimos el elemento con la tabla
            document.add(chapter);
            document.add(paragraphLorem);
            document.close();
        } catch (DocumentException documentException) {
            System.out.println("Se ha producido un error al generar un documento: " + documentException);
        }
    }

    /**
     * Test of watermark method, of class CreadorPDF.
     */
    @Test
    public void testWatermark() throws Exception {
        System.out.println("watermark");
        File pdf = File.createTempFile("testFile", ".pdf");
        CreadorPDF instance = null;
        instance.watermark(pdf);
        File pdfWatermark = File.createTempFile("testFileWWatermark", ".pdf");
        PdfReader reader = new PdfReader(pdf.getAbsolutePath());
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(pdf.getAbsoluteFile()));
        
        Phrase phrase = new Phrase("Watermark Test");
        
        // Propiedades de la hoja
        PdfContentByte over;
        Rectangle pagesize;
        float x, y;

        // Ciclo para recorrer cada hoja del archivo
        int n = reader.getNumberOfPages();
        for (int i = 1; i <= n; i++) {

            // Obtener el tamaño y posicion de la hoja
            pagesize = reader.getPageSizeWithRotation(i);
            x = (pagesize.getLeft() + pagesize.getRight()) / 2;
            y = (pagesize.getTop() + pagesize.getBottom()) / 2;
            over = stamper.getOverContent(i);
            over.saveState();

            // Agregar transparencia a nuestro texto
            PdfGState state = new PdfGState();
            state.setFillOpacity(0.2f);
            over.setGState(state);

            // Agregamos la marca de agua
            ColumnText.showTextAligned(over, Element.ALIGN_CENTER, phrase, x, y, 45);
            over.restoreState();
        }
        stamper.close();
        reader.close();
        
        Path source = Paths.get(pdf.getAbsolutePath());
        Files.move(source, source.resolveSibling(pdf.getAbsolutePath()),
                StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * Test of manipulatePdf method, of class CreadorPDF.
     */
    @Test
    public void testManipulatePdf() throws Exception {
        System.out.println("manipulatePdf");
        File pdf = null;
        CreadorPDF instance = null;
        instance.manipulatePdf(pdf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
}
