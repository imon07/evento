package controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: sahmed
 * Date: 2/26/13
 * Time: 3:24 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@RequestScoped
public class TicketController {

    protected final Log log = LogFactory.getLog(getClass());

    public void downloadTicket(Integer userId) {

        String ticketId = String.valueOf((userId));
        String fileName = "evento_" + ticketId + ".pdf";

        log.info("fileName: " + fileName);

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();

        externalContext.setResponseContentType("application/pdf");
        externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        try {

            Document document = new Document();

            File file = File.createTempFile("evento_" + ticketId, ".pdf");

            OutputStream outputStream = externalContext.getResponseOutputStream();

            InputStream inputStream = new FileInputStream(file);

            FileOutputStream fileOutputStream = new FileOutputStream(file.getPath());

            PdfWriter.getInstance(document, fileOutputStream);

            document.open();

            document.add(new Paragraph("Your Evento Ticket: " + ticketId));

            document.close();

            fileOutputStream.flush();
            fileOutputStream.close();

            log.info("file-path: " + file.getAbsolutePath());
            log.info("file-length: " + file.length());

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                log.info(new String(bytes));
                outputStream.write(bytes, 0, read);
            }

            inputStream.close();
            outputStream.flush();
            outputStream.close();

            context.responseComplete();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
