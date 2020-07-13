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

import com.pfe.entity.Achat;
import com.pfe.entity.Produit;
import com.pfe.repository.AchatRepository;
import com.pfe.repository.ClientRepository;
import com.pfe.repository.DetailsAchatRepository;
import com.pfe.repository.FournisseurRepository;
import com.pfe.repository.ProduitRepository;

@Controller
@RequestMapping("/achats/")
public class AchatController {
	
	private final AchatRepository achatRepository;

	private final FournisseurRepository fournisseurRepository;
	
	private final DetailsAchatRepository detailsRepository;

	@Autowired
	
	public AchatController(AchatRepository achatRepository, FournisseurRepository fournisseurRepository,
			DetailsAchatRepository detailsRepository) {
		super();
		this.achatRepository = achatRepository;
		this.fournisseurRepository = fournisseurRepository;
		this.detailsRepository = detailsRepository;
	}


	@GetMapping("signup")
	public String showSignUpForm(Achat achat) {
		return "add-achat";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("achats", achatRepository.findAll());
		model.addAttribute("details", detailsRepository.findAll());
		return "achat";
	}

	@PostMapping("add")
	public String addAchat(@Valid Achat achat, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-achat";
		}

		achatRepository.save(achat);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Achat achat = achatRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("achat", achat);
		model.addAttribute("fournisseurs", fournisseurRepository.findAll());
		model.addAttribute("details", detailsRepository.findAll());
		return "update-achat";
	}

	@PostMapping("update/{id}")
	public String updateAchat(@PathVariable("id") long id, @Valid Achat achat, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			achat.setId_achat(id);
			return "update-achat";
		}

		achatRepository.save(achat);
		model.addAttribute("achats", achatRepository.findAll());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteAchat(@PathVariable("id") long id, Model model) {
		Achat achat = achatRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid produit Id:" + id));
		achatRepository.delete(achat);
		model.addAttribute("achats", achatRepository.findAll());
		return "index";
	}
	
}
