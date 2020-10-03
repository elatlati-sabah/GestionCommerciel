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

import com.pfe.entity.Devis;
import com.pfe.repository.DevisRepository;


@Controller
@RequestMapping("/devis/")
public class DevisController {
	
	private final DevisRepository devisRepository;

	@Autowired
	public DevisController(DevisRepository devisRepository) {
		super();
		this.devisRepository = devisRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Devis devis) {
		return "add-achat";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("devis", devisRepository.findAll());
		return "devis";
	}

	@PostMapping("add")
	public String addDetfact(@Valid Devis devis, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-devis";
		}
		devisRepository.save(devis);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Devis devis = devisRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("devis", devis);
		return "update-devis";
	}

	@PostMapping("update/{id}")
	public String updateDevis(@PathVariable("id") long id, @Valid Devis devis, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			devis.setIdDevis(id);
			return "update-devis";
		}

		devisRepository.save(devis);
		model.addAttribute("detfact", devisRepository.findAll());
		return "devis";
	}

	@GetMapping("delete/{id}")
	public String deleteDevis(@PathVariable("id") long id, Model model) {
		Devis devis = devisRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid produit Id:" + id));
		devisRepository.delete(devis);
		model.addAttribute("devis", devisRepository.findAll());
		return "devis";
	}
	
}
