/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.itextpdf.text.Document;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.JTable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Saul
 */
public class ControladorPDF {

    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private final JTable tabla;

    public ControladorPDF(JTable tabla) {
        this.tabla = tabla;
    }

    public void createPDF(File pdfNewFile) {
        // Creamos el documento e indicamos el nombre del fichero.
        try {
            Document document = new Document();
            try {

                PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));

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
            document.addAuthor("Dueño de Asadero Mi Pollo: Cesar Pacheco");

            // Primera página 
            Chunk chunk = new Chunk("Asadero Mi Pollo", chapterFont);
            chunk.setBackground(BaseColor.YELLOW);
            // Let's create de first Chapter (Creemos el primer capítulo)
            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
            chapter.setNumberDepth(0);

            // Utilización de PdfPTable
            // We use various elements to add title and subtitle
            // Usamos varios elementos para añadir título y subtítulo
            //Paragraph paragraph = new Paragraph("Corte del Día", subcategoryFont);
            //Section paragraphMore = chapter.addSection(paragraph);
            Paragraph paragraphLorem = new Paragraph();
            strDateFormat = "dd-MMM-yyyy hh:mm:ss a (z)"; // El formato de fecha está especificado  
            objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 
            paragraphLorem.add("\nLa informacion presentada en este documento fue generada el " + objSDF.format(objDate) + "\n");

            Integer numColumns = tabla.getColumnCount();
            Integer numRows = tabla.getRowCount();
            // We create the table (Creamos la tabla).
            PdfPTable table = new PdfPTable(numColumns);
            // Now we fill the PDF table 
            // Ahora llenamos la tabla del PDF
            PdfPCell columnHeader;
            // Fill table rows (rellenamos las filas de la tabla).                
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
            // (Añadimos la tabla)
            paragraphLorem.add(table);
            //(Añadimos el elemento con la tabla).
            document.add(chapter);
            document.add(paragraphLorem);
            document.close();
        } catch (DocumentException documentException) {
            System.out.println("Se ha producido un error al generar un documento: " + documentException);
        }
    }

    public void watermark(File pdf) throws IOException, DocumentException {
        // read existing pdf
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
}
