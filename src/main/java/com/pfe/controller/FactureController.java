package com.pfe.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.pfe.entity.Achat;
import com.pfe.entity.DetailsAchat;
import com.pfe.entity.DetailsFacture;
import com.pfe.entity.Facture;
import com.pfe.entity.User;
import com.pfe.repository.AchatRepository;
import com.pfe.repository.DetailsAchatRepository;
import com.pfe.repository.DetailsFactureRepository;
import com.pfe.repository.FactureRepository;
import com.pfe.repository.FournisseurRepository;
import com.pfe.repository.UserRepository;
import com.pfe.services.FactureService;

@Controller
@RequestMapping("/factures/")
public class FactureController {
	
	private final FactureRepository factureRepo;
	
	@Autowired
	public FactureController(FactureRepository factureRepo) {
		super();
		this.factureRepo = factureRepo;
	}


	@GetMapping("signup")
	public String showSignUpForm(Facture facture) {
		return "add-facture";
	}

	
	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("factures", factureRepo.findAll());
		return "facture";
	}

	@PostMapping("add")
	public String addFacture(@Valid Facture facture, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-facture";
		}
		factureRepo.save(facture);
		
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Facture facture = factureRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid facture Id:" + id));
		model.addAttribute("facture", facture);
		return "update-facture";
	}

	@PostMapping("update/{id}")
	public String updateFacture(@PathVariable("id") long id, @Valid Facture facture, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			facture.setId_facture(id);
			return "update-facture";
		}
		factureRepo.save(facture);
		model.addAttribute("factures", factureRepo.findAll());
		return "facture";
	}

	@GetMapping("delete/{id}")
	public String deleteFacture(@PathVariable("id") long id, Model model) {
		Facture facture = factureRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid facture Id:" + id));
		factureRepo.delete(facture);
		model.addAttribute("factures", factureRepo.findAll());
		return "facture";
	}
	
}
