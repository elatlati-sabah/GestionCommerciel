package com.pfe.services;

import java.util.List;

import com.pfe.entity.Facture;

public interface FactureService {
	Facture createFacture(Facture facture);
	Facture updateFacture(Facture facture);
	List<Facture> getAllFacture();
	Facture getFactureById(long id);
	void deleteFacture(long id);

}
