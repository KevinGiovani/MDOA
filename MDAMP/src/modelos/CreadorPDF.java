/**
 * Permite la creacion de un archivo en formato PDF para que el usuario pueda
 * realizar una visualizacion de la informacion que se recapitulo del corte del dia
 * y de esta conforma poder consultar de manera posterior.
 * 
*/


package modelos;

import com.itextpdf.text.Document;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.JTable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Inzunza Kevin
 * @author De La Cruz Joel
 * @author Pacheco Cesar
 * @version 25-04-2021
 */
public class CreadorPDF {

    private static Font chapterFont;
    private final JTable tabla;
    private final int total;

    /**
     * Constuctor que recibe parámetros desde el JPanel del menu principal,
     * además inicializa los eventos para el Mouse Listener.
     * 
     * @param tabla
     * @param total 
     */
    public CreadorPDF(JTable tabla, int total) {
        chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
        this.tabla = tabla;
        this.total = total;
    }

    /**
     * 
     * @param pdfNewFile 
     */
    public void createPDF(File pdfNewFile) {
        // Creamos el documento e indicamos el nombre del fichero.
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
            document.addTitle("Corte(" + objSDF.format(objDate) + ") Asadero Mi Pollo");
            document.addSubject("Obtener informacion recabada de los pedidos realizados el dia que se genero este archivo"); //Asunto
            document.addKeywords("Asadero,Mi Pollo,Corte,Local Familiar");
            document.addAuthor("Dueño de Asadero Mi Pollo: Cesar Pacheco Robles");

            // Primera página 
            Chunk chunk = new Chunk("Asadero Mi Pollo", chapterFont);
            chunk.setBackground(BaseColor.YELLOW);
            // Creemos el primer capítulo
            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
            chapter.setNumberDepth(0);

            Image image;
            try {
                image = Image.getInstance(getClass().getResource("../imagenes/MiPolloLogo.png"));
                image.setAbsolutePosition(485, 754);
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
            paragraphLorem.add("\nLa información presentada en este documento fue generada el " + objSDF.format(objDate) + "\n");

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
            // (rellenamos las filas de la tabla). 
            for (int row = 0; row < numRows; row++) {
                for (int column = 0; column < numColumns; column++) {
                    table.addCell(String.valueOf(tabla.getValueAt(row, column)));
                }
            }
            // (Añadimos la tabla)ill table rows (r
            paragraphLorem.add(table);
            paragraphLorem.add("\nEl total del día de hoy es de $" + total + ".00");
            paragraphLorem.setAlignment(Element.ALIGN_RIGHT);
            //(Añadimos el elemento con la tabla).
            document.add(chapter);
            document.add(paragraphLorem);
            document.close();
        } catch (DocumentException documentException) {
            System.out.println("Se ha producido un error al generar un documento: " + documentException);
        }
    }

    /**
     * 
     * @param pdf
     * @throws IOException
     * @throws DocumentException 
     */
    public void watermark(File pdf) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(pdf.getAbsolutePath());
        File temp = new File("TEMP.pdf");
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(temp.getAbsoluteFile()));

        // text watermark
        Font FONT = new Font(Font.FontFamily.HELVETICA, 34, Font.BOLD, new GrayColor(0.5f));
        Phrase p = new Phrase("Asadero Mi Pollo", FONT);

        // properties
        PdfContentByte over;
        Rectangle pagesize;
        float x, y;

        // loop over every page
        int n = reader.getNumberOfPages();
        for (int i = 1; i <= n; i++) {

            // get page size and position
            pagesize = reader.getPageSizeWithRotation(i);
            x = (pagesize.getLeft() + pagesize.getRight()) / 2;
            y = (pagesize.getTop() + pagesize.getBottom()) / 2;
            over = stamper.getOverContent(i);
            over.saveState();

            // set transparency
            PdfGState state = new PdfGState();
            state.setFillOpacity(0.2f);
            over.setGState(state);

            // add watermark text and image
            ColumnText.showTextAligned(over, Element.ALIGN_CENTER, p, x, y, 45);
            over.restoreState();
        }
        stamper.close();
        reader.close();

        Path source = Paths.get(temp.getAbsolutePath());

        Files.move(source, source.resolveSibling(pdf.getAbsolutePath()),
                StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * 
     * @param pdf
     * @throws IOException
     * @throws DocumentException 
     */
    public void manipulatePdf(File pdf) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(pdf.getAbsolutePath());
        int n = reader.getNumberOfPages();
        File temp = new File("TEMP.pdf");
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(temp.getAbsoluteFile()));
        PdfContentByte pagecontent;
        for (int i = 0; i < n;) {
            pagecontent = stamper.getOverContent(++i);
            ColumnText.showTextAligned(pagecontent, Element.ALIGN_LEFT,
                    new Phrase(String.format("Página %s de %s", i, n)), 500, 20, 0);
        }
        stamper.close();
        reader.close();

        Path source = Paths.get(temp.getAbsolutePath());

        Files.move(source, source.resolveSibling(pdf.getAbsolutePath()),
                StandardCopyOption.REPLACE_EXISTING);
    }
}
