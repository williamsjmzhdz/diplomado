package dgtic.core.util;
import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import dgtic.core.model.entities.EspecieEntity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import java.awt.*;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

@Component("especie/especie-pdf")
public class EspeciePdf extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document,
                                    PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<EspecieEntity> datos= (List<EspecieEntity>) model.get("datos");
        String ruta=((String)model.get("ruta"))+datos.get(0).getImagen();
        String rutaAlm=ruta+".pdf";
        PdfWriter.getInstance(document,new FileOutputStream(rutaAlm));
        document.open();
        PdfPTable tabla=new PdfPTable(2);
        PdfPCell celda=new PdfPCell(new Phrase("Id de la Especie"));
        celda.setBackgroundColor(new Color(167,218,255));
        celda.setPadding(8f);
        tabla.addCell(celda);
        tabla.addCell("Nombre");
        for (EspecieEntity r:datos) {
            tabla.addCell(String.valueOf(r.getLote().getId_lte()));
            tabla.addCell(r.getNombre());
        }
        document.add(tabla);
        Image jpg = Image.getInstance(ruta);
        document.add(jpg);
        document.close();
    }
}
