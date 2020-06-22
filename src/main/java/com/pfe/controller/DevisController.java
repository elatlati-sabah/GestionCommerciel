package com.pfe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.entity.Devis;
import com.pfe.services.DevisService;

@RestController
public class DevisController {
	@Autowired
	private DevisService devisService;
	
	@GetMapping("/devis")
	public ResponseEntity<List<Devis>> getAllDevis(){
		return ResponseEntity.ok().body(devisService.getAllDevis());
	}
	@GetMapping("/devis/{id}")
	public ResponseEntity<Devis> getDevisById(@PathVariable long id){
		return ResponseEntity.ok().body(devisService.getDevisById(id));
	}
	@PostMapping("/createdevis")
	public ResponseEntity<Devis> createDevis(@RequestBody Devis Devis){
		return ResponseEntity.ok().body(this.devisService.createDevis(Devis));
	}

	
	@PutMapping("/updatedevis/{id}")
	public ResponseEntity<Devis> updateDevis(@PathVariable long id , @RequestBody Devis Devis){
		Devis.setIdDevis((int) id);
		return ResponseEntity.ok().body(this.devisService.updateDevis(Devis));
	}
	@DeleteMapping("/deletedevis/{id}")
	public HttpStatus deleteDevis(@PathVariable long id){
		this.devisService.deleteDevis(id);
		return HttpStatus.OK;
	}



}
