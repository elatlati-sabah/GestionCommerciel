package com.pfe.services;

import java.util.List;

import com.pfe.entity.Categorie;

public interface CategorieService {
	Categorie createCategorie(Categorie categorie);
	Categorie updateCategorie(Categorie categorie);
	List<Categorie> getAllCategorie();
	Categorie getCategorieById(long id);
	void deleteCategorie(long id);

}
