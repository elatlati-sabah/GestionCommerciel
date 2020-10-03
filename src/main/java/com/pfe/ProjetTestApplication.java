package com.pfe;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pfe.entity.Compte;
import com.pfe.entity.CompteCourant;
import com.pfe.entity.Retrait;
import com.pfe.entity.Societe;
import com.pfe.entity.Versement;
import com.pfe.repository.CompteRepository;
import com.pfe.repository.OperationRepository;
import com.pfe.repository.SocieteRepository;
import com.pfe.services.IBanqueMetier;




@SpringBootApplication
public class ProjetTestApplication {
	@Autowired
	private SocieteRepository societeRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueMetier banqueMetier;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetTestApplication.class, args);
		
	
	}
	}

	