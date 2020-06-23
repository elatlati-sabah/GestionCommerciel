package com.pfe.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pfe.entity.Client;
import com.pfe.entity.DetailsFacture;
import com.pfe.entity.Facture;
import com.pfe.entity.Fournisseur;
import com.pfe.entity.Produit;
import com.pfe.entity.Societe;

public class PDFGenerator {
	
	private static Logger logger = LoggerFactory.getLogger(PDFGenerator.class);
	  
	  public static ByteArrayInputStream facturePDFReport(List<Produit> produits) {
	    Document document = new Document();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        
	        try {
	          
	          PdfWriter.getInstance(document, out);
	            document.open();
	          
	            // Add Text to PDF file ->
	          Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
	          Paragraph para = new Paragraph( "OPEN ITC sarl", font);
	          para.setAlignment(Element.ALIGN_RIGHT);
	          document.add(para);
	          document.add(Chunk.NEWLINE);
	          
	          	// Add facture fields 
	          Facture facture = new Facture();
	          Paragraph parafact = new Paragraph( "Facture N°:"+facture.getFactureCounter(), font);
	          para.setAlignment(Element.ALIGN_RIGHT);
	          document.add(parafact);
	          document.add(Chunk.NEWLINE);
	          //Add Client Informations
	          Client client = new Client();
	          Paragraph parainfo = new Paragraph( "Informations du client:", font);
	          para.setAlignment(Element.ALIGN_RIGHT);
	          document.add(parainfo);
	          document.add(Chunk.NEWLINE);
	           
	          Paragraph paraclient = new Paragraph( "Client:"+client.getId_client(), font);
	          para.setAlignment(Element.ALIGN_RIGHT);
	          document.add(paraclient);
	          document.add(Chunk.NEWLINE);
	          
	          Paragraph paraIce = new Paragraph( "ICE:"+client.getIce(), font);
	          para.setAlignment(Element.ALIGN_RIGHT);
	          document.add(paraIce);
	          document.add(Chunk.NEWLINE);
	          //add logo to pdf file 
	          try {
				Image logo = Image.getInstance("open.jpg");
				logo.setAbsolutePosition(40, 780);
				logo.scaleAbsolute(70, 50);
				document.add(logo);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        
	       
	          PdfPTable table = new PdfPTable(5);
	          // Add PDF Table Header ->
	            Stream.of("CODE", "DESIGNATION", "QTE" ,"PU TTC" , "TOTAL TTC")
	              .forEach(headerTitle -> {
	                  PdfPCell header = new PdfPCell();
	                  Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	                  header.setBackgroundColor(new BaseColor(232, 232, 232));
	                  header.setHorizontalAlignment(Element.ALIGN_CENTER);
	                  header.setBorderWidth(2);
	                  header.setPhrase(new Phrase(headerTitle, headFont));
	                  table.addCell(header);
	              });
	            
	            for (Produit produit : produits) {
	            	PdfPCell idCell = new PdfPCell(new Phrase(produit.getCodeProduit()));
	              idCell.setPaddingLeft(4);
	              idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	              idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(idCell);
	             /* for(Detailsfac customer : user.getLiCustomer() ) {
	            	  System.out.println(customer.getFirstName());
	              }
	
	                PdfPCell firstNameCell = new PdfPCell(new Phrase(user.getUserName()));*/
	                PdfPCell designationCell = new PdfPCell(new Phrase(produit.getDesignation()));
	                designationCell.setPaddingLeft(4);
	                designationCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                designationCell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                table.addCell(designationCell);
	 
	                PdfPCell quantiteCell = new PdfPCell(new Phrase(String.valueOf(produit.getQuantite())));
	                quantiteCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                quantiteCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                quantiteCell.setPaddingRight(4);
	                table.addCell(quantiteCell);
	                
	                PdfPCell prixunitaireCell = new PdfPCell(new Phrase(String.valueOf(produit.getPrixUnitaire())));
	                prixunitaireCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                prixunitaireCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                prixunitaireCell.setPaddingRight(4);
	                table.addCell(prixunitaireCell);
	                
	                PdfPCell prixtotalCell = new PdfPCell(new Phrase(String.valueOf(produit.getPrixUnitaire()*produit.getQuantite())));
	                prixtotalCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                prixtotalCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                prixtotalCell.setPaddingRight(4);
	                table.addCell(prixtotalCell);
	            }
	            document.add(table);
	            
	            //table2
	            PdfPTable table2 = new PdfPTable(3);
		          // Add PDF Table Header ->
		            Stream.of("PRIX HT", "TVA", "PRIX TTC")
		              .forEach(headerTitle -> {
		                  PdfPCell header = new PdfPCell();
		                  Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		                  header.setBackgroundColor(new BaseColor(232, 232, 232));
		                  header.setHorizontalAlignment(Element.ALIGN_CENTER);
		                  header.setBorderWidth(2);
		                  header.setPhrase(new Phrase(headerTitle, headFont));
		                  table.addCell(header);
		              });
		            
		           
	            document.close();
	        }catch(DocumentException e) {
	          logger.error(e.toString());
	        }
	        
	    return new ByteArrayInputStream(out.toByteArray());
	  }

}
