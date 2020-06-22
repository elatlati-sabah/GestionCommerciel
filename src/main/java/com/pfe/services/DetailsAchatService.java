package com.pfe.services;

import java.util.List;

import com.pfe.entity.DetailsAchat;

public interface DetailsAchatService {
	
	DetailsAchat createDetailsAchat(DetailsAchat detailsAchat);
	DetailsAchat updateDetailsAchat(DetailsAchat detailsAchat);
	List<DetailsAchat> getAllDetailsAchat();
	DetailsAchat getDetailsAchatById(long id);
	void deleteDetailsAchat(long id);

}
