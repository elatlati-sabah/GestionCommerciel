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

import com.pfe.entity.DetailsAchat;
import com.pfe.services.DetailsAchatService;

@RestController
public class DetailsAchatController {
	
	@Autowired
	private DetailsAchatService detailsachatService;
	@GetMapping("/detailsachats")
	public ResponseEntity<List<DetailsAchat>> getAllDetailsAchat(){
		return ResponseEntity.ok().body(detailsachatService.getAllDetailsAchat());
	}
	@GetMapping("/detailsachat/{id}")
	public ResponseEntity<DetailsAchat> getDetailsAchatById(@PathVariable long id){
		return ResponseEntity.ok().body(detailsachatService.getDetailsAchatById(id));
	}
	@PostMapping("/createdetailsachat")
	public ResponseEntity<DetailsAchat> createDetailsAchat(@RequestBody DetailsAchat detailsachat){
		return ResponseEntity.ok().body(this.detailsachatService.createDetailsAchat(detailsachat));
	}

	
	@PutMapping("/updatedetailsachat/{id}")
	public ResponseEntity<DetailsAchat> updateDetailsAchat(@PathVariable long id , @RequestBody DetailsAchat detailsachat){
		detailsachat.setIdDetailsAchat((int) id);
		return ResponseEntity.ok().body(this.detailsachatService.updateDetailsAchat(detailsachat));
	}
	@DeleteMapping("/deletedetailsachat/{id}")
	public HttpStatus deleteDetailsAchat(@PathVariable long id){
		this.detailsachatService.deleteDetailsAchat(id);
		return HttpStatus.OK;
	}


}
