package com.pfe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.entity.Achat;
import com.pfe.services.AchatService;

@RestController
public class AchatController {
	@Autowired
	private AchatService achatService;
	@GetMapping("/achats")
	public ResponseEntity<List<Achat>> getAllAchat(){
		return ResponseEntity.ok().body(achatService.getAllAchat());
	}
	@GetMapping("/achats/{id}")
	public ResponseEntity<Achat> getAchatById(@PathVariable long id){
		return ResponseEntity.ok().body(achatService.getAchatById(id));
	}
	@PostMapping("/createachat")
	public ResponseEntity<Achat> createAchat(@RequestBody Achat achat){
		return ResponseEntity.ok().body(this.achatService.createAchat(achat));
	}

	
	@PutMapping("/updateachat/{id}")
	public ResponseEntity<Achat> updateAchat(@PathVariable long id , @RequestBody Achat achat){
		achat.setId_achat((int) id);
		return ResponseEntity.ok().body(this.achatService.updateAchat(achat));
	}
	@DeleteMapping("/deleteachat/{id}")
	public HttpStatus deleteAchat(@PathVariable long id){
		this.achatService.deleteAchat(id);
		return HttpStatus.OK;
	}


}
