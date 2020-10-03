package com.pfe.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfe.entity.Client;
import com.pfe.repository.ClientRepository;



@Controller
@RequestMapping("/clients/")
public class ClientController {
	private final ClientRepository clientRepository;

	@Autowired
	public ClientController(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}


	@GetMapping("signup")
	public String showSignUpForm(Client client) {
		return "add-client";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("clients", clientRepository.findAll());
		return "client";
	}

	@PostMapping("add")
	public String addStudent(@Valid Client client, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-client";
		}

		clientRepository.save(client);
		return "redirect:/produits/signup";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("client", client);
		return "update-client";
	}

	@PostMapping("update/{id}")
	public String updateStudent(@PathVariable("id") long id, @Valid Client client, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			client.setId_client(id);;
			return "update-Client";
		}

		clientRepository.save(client);
		model.addAttribute("Clients", clientRepository.findAll());
		return "client";
	}

	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") long id, Model model) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		clientRepository.delete(client);
		model.addAttribute("clients", clientRepository.findAll());
		return "client";
	}
	

	
}
