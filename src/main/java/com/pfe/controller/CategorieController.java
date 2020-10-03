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

import com.pfe.entity.Categorie;
import com.pfe.repository.CategorieRepository;

@Controller
@RequestMapping("/categories/")
public class CategorieController {
	
	private final CategorieRepository catRepository;
	
	@Autowired
	public CategorieController(CategorieRepository catRepository) {
		super();
		this.catRepository = catRepository;
	}
	
	
	@GetMapping("signup")
	public String showSignUpForm(Categorie categorie) {
		return "add-categorie";
	}

	
	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("categories", catRepository.findAll());
		
		return "categorie";
	}

	@PostMapping("add")
	public String addCat(@Valid Categorie categorie, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-categorie";
		}
		catRepository.save(categorie);
		
		return "redirect:/fournisseurs/signup";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Categorie categorie = catRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid categorie Id:" + id));
		model.addAttribute("categorie", categorie);
		return "update-categorie";
	}

	@PostMapping("update/{id}")
	public String updateCat(@PathVariable("id") long id, @Valid Categorie categorie, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			categorie.setId_categorie(id);
			return "update-categorie";
		}

		catRepository.save(categorie);
		model.addAttribute("categories", catRepository.findAll());
		return "categorie";
	}

	@GetMapping("delete/{id}")
	public String deleteCat(@PathVariable("id") long id, Model model) {
		Categorie categorie = catRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid produit Id:" + id));
		catRepository.delete(categorie);
		model.addAttribute("categories", catRepository.findAll());
		return "categorie";
	}
	
	
}
