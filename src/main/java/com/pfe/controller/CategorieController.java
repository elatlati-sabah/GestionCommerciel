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

import com.pfe.entity.Categorie;
import com.pfe.services.CategorieService;

@RestController
public class CategorieController {
	@Autowired
	private CategorieService categorieService;
	
	@GetMapping("/categories")
	public ResponseEntity<List<Categorie>> getAllCategorie(){
		return ResponseEntity.ok().body(categorieService.getAllCategorie());
	}
	@GetMapping("/categories/{id}")
	public ResponseEntity<Categorie> getCategorieById(@PathVariable long id){
		return ResponseEntity.ok().body(categorieService.getCategorieById(id));
	}
	@PostMapping("/createcategorie")
	public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie Categorie){
		return ResponseEntity.ok().body(this.categorieService.createCategorie(Categorie));
	}

	
	@PutMapping("/updatecategorie/{id}")
	public ResponseEntity<Categorie> updateCategorie(@PathVariable long id , @RequestBody Categorie Categorie){
		Categorie.setId_categorie((int) id);
		return ResponseEntity.ok().body(this.categorieService.updateCategorie(Categorie));
	}
	@DeleteMapping("/deletecategorie/{id}")
	public HttpStatus deleteCategorie(@PathVariable long id){
		this.categorieService.deleteCategorie(id);
		return HttpStatus.OK;
	}



}
