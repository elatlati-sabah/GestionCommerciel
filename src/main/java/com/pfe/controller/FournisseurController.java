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

import com.pfe.entity.Achat;
import com.pfe.entity.DetailsAchat;
import com.pfe.entity.Fournisseur;
import com.pfe.repository.AchatRepository;
import com.pfe.repository.DetailsAchatRepository;
import com.pfe.repository.FournisseurRepository;


@Controller
@RequestMapping("/fournisseurs/")
public class FournisseurController {
	

	private final FournisseurRepository fournisseurRepository;
	private final AchatRepository achatRepository;
	
	@Autowired

	public FournisseurController(FournisseurRepository fournisseurRepository, AchatRepository achatRepository) {
		super();
		this.fournisseurRepository = fournisseurRepository;
		this.achatRepository = achatRepository;
	}

	

	@GetMapping("signup")
	public String showSignUpForm(Fournisseur fournisseur) {
		return "add-fournisseur";
	}



	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("fournisseurs", fournisseurRepository.findAll());
		model.addAttribute("achats", achatRepository.findAll());
		
		return "fournisseur";
	}

	@PostMapping("add")
	public String addFournisseur(@Valid Fournisseur fournisseur, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-fournisseur";
		}
		fournisseurRepository.save(fournisseur);
		
		return "redirect:/clients/signup";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Fournisseur fournisseur = fournisseurRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("le fournisseur n'est pas existe Id:" + id));
		model.addAttribute("fournisseurs", fournisseurRepository.findAll());
		return "update-fournisseur";
	}

	@PostMapping("update/{id}")
	public String updateFournisseur(@PathVariable("id") long id, @Valid Fournisseur fournisseur, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			fournisseur.setId_fournisseur(id);
			return "update-fournisseur";
		}

		fournisseurRepository.save(fournisseur);
		model.addAttribute("fournisseurs", fournisseurRepository.findAll());
		return "fournisseur";
	}

	@GetMapping("delete/{id}")
	public String deleteAchat(@PathVariable("id") long id, Model model) {
		Fournisseur fournisseur = fournisseurRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid fournisseur Id:" + id));
		fournisseurRepository.delete(fournisseur);
		model.addAttribute("fournisseurs", fournisseurRepository.findAll());
		return "fournisseur";
	}
}
