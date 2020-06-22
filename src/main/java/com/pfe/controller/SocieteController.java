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

import com.pfe.entity.Societe;
import com.pfe.services.SocieteService;

@RestController
public class SocieteController {
	@Autowired
	private SocieteService societeService;
	
	@GetMapping("/societes")
	public ResponseEntity<List<Societe>> getAllSociete(){
		return ResponseEntity.ok().body(societeService.getAllSociete());
	}
	@GetMapping("/societe/{id}")
	public ResponseEntity<Societe> getSocieteById(@PathVariable long id){
		return ResponseEntity.ok().body(societeService.getSocieteById(id));
	}
	@PostMapping("/createsociete")
	public ResponseEntity<Societe> createSociete(@RequestBody Societe Societe){
		return ResponseEntity.ok().body(this.societeService.createSociete(Societe));
	}

	
	@PutMapping("/updatesociete/{id}")
	public ResponseEntity<Societe> updateSociete(@PathVariable long id , @RequestBody Societe Societe){
		Societe.setId((int) id);
		return ResponseEntity.ok().body(this.societeService.updateSociete(Societe));
	}
	@DeleteMapping("/deletesociete/{id}")
	public HttpStatus deleteSociete(@PathVariable long id){
		this.societeService.deleteSociete(id);
		return HttpStatus.OK;
	}



}
