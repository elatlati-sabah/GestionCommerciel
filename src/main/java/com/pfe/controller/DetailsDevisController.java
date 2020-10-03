package com.pfe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfe.entity.DetailsDevis;
import com.pfe.repository.DetailsDevisRepository;
@Controller
@RequestMapping("/detailsdevis/")
public class DetailsDevisController {
	
	private final DetailsDevisRepository detailsdevRepository;
	
	@Autowired
	public DetailsDevisController(DetailsDevisRepository detailsdevRepository) {
		super();
		this.detailsdevRepository = detailsdevRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(DetailsDevis detdevis) {
		return "add-detdevis";
	}

	

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("detdevis", detailsdevRepository.findAll());
		
		return "detdevis";
	}

	@PostMapping("add")
	public String adddDetdevis(@Valid DetailsDevis detdevis, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-detdevis";
		}
		detailsdevRepository.save(detdevis);
		
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		DetailsDevis detdevis = detailsdevRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("detdevis", detdevis);
		return "update-detdevis";
	}

	@PostMapping("update/{id}")
	public String updateDetdevis(@PathVariable("id") long id, @Valid DetailsDevis detdevis, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			detdevis.setIdDetailsDevis(id);
			return "update-detdevis";
		}

		detailsdevRepository.save(detdevis);
		model.addAttribute("achats", detailsdevRepository.findAll());
		return "detdevis";
	}

	@GetMapping("delete/{id}")
	public String deleteDetdevis(@PathVariable("id") long id, Model model) {
		DetailsDevis detdevis = detailsdevRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid produit Id:" + id));
		detailsdevRepository.delete(detdevis);
		model.addAttribute("detdevis", detailsdevRepository.findAll());
		return "detdevis";
	}
	
}
