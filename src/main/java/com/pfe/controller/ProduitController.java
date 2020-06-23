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

import com.pfe.entity.Produit;
import com.pfe.services.ProduitService;




@RestController
public class ProduitController {
	@Autowired
	private ProduitService produitService;
	 
	
	@GetMapping("/produits")
	public ResponseEntity<List<Produit>> getAllProduit(){
		return ResponseEntity.ok().body(produitService.getAllProduit());
	}
	
	@GetMapping("/produit/{id}")
	public ResponseEntity<Produit> getProduitById(@PathVariable long id){
		return ResponseEntity.ok().body(produitService.getProduitById(id));
	}
	@PostMapping("/createproduit")
	public ResponseEntity<Produit> createProduit(@RequestBody Produit Produit){
		return ResponseEntity.ok().body(this.produitService.createProduit(Produit));
	}

	
	@PutMapping("/updateproduit/{id}")
	public ResponseEntity<Produit> updateProduit(@PathVariable long id , @RequestBody Produit Produit){
		Produit.setId_produit((int) id);
		return ResponseEntity.ok().body(this.produitService.updateProduit(Produit));
	}
	@DeleteMapping("/deleteproduit/{id}")
	public HttpStatus deleteProduit(@PathVariable long id){
		this.produitService.deleteProduit(id);
		return HttpStatus.OK;
	}

	/*@GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return service.exportReport(format);
    }*/

}
