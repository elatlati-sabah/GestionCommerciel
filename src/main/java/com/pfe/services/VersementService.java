package com.pfe.services;

import java.util.List;

import com.pfe.entity.Versement;

public interface VersementService {

	Versement createVersement(Versement versement);
	Versement updateVersement(Versement versement);
	List<Versement> getAllVersement();
	Versement getVersementById(long id);
	void deleteVersement(long id);
}
