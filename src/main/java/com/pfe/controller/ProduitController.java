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

import com.pfe.entity.Produit;
import com.pfe.repository.ClientRepository;
import com.pfe.repository.ProduitRepository;


@Controller
@RequestMapping("/produits/")
public class ProduitController {
	private final ProduitRepository proRepository;



	@Autowired
	public ProduitController(ProduitRepository proRepository) {
		super();
		this.proRepository = proRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Produit produit) {
		return "add-produit";
	}


	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("produits", proRepository.findAll());
		return "index";
	}

	@PostMapping("add")
	public String addProduit(@Valid Produit produit, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-produit";
		}

		proRepository.save(produit);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Produit produit = proRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid produit Id:" + id));
		model.addAttribute("produit", produit);
		return "update-produit";
	}

	@PostMapping("update/{id}")
	public String updateProduit(@PathVariable("id") long id, @Valid Produit produit, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			produit.setId_produit(id);
			return "update-produit";
		}

		proRepository.save(produit);
		model.addAttribute("produits", proRepository.findAll());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteProduit(@PathVariable("id") long id, Model model) {
		Produit produit = proRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid produit Id:" + id));
		proRepository.delete(produit);
		model.addAttribute("produits", proRepository.findAll());
		return "index";
	}
	

}
