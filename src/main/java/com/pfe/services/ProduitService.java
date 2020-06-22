package com.pfe.services;

import java.util.List;

import com.pfe.entity.Produit;

public interface ProduitService {
	Produit createProduit(Produit produit);
	Produit updateProduit(Produit produit);
	List<Produit> getAllProduit();
	Produit getProduitById(long id);
	void deleteProduit(long id);

}
