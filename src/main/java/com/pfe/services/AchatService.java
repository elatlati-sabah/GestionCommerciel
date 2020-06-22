package com.pfe.services;

import java.util.List;

import com.pfe.entity.Achat;



public interface AchatService {

	Achat createAchat(Achat achat);
	Achat updateAchat(Achat achat);
	List<Achat> getAllAchat();
	Achat getAchatById(long id);
	void deleteAchat(long id);
}
