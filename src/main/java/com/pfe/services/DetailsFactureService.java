package com.pfe.services;

import java.util.List;

import com.pfe.entity.DetailsFacture;

public interface DetailsFactureService {
	DetailsFacture createDetailsFacture(DetailsFacture detailsFacture);
	DetailsFacture updateDetailsFacture(DetailsFacture detailsFacture);
	List<DetailsFacture> getAllDetailsFacture();
	DetailsFacture getDetailsFactureById(long id);
	void deleteDetailsFacture(long id);

}
