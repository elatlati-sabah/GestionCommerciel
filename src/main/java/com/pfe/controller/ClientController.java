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

import com.pfe.entity.Client;
import com.pfe.services.ClientService;

@RestController
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/clients")
	public ResponseEntity<List<Client>> getAllClient(){
		return ResponseEntity.ok().body(clientService.getAllClient());
	}
	@GetMapping("/client/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable long id){
		return ResponseEntity.ok().body(clientService.getClientById(id));
	}
	@PostMapping("/createclient")
	public ResponseEntity<Client> createClient(@RequestBody Client Client){
		return ResponseEntity.ok().body(this.clientService.createClient(Client));
	}

	
	@PutMapping("/updateclient/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable long id , @RequestBody Client Client){
		Client.setIdClient((int) id);
		return ResponseEntity.ok().body(this.clientService.updateClient(Client));
	}
	@DeleteMapping("/deleteclient/{id}")
	public HttpStatus deleteClient(@PathVariable long id){
		this.clientService.deleteClient(id);
		return HttpStatus.OK;
	}


}
