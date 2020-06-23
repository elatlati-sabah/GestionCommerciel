package com.pfe.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.entity.Produit;
import com.pfe.repository.ProduitRepository;
import com.pfe.services.PDFGenerator;



@RestController
@RequestMapping("/api/pdf")
public class ExportFacture {
	
	@Autowired
    ProduitRepository produit;
	
    @GetMapping(value = "/facture",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> customersReport() throws IOException {
        List<Produit> produits = (List<Produit>) produit.findAll();
        ByteArrayInputStream bis = PDFGenerator.facturePDFReport(produits);
 
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=facture.pdf");
 
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
