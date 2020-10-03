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
import com.pfe.entity.DetailsFacture;
import com.pfe.entity.Facture;
import com.pfe.repository.AchatRepository;
import com.pfe.repository.DetailsAchatRepository;
import com.pfe.repository.DetailsFactureRepository;
import com.pfe.repository.FactureRepository;
import com.pfe.repository.FournisseurRepository;

@Controller
@RequestMapping("/detfactures/")
public class DetailsFactureController {
	
	private final DetailsFactureRepository dtlsfactureRepo;
	
	@Autowired
	public DetailsFactureController(DetailsFactureRepository dtlsfactureRepo) {
		super();
		this.dtlsfactureRepo = dtlsfactureRepo;
	}

	@GetMapping("signup")
	public String showSignUpForm(DetailsFacture dtlsfacture) {
		return "add-dtlsfacture";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("dtlsFactures", dtlsfactureRepo.findAll());
		
		return "dtlsfacture";
	}

	@PostMapping("add")
	public String addDtlsfacture(@Valid DetailsFacture dtlsfacture, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-dtlsfacture";
		}
		dtlsfactureRepo.save(dtlsfacture);
		
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		DetailsFacture dtlsfacture = dtlsfactureRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid detailsFacture Id:" + id));
		model.addAttribute("dtlsfacture", dtlsfacture);
		return "update-dtlsfacture";
	}

	@PostMapping("update/{id}")
	public String updateDtlsFacture(@PathVariable("id") long id, @Valid DetailsFacture dtlsfacture, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			dtlsfacture.setIdDetailsFacture(id);
			return "update-achat";
		}

		dtlsfactureRepo.save(dtlsfacture);
		model.addAttribute("dtlsFactures", dtlsfactureRepo.findAll());
		return "dtlsfacture";
	}

	@GetMapping("delete/{id}")
	public String deleteDtlsFacture(@PathVariable("id") long id, Model model) {
		DetailsFacture dtlsfacture = dtlsfactureRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid details facture Id:" + id));
		dtlsfactureRepo.delete(dtlsfacture);
		model.addAttribute("dtlsFactues", dtlsfactureRepo.findAll());
		return "dtlsfacture";
	}
	

	
}
