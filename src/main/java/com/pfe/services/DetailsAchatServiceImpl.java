package com.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Achat;
import com.pfe.entity.DetailsAchat;
import com.pfe.exception.ResourceNotFoundException;
import com.pfe.repository.DetailsAchatRepository;
@Service
@Transactional
public class DetailsAchatServiceImpl implements DetailsAchatService {

	@Autowired
	private DetailsAchatRepository detailsAchatRepository;
	@Override
	public DetailsAchat createDetailsAchat(DetailsAchat detailsAchat) {
		return detailsAchatRepository.save(detailsAchat);
	}

	@Override
	public DetailsAchat updateDetailsAchat(DetailsAchat detailsAchat) {
		Optional<DetailsAchat> DetailsAchatDb = this.detailsAchatRepository.findById((long) detailsAchat.getIdDetailsAchat());
		
		if(DetailsAchatDb.isPresent()) {
			DetailsAchat DetailsAchatUpdate = DetailsAchatDb.get();
			//DetailsAchatUpdate.setAchat(detailsAchat.getAchat().getId_achat());
			DetailsAchatUpdate.setIdDetailsAchat(detailsAchat.getIdDetailsAchat());
			//DetailsAchatUpdate.setIdProduit(detailsAchat.getIdProduit());
			DetailsAchatUpdate.setPrix(detailsAchat.getPrix());
			DetailsAchatUpdate.setQuantite(detailsAchat.getQuantite());
			detailsAchatRepository.save(DetailsAchatUpdate);
			return DetailsAchatUpdate;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +detailsAchat.getIdDetailsAchat());
		}
	}

	@Override
	public List<DetailsAchat> getAllDetailsAchat() {
		return this.detailsAchatRepository.findAll();
	}

	@Override
	public DetailsAchat getDetailsAchatById(long idDetailsAchat) {
		Optional<DetailsAchat> DetailsAchatDb = this.detailsAchatRepository.findById(idDetailsAchat);
		
		if(DetailsAchatDb.isPresent()) {
			return DetailsAchatDb.get();
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idDetailsAchat);
		}
	}

	@Override
	public void deleteDetailsAchat(long idDetailsAchat) {
		Optional<DetailsAchat> DetailsAchatDb = this.detailsAchatRepository.findById(idDetailsAchat);
		
		if(DetailsAchatDb.isPresent()) {
			this.detailsAchatRepository.delete(DetailsAchatDb.get()) ;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idDetailsAchat);
		}
		
	}

}
