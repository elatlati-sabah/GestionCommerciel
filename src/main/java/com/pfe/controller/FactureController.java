package com.pfe.controller;


import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.pfe.entity.Facture;
import com.pfe.entity.User;
import com.pfe.repository.FactureRepository;
import com.pfe.repository.UserRepository;
import com.pfe.services.ExportFactureService;
import com.pfe.services.FactureService;

@RestController
public class FactureController {
	@Autowired
	private FactureService factureService;
	@Autowired
	private ExportFactureService exportService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FactureRepository factureRepository;
	@GetMapping("/factures")
	public ResponseEntity<List<Facture>> getAllFacture(){
		return ResponseEntity.ok().body(factureService.getAllFacture());
	}
	@GetMapping("/facture/{id}")
	public ResponseEntity<Facture> getFactureById(@PathVariable long id){
		return ResponseEntity.ok().body(factureService.getFactureById(id));
	}
	@PostMapping("/createfacture")
	public ResponseEntity<Facture> createFacture(@RequestBody Facture Facture){
		return ResponseEntity.ok().body(this.factureService.createFacture(Facture));
	}

	
	@PutMapping("/updatefacture/{id}")
	public ResponseEntity<Facture> updateFacture(@PathVariable long id , @RequestBody Facture Facture){
		Facture.setId_facture((int) id);
		return ResponseEntity.ok().body(this.factureService.updateFacture(Facture));
	}
	@DeleteMapping("/deletefacture/{id}")
	public HttpStatus deleteFacture(@PathVariable long id){
		this.factureService.deleteFacture(id);
		return HttpStatus.OK;
	}

@GetMapping("/export/pdf")

public ResponseEntity<InputStreamResource> exportTermspdf()
{
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	Optional<User> user = userRepository.findByUsername(authentication.getName());
	List<Facture> facture = (List<Facture>)factureRepository.findFactureByUserId(user.get().getId());
	ByteArrayInputStream bais = exportService.FacturePDFReport(facture);
	HttpHeaders  headers = new HttpHeaders();
	headers.add("Content.Disposition","inline; filename=facture.pdf");
	return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais));
}

}
