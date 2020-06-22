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

import com.pfe.entity.Fournisseur;
import com.pfe.services.FournisseurService;

@RestController
public class FournisseurController {
	@Autowired
	private FournisseurService fournisseurService;
	
	@GetMapping("/fournisseurs")
	public ResponseEntity<List<Fournisseur>> getAllFournisseur(){
		return ResponseEntity.ok().body(fournisseurService.getAllFournisseur());
	}
	@GetMapping("/fournisseur/{id}")
	public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable long id){
		return ResponseEntity.ok().body(fournisseurService.getFournisseurById(id));
	}
	@PostMapping("/createfournisseur")
	public ResponseEntity<Fournisseur> createFournisseur(@RequestBody Fournisseur Fournisseur){
		return ResponseEntity.ok().body(this.fournisseurService.createFournisseur(Fournisseur));
	}

	
	@PutMapping("/updatefournisseur/{id}")
	public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable long id , @RequestBody Fournisseur Fournisseur){
		Fournisseur.setId_fournisseur((int) id);
		return ResponseEntity.ok().body(this.fournisseurService.updateFournisseur(Fournisseur));
	}
	@DeleteMapping("/deletefournisseur/{id}")
	public HttpStatus deleteFournisseur(@PathVariable long id){
		this.fournisseurService.deleteFournisseur(id);
		return HttpStatus.OK;
	}



}
