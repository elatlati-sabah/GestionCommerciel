package com.pfe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.entity.Produit;
import com.pfe.entity.Societe;
import com.pfe.repository.ClientRepository;
import com.pfe.repository.ProduitRepository;
import com.pfe.repository.SocieteRepository;
import com.pfe.services.SocieteService;

@Controller
@RequestMapping("/societes/")
public class SocieteController {
	@Autowired
	private final SocieteRepository societeRepository;


	@Autowired
	public SocieteController(SocieteRepository societeRepository) {
		super();
		this.societeRepository = societeRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Societe societe) {
		return "add-societe";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("societes", societeRepository.findAll());
		return "index";
	}

	@PostMapping("add")
	public String addSociete(@Valid Societe societe, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-societe";
		}

		societeRepository.save(societe);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Societe societe = societeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("societe", societe);
		return "update-societe";
	}

	@PostMapping("update/{id}")
	public String updateSociete(@PathVariable("id") long id, @Valid Societe societe, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			societe.setId(id);
			
			return "update-societe";
		}

		societeRepository.save(societe);
		model.addAttribute("societes", societeRepository.findAll());
		return "societe";
	}

	@GetMapping("delete/{id}")
	public String deleteSociete(@PathVariable("id") long id, Model model) {
		Societe societe = societeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid produit Id:" + id));
		societeRepository.delete(societe);
		model.addAttribute("societes", societeRepository.findAll());
		return "index";
	}
	

}
