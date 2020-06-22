package com.pfe.services;

import java.util.List;

import com.pfe.entity.Devis;

public interface DevisService {
	Devis createDevis(Devis devis);
	Devis updateDevis(Devis devis);
	List<Devis> getAllDevis();
	Devis getDevisById(long id);
	void deleteDevis(long id);

}
