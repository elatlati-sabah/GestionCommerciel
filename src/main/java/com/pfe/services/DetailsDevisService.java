package com.pfe.services;

import java.util.List;

import com.pfe.entity.DetailsDevis;

public interface DetailsDevisService {
	DetailsDevis createDetailsDevis(DetailsDevis detailsDevis);
	DetailsDevis updateDetailsDevis(DetailsDevis detailsDevis);
	List<DetailsDevis> getAllDetailsDevis();
	DetailsDevis getDetailsDevisById(long id);
	void deleteDetailsDevis(long id);

}
