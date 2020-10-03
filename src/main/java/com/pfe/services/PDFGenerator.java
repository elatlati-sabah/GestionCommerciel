package com.pfe.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.github.royken.converter.FrenchNumberToWords;
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
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.pfe.entity.Client;
import com.pfe.entity.DetailsFacture;
import com.pfe.entity.Facture;
import com.pfe.entity.Fournisseur;
import com.pfe.entity.Produit;
import com.pfe.entity.Societe;


public class PDFGenerator {
	
	private static int sommef;
	private static int tva;
	private static int prixttc;
	private static int montant;
	
	private static String type;
	private static Logger logger = LoggerFactory.getLogger(PDFGenerator.class);
	  
	  public static ByteArrayInputStream facturePDFReport(List<Produit> produits, Facture factureClient, List<Societe> societes) {
	    Document document = new Document();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        
	        try {
	          
	          PdfWriter.getInstance(document, out);
	            document.open();
	          for(Societe societe : societes) {
	        	//add logo to pdf file 
		          try {
					Image logo = Image.getInstance("open.jpg");
					logo.setAbsolutePosition(60, 780);
					logo.scaleAbsolute(70, 50);
					document.add(logo);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	            // Add Text to PDF file ->
	          Font font = FontFactory.getFont(FontFactory.HELVETICA, 14, BaseColor.BLACK);
	          Paragraph para = new Paragraph( ""+societe.getTitreFrancais(), font);
	          para.setAlignment(Element.ALIGN_RIGHT);
	          document.add(para);
	          //informations societe
	          Font fontadd = FontFactory.getFont(FontFactory.HELVETICA, 14, BaseColor.BLACK);
	          Paragraph paraadd = new Paragraph( "Adresse :"+societe.getAdresseFrancais(), fontadd);
	          paraadd.setAlignment(Element.ALIGN_RIGHT);
	          document.add(paraadd);
	          
	          
	          Font fonttel1 = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
	          Paragraph paratel1 = new Paragraph( "Téléphone1 :"+societe.getTelephone1(), font);
	          paratel1.setAlignment(Element.ALIGN_RIGHT);
	          document.add(paratel1);
	         
	          
	          Font fonttel2 = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
	          Paragraph paratel2 = new Paragraph( "Téléphone2 :"+societe.getTelephone2(), font);
	          paratel2.setAlignment(Element.ALIGN_RIGHT);
	          document.add(paratel2);
	          document.add(Chunk.NEWLINE);
	          Chunk linebreak1 = new Chunk(new DottedLineSeparator());
	          document.add(linebreak1);
	          }
	          	// Add facture fields 
	          Font font = FontFactory.getFont(FontFactory.HELVETICA, 14, BaseColor.BLACK);
	         
		          Paragraph parafact = new Paragraph( "Facture N°:"+factureClient.getFactureCounter(), font);
		          parafact.setAlignment(Element.ALIGN_LEFT);
		          document.add(parafact);
		          document.add(Chunk.NEWLINE);
	         
	          
	          //Add Client Informations
	          
	          Paragraph parainfo = new Paragraph( "Informations du client:", font);
	          parainfo.setAlignment(Element.ALIGN_LEFT);
	          document.add(parainfo);
	          document.add(Chunk.NEWLINE);
	          Client client = new Client();
	          Paragraph paraclient = new Paragraph( "Client:"+factureClient.getClient().getId_client(), font);
	          paraclient.setAlignment(Element.ALIGN_LEFT);
	          document.add(paraclient);
	         
	          
	          Paragraph paraIce = new Paragraph( "ICE:"+factureClient.getClient().getIce(), font);
	          paraIce.setAlignment(Element.ALIGN_LEFT);
	          document.add(paraIce);
	          Date date =new Date();
	          Paragraph paraDate = new Paragraph( "Date:"+date.toGMTString(), font);
	          paraDate.setAlignment(Element.ALIGN_RIGHT);
	          document.add(paraDate);
	          document.add(Chunk.NEWLINE);
	         
	        
	          
	        
	       
	          PdfPTable table = new PdfPTable(5);
	          // Add PDF Table Header ->
	            Stream.of("CODE", "DESIGNATION", "QTE" ,"PU TTC" , "TOTAL TTC")
	              .forEach(headerTitle -> {
	                  PdfPCell header = new PdfPCell();
	                  Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	                  header.setBackgroundColor(new BaseColor(232, 232, 232));
	                  header.setHorizontalAlignment(Element.ALIGN_CENTER);
	                  header.setBorderWidth(1);
	                  header.setPhrase(new Phrase(headerTitle, headFont));
	                  table.addCell(header);
	              });
	                       
	            for (DetailsFacture factureDetails : factureClient.getDetailsfactures()) {
	            	
	            	PdfPCell idCell = new PdfPCell(new Phrase(factureDetails.getProduitDetails().getCodeProduit()));
	              idCell.setPaddingLeft(4);
	              idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	              idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(idCell);
	             
	
	                PdfPCell designationCell = new PdfPCell(new Phrase(factureDetails.getProduitDetails().getDesignation()));
	                designationCell.setPaddingLeft(4);
	                designationCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                designationCell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                table.addCell(designationCell);
	 
	                PdfPCell quantiteCell = new PdfPCell(new Phrase(String.valueOf(factureDetails.getProduitDetails().getQuantite())));
	                quantiteCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                quantiteCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                quantiteCell.setPaddingRight(4);
	                table.addCell(quantiteCell);
	                
	                PdfPCell prixunitaireCell = new PdfPCell(new Phrase(String.valueOf(factureDetails.getProduitDetails().getPrixUnitaire())));
	                prixunitaireCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                prixunitaireCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                prixunitaireCell.setPaddingRight(4);
	                table.addCell(prixunitaireCell);
	                
	                PdfPCell prixtotalCell = new PdfPCell(new Phrase(String.valueOf(factureDetails.getPrixTTC())));
	                prixtotalCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                prixtotalCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                prixtotalCell.setPaddingRight(4);
	                table.addCell(prixtotalCell);
	                
	            }
	            document.add(table);
	            document.add(Chunk.NEWLINE);
	            document.add(Chunk.NEWLINE);
	         
	            //table2
	           
	            PdfPTable table2 = new PdfPTable(3);
		          // Add PDF Table Header ->
		            Stream.of("PRIX HT", "TVA 20%", "PRIX TTC")
		              .forEach(headerTitle -> {
		                  PdfPCell header2 = new PdfPCell();
		                  Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		                  header2.setBackgroundColor(new BaseColor(232, 232, 232));
		                  header2.setHorizontalAlignment(Element.ALIGN_CENTER);
		                  header2.setBorderWidth(1);
		                  header2.setPhrase(new Phrase(headerTitle, headFont));
		                  table2.addCell(header2);
		              });
		            //add fileds in rows table
		            for (DetailsFacture factureDetails : factureClient.getDetailsfactures()) {
		            	
		            		int somme =0; 
	            			somme =(int) factureDetails.getPrixTTC();
	            			System.out.println(somme);
	            			sommef += somme ;
	            			 
	            			 
		            }
		           
					
		            System.out.println(sommef);
		            tva = (sommef*factureClient.getTva())/100;
		            prixttc= sommef+tva;
		            	PdfPCell prixht = new PdfPCell(new Phrase((String.valueOf(sommef))));
		            	prixht.setPaddingLeft(4);
		            	prixht.setVerticalAlignment(Element.ALIGN_MIDDLE);
		            	prixht.setHorizontalAlignment(Element.ALIGN_CENTER);
		                table2.addCell(prixht);
		               
		                PdfPCell tvacell = new PdfPCell(new Phrase((String.valueOf(tva))));
		                tvacell.setPaddingLeft(4);
		                tvacell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		                tvacell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                table2.addCell(tvacell);
		                
		                PdfPCell prixttcell = new PdfPCell(new Phrase(String.valueOf(prixttc)));
		                prixttcell.setPaddingLeft(4);
		                prixttcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		                prixttcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                table2.addCell(prixttcell);
		            
	  
	            document.add(table2);
	            document.add(Chunk.NEWLINE);
	            
	            
	            //convert montant
	            
	            Font fontcaractre = FontFactory.getFont(FontFactory.HELVETICA, 16, BaseColor.BLACK);
		          Paragraph paracaractere = new Paragraph( "Arreter la présente facture à la somme de :", fontcaractre);
		          paracaractere.setAlignment(Element.ALIGN_CENTER);
		          document.add(paracaractere);
		          
		          Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 14, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
		          Paragraph paratotal = new Paragraph( ""+ FrenchNumberToWords.convert(prixttc)+" "+"Dirhams", blueFont);
		          paratotal.setAlignment(Element.ALIGN_CENTER);
		          document.add(paratotal);
		          document.add(Chunk.NEWLINE);
		          
		          Font fontReglement = FontFactory.getFont(FontFactory.HELVETICA, 16, BaseColor.BLACK);
		          Paragraph parareglement = new Paragraph( "Réglement:", fontReglement);
		          parareglement.setAlignment(Element.ALIGN_LEFT);
		          document.add(parareglement);
		          
		          
		        /*  for (Versement factureVersement :factureClient.getVersementFacture()) {
		        	  
		         
		          type = versementClient.getType_versement();
			        if(type.equals("chéque")) {
			        	montant =prixttc-versementClient.getCheque();
			        	 Font fontversement = FontFactory.getFont(FontFactory.HELVETICA, 14, BaseColor.BLACK);
				          Paragraph paraversement = new Paragraph( " montant payé :"+factureVersement.getCheque()+" Dirhams" +" :" +FrenchNumberToWords.convert(versementClient.getCheque())+" "+"Dirhams", fontversement);
				          paraversement.setAlignment(Element.ALIGN_LEFT);
				          document.add(paraversement);
			        }else {
			        	montant =prixttc-versementClient.getEspece();
			        	 Font fontversement = FontFactory.getFont(FontFactory.HELVETICA, 14, BaseColor.BLACK);
				          Paragraph paraversement = new Paragraph( " montant payé :"+factureVersement.getEspece()+" Dirhams" +" :" +FrenchNumberToWords.convert(versementClient.getCheque())+" "+"Dirhams", fontversement);
				          paraversement.setAlignment(Element.ALIGN_LEFT);
				          document.add(paraversement);
					}
			        Font fontreg = FontFactory.getFont(FontFactory.HELVETICA, 14, BaseColor.BLACK);
			          Paragraph parafooterinfor = new Paragraph( "Type versement :"+factureVersement.getType_versement(), fontreg);
			          parafooterinfor.setAlignment(Element.ALIGN_LEFT);
			          document.add(parafooterinfor);
			          
			         
			          
			          Font fontreste = FontFactory.getFont(FontFactory.HELVETICA, 14, BaseColor.BLACK);
			          Paragraph parareste = new Paragraph( " montant resté :"+montant+" Dirhams" +" :" +FrenchNumberToWords.convert(montant)+" "+"Dirhams", fontreg);
			          parareste.setAlignment(Element.ALIGN_LEFT);
			          document.add(parareste);
		          }	*/
		          Chunk linebreak = new Chunk(new DottedLineSeparator());
		          document.add(linebreak);
		          document.add(Chunk.NEWLINE);
		          
		          for(Societe societe : societes) {
		         
		          Paragraph footer = new Paragraph( ""+societe.getTitreFrancais(), blueFont);
		          footer.setAlignment(Element.ALIGN_CENTER);
		          document.add(footer);
		          document.add(Chunk.NEWLINE);
		          Font fontfooter = FontFactory.getFont(FontFactory.HELVETICA, 14, BaseColor.BLACK);
		          Paragraph parafooterinfo = new Paragraph( "ICE :"+societe.getIcen()+"       "+"IF :"+societe.getIfData()+"       "+"PATENTE :" +societe.getPatente() , fontfooter);
		          parafooterinfo.setAlignment(Element.ALIGN_CENTER);
		          document.add(parafooterinfo);
		          document.add(Chunk.NEWLINE);
		          }
		         
		         
	            document.close();
	            
		           
	  }
	        catch(DocumentException e) {
	          logger.error(e.toString());
	        }
	        
	    return new ByteArrayInputStream(out.toByteArray());
	  }

}