package com.pfe.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.entity.Facture;
import com.pfe.entity.Produit;
import com.pfe.entity.Societe;
import com.pfe.repository.FactureRepository;
import com.pfe.repository.ProduitRepository;
import com.pfe.repository.SocieteRepository;
import com.pfe.services.FactureServiceImpl;
import com.pfe.services.PDFGenerator;



@RestController
@RequestMapping("/api/pdf")
public class ExportFacture {
	
	@Autowired
    ProduitRepository produit;
	
	@Autowired
    SocieteRepository societe;
	
	@Autowired
   FactureServiceImpl factureService;

	private long idFacture;
	
    @GetMapping(value = "/facture",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> customersReport() throws IOException {
        List<Produit> produits = (List<Produit>) produit.findAll();
        Facture factureClient = new Facture();
        List<Societe> societes = (List<Societe>) societe.findAll();
        
		factureClient = factureService.getFactureById(idFacture);
        ByteArrayInputStream bis = PDFGenerator.facturePDFReport(produits,factureClient,societes);
 
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=facture.pdf");
 
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
