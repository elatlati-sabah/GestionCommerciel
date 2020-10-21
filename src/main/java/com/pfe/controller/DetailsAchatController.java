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
import org.springframework.web.servlet.ModelAndView;

import com.pfe.entity.Achat;
import com.pfe.entity.DetailsAchat;
import com.pfe.repository.AchatRepository;
import com.pfe.repository.DetailsAchatRepository;
import com.pfe.repository.FournisseurRepository;
@Controller
@RequestMapping("/detailsachats/")
public class DetailsAchatController {
	
	
	private final DetailsAchatRepository detailsRepository;
	


	@Autowired
	public DetailsAchatController(DetailsAchatRepository detailsRepository) {
		super();
		this.detailsRepository = detailsRepository;
	}

	

	@GetMapping("signup")
	public String showSignUpForm(DetailsAchat detailsachat) {
		return "add-detailsachat";
	}

	
	@GetMapping("list")
	public String showUpdateForm(Model model) {
		ModelAndView modelAndView = new ModelAndView();

	    modelAndView.addObject("detailsachat", new DetailsAchat());
		model.addAttribute("detailsachat", detailsRepository.findAll());
		
		return "detailsachat";
	}

	@PostMapping("add")
	public String addAchat(@Valid DetailsAchat detailsachat, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "add-detailsachat";
		}
		detailsRepository.save(detailsachat);
		
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		DetailsAchat detailsachat = detailsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Achat Id:" + id));
		model.addAttribute("detailsachat", detailsRepository.findAll());
		return "update-detailsachat";
	}

	@PostMapping("update/{id}")
	public String updateAchat(@PathVariable("id") long id, @Valid DetailsAchat detailsachat, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			detailsachat.setIdDetailsAchat(id);
			return "update-detailsachat";
		}

		detailsRepository.save(detailsachat);
		model.addAttribute("detailsachat", detailsRepository.findAll());
		return "detailsachat";
	}

	@GetMapping("delete/{id}")
	public String deleteAchat(@PathVariable("id") long id, Model model) {
		DetailsAchat detailsachat = detailsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid produit Id:" + id));
		detailsRepository.delete(detailsachat);
		model.addAttribute("detailsachat", detailsRepository.findAll());
		return "detailsachat";
	}
	
	
}
