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

import com.pfe.entity.DetailsFacture;
import com.pfe.services.DetailsFactureService;

@RestController
public class DetailsFactureController {
	@Autowired
	private DetailsFactureService detailsFactureService;
	
	@GetMapping("/detailsFactures")
	public ResponseEntity<List<DetailsFacture>> getAllDetailsFacture(){
		return ResponseEntity.ok().body(detailsFactureService.getAllDetailsFacture());
	}
	@GetMapping("/detailsFacture/{id}")
	public ResponseEntity<DetailsFacture> getDetailsFactureById(@PathVariable long id){
		return ResponseEntity.ok().body(detailsFactureService.getDetailsFactureById(id));
	}
	@PostMapping("/createdetailsFacture")
	public ResponseEntity<DetailsFacture> createDetailsFacture(@RequestBody DetailsFacture DetailsFacture){
		return ResponseEntity.ok().body(this.detailsFactureService.createDetailsFacture(DetailsFacture));
	}

	
	@PutMapping("/updatedetailsFacture/{id}")
	public ResponseEntity<DetailsFacture> updateDetailsFacture(@PathVariable long id , @RequestBody DetailsFacture DetailsFacture){
		DetailsFacture.setIdDetailsFacture((int) id);
		return ResponseEntity.ok().body(this.detailsFactureService.updateDetailsFacture(DetailsFacture));
	}
	@DeleteMapping("/deletedetailsFacture/{id}")
	public HttpStatus deleteDetailsFacture(@PathVariable long id){
		this.detailsFactureService.deleteDetailsFacture(id);
		return HttpStatus.OK;
	}



}
