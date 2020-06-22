package com.pfe.services;

import java.util.List;

import com.pfe.entity.Fournisseur;

public interface FournisseurService {
	Fournisseur createFournisseur(Fournisseur fournisseur);
	Fournisseur updateFournisseur(Fournisseur fournisseur);
	List<Fournisseur> getAllFournisseur();
	Fournisseur getFournisseurById(long id);
	void deleteFournisseur(long id);

}
