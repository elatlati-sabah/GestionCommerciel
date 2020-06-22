package com.pfe.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pfe.entity.Facture;
@Service
public class ExportFactureService {

	public ByteArrayInputStream FacturePDFReport(List<Facture> facture) {
		Document document = new Document();
		ByteArrayOutputStream out = new  ByteArrayOutputStream();
		try {
			PdfWriter.getInstance(document, out);
			document.open();
			//add text to pdf file 
			com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER ,14 , BaseColor.BLACK);
			Paragraph para =  new Paragraph();
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			document.add(Chunk.NEWLINE);
			
			PdfPTable table  = new PdfPTable(2);
			Stream.of("Title", "Description").forEach(headerTitle -> {
				PdfPCell header = new PdfPCell();
				com.itextpdf.text.Font headfont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
				header.setBackgroundColor(BaseColor.LIGHT_GRAY);
				header.setHorizontalAlignment(Element.ALIGN_CENTER);
				header.setBorderWidth(1);
				header.setPhrase(new Phrase(headerTitle ,headfont));
				table.addCell(header);
			});
			
			for(Facture fact:facture) {
				PdfPCell titleCell = new PdfPCell(new Phrase(fact.getFactureCounter()));
				titleCell.setPaddingLeft(1);
				titleCell.setVerticalAlignment(Element.ALIGN_LEFT);
				titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(titleCell);
				
				PdfPCell descCell = new PdfPCell(new Phrase(fact.getId_facture()));
				descCell.setPaddingLeft(1);
				descCell.setVerticalAlignment(Element.ALIGN_LEFT);
				descCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(descCell);
			}
			document.add(table);
			document.close();
					} catch (DocumentException e) {
			e.printStackTrace();
		}
		return new ByteArrayInputStream(out.toByteArray());
		
	}

}
