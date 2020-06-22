package com.pfe.services;

import java.util.List;

import com.pfe.entity.Societe;

public interface SocieteService {
	Societe createSociete(Societe societe);
	Societe updateSociete(Societe societe);
	List<Societe> getAllSociete();
	Societe getSocieteById(long id);
	void deleteSociete(long id);

}
