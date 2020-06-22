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

import com.pfe.entity.DetailsDevis;
import com.pfe.services.DetailsDevisService;

@RestController
public class DetailsDevisController {
	@Autowired
	private DetailsDevisService detailsDevisService;
	
	@GetMapping("/detailsDeviss")
	public ResponseEntity<List<DetailsDevis>> getAllDetailsDevis(){
		return ResponseEntity.ok().body(detailsDevisService.getAllDetailsDevis());
	}
	@GetMapping("/detailsDevis/{id}")
	public ResponseEntity<DetailsDevis> getDetailsDevisById(@PathVariable long id){
		return ResponseEntity.ok().body(detailsDevisService.getDetailsDevisById(id));
	}
	@PostMapping("/createDetailsDevis")
	public ResponseEntity<DetailsDevis> createDetailsDevis(@RequestBody DetailsDevis DetailsDevis){
		return ResponseEntity.ok().body(this.detailsDevisService.createDetailsDevis(DetailsDevis));
	}

	
	@PutMapping("/updateDetailsDevis/{id}")
	public ResponseEntity<DetailsDevis> updateDetailsDevis(@PathVariable long id , @RequestBody DetailsDevis DetailsDevis){
		DetailsDevis.setIdDetailsDevis((int) id);
		return ResponseEntity.ok().body(this.detailsDevisService.updateDetailsDevis(DetailsDevis));
	}
	@DeleteMapping("/deleteDetailsDevis/{id}")
	public HttpStatus deleteDetailsDevis(@PathVariable long id){
		this.detailsDevisService.deleteDetailsDevis(id);
		return HttpStatus.OK;
	}



}
