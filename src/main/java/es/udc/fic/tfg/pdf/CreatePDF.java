package es.udc.fic.tfg.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.TextField;
import com.itextpdf.text.pdf.events.FieldPositioningEvents;


import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.expense.Expense;

public class CreatePDF {


    private static Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
    private static Font TIME_ROMAN_SMALL = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    public static Font TIME_ROMAN_BIG = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
    public static Font TIME_ROMAN_BOLD = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    public static BaseColor CHAPTER_COLOR = new BaseColor(166, 166, 166);
    public static BaseColor HEADER_COLOR = new BaseColor(230, 230, 230);



    public static Document createPDF(String file,Expense expense) throws ParseException {

        Document document = null;

        try {
            document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            addMetaData(document);

            addTitlePage(document);

            addDataMyBarn(document);

            addDataAccount(document,expense.getConsumer());

            createTable(document,expense);

            document.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return document;

    }

    private static void addMetaData(Document document) {
        document.addTitle("Generate PDF report");
        document.addSubject("Generate PDF report");
        document.addAuthor("MyBarnApp");
        document.addCreator("MyBarnApp");
    }

    private static void addTitlePage(Document document)
            throws DocumentException {

        Paragraph preface = new Paragraph();
        createEmptyLine(preface, 1);
        preface.add(new Paragraph("Informe de gasto - MyBarnAPP©", TIME_ROMAN));

        createEmptyLine(preface, 1);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        preface.add(new Paragraph("Fecha de emisión:  "
                + simpleDateFormat.format(new Date()), TIME_ROMAN_SMALL));
        document.add(preface);

    }

    private static void createEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    private static void addDataMyBarn(Document document) throws DocumentException {

        Paragraph paragraph = new Paragraph();
        createEmptyLine(paragraph, 1);
        paragraph.add(new Paragraph("Datos del emisor", TIME_ROMAN_SMALL));

       createEmptyLine(paragraph, 1);
        document.add(paragraph);

        PdfPTable outer = new PdfPTable(1);
        outer.setWidthPercentage(70);
        outer.setHorizontalAlignment(Element.ALIGN_LEFT);

        PdfPTable table = new PdfPTable(2);
        table.setWidths(new int[]{1,2});
        table.setWidthPercentage(100);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);

        table.addCell(new Phrase("Nombre", TIME_ROMAN_SMALL));
        table.addCell(new Phrase("MyBarnApp", TIME_ROMAN_SMALL));

        table.addCell(new Phrase("Dirección", TIME_ROMAN_SMALL));
        table.addCell(new Phrase("Facultad de Informática", TIME_ROMAN_SMALL));

        table.addCell(new Phrase("Localidad", TIME_ROMAN_SMALL));
        table.addCell(new Phrase("A Coruña", TIME_ROMAN_SMALL));

        table.addCell(new Phrase("Municipio", TIME_ROMAN_SMALL));
        table.addCell(new Phrase("A Coruña", TIME_ROMAN_SMALL));

        table.addCell(new Phrase("CIF", TIME_ROMAN_SMALL));
        table.addCell(new Phrase("B000000", TIME_ROMAN_SMALL));

        outer.addCell(table);
        document.add(outer);

    }

    private static void addDataAccount(Document document,Account account) throws DocumentException {

        Paragraph paragraph = new Paragraph();
        createEmptyLine(paragraph, 1);
        paragraph.add(new Paragraph("Datos del usuario", TIME_ROMAN_SMALL));

        createEmptyLine(paragraph, 1);
        document.add(paragraph);

        PdfPTable outer = new PdfPTable(1);
        outer.setWidthPercentage(70);
        outer.setHorizontalAlignment(Element.ALIGN_LEFT);

        PdfPTable table = new PdfPTable(2);
        table.setWidths(new int[]{1,2});
        table.setWidthPercentage(100);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);

        table.addCell(new Phrase("Nombre", TIME_ROMAN_SMALL));
        table.addCell(new Phrase(account.getFirstname(), TIME_ROMAN_SMALL));

        table.addCell(new Phrase("Apellidos", TIME_ROMAN_SMALL));
        table.addCell(new Phrase(account.getLastname(), TIME_ROMAN_SMALL));

        table.addCell(new Phrase("Correo Electrónico", TIME_ROMAN_SMALL));
        table.addCell(new Phrase(account.getEmail(), TIME_ROMAN_SMALL));

        table.addCell(new Phrase("Número de Teléfono", TIME_ROMAN_SMALL));
        table.addCell(new Phrase(account.getPhonenumber(), TIME_ROMAN_SMALL));

        outer.addCell(table);
        document.add(outer);

    }



    private static void createTable(Document document, Expense expense) throws DocumentException, ParseException {
        Paragraph paragraph = new Paragraph();
        createEmptyLine(paragraph, 2);
        document.add(paragraph);
        PdfPTable table = new PdfPTable(5);

        PdfPCell c1 = new PdfPCell(new Phrase("Concepto"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setBackgroundColor(HEADER_COLOR);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Usuario"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setBackgroundColor(HEADER_COLOR);
        table.addCell(c1);
        Date sdf = Date.from(expense.getExpensedate().toInstant());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(sdf);

        c1 = new PdfPCell(new Phrase("Fecha"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setBackgroundColor(HEADER_COLOR);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Caballo Asociado"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setBackgroundColor(HEADER_COLOR);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Cantidad (€)"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setBackgroundColor(HEADER_COLOR);
        table.addCell(c1);

        table.setHeaderRows(1);

        table.setWidthPercentage(100);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(expense.getTitle());
        table.addCell(expense.getConsumer().getFirstname());
        table.addCell(formattedDate);
        table.addCell(expense.getHorseexpense().getNickname());
        table.addCell(String.valueOf(expense.getAmount()));

        document.add(table);
    }

}
