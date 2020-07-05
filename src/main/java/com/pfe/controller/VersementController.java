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

import com.pfe.entity.Versement;
import com.pfe.services.VersementService;
@RestController
public class VersementController {
	@Autowired
	private VersementService versementService;
	@GetMapping("/versements")
	public ResponseEntity<List<Versement>> getAllVersement(){
		return ResponseEntity.ok().body(versementService.getAllVersement());
	}
	@GetMapping("/versements/{id}")
	public ResponseEntity<Versement> getVersementById(@PathVariable long id){
		return ResponseEntity.ok().body(versementService.getVersementById(id));
	}
	@PostMapping("/createVersement")
	public ResponseEntity<Versement> createVersement(@RequestBody Versement Versement){
		return ResponseEntity.ok().body(this.versementService.createVersement(Versement));
	}

	
	@PutMapping("/updateVersement/{id}")
	public ResponseEntity<Versement> updateVersement(@PathVariable long id , @RequestBody Versement Versement){
		Versement.setId_versement(id);;
		return ResponseEntity.ok().body(this.versementService.updateVersement(Versement));
	}
	@DeleteMapping("/deleteVersement/{id}")
	public HttpStatus deleteVersement(@PathVariable long id){
		this.versementService.deleteVersement(id);
		return HttpStatus.OK;
	}


}
