package com.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.DetailsDevis;
import com.pfe.exception.ResourceNotFoundException;
import com.pfe.repository.DetailsDevisRepository;
@Service
@Transactional
public class DetailsDevisServiceImpl implements DetailsDevisService {

	@Autowired
	private DetailsDevisRepository detailsDevisRepository;
	@Override
	public DetailsDevis createDetailsDevis(DetailsDevis DetailsDevis) {
		return detailsDevisRepository.save(DetailsDevis);
	}

	@Override
	public DetailsDevis updateDetailsDevis(DetailsDevis detailsDevis) {
		Optional<DetailsDevis> DetailsDevisDb = this.detailsDevisRepository.findById((long) detailsDevis.getIdDetailsDevis());
		
		if(DetailsDevisDb.isPresent()) {
			DetailsDevis DetailsDevisUpdate = DetailsDevisDb.get();
			DetailsDevisUpdate.setIdDetailsDevis(detailsDevis.getIdDetailsDevis());
			DetailsDevisUpdate.setIdDevis(detailsDevis.getIdDevis());
			//DetailsDevisUpdate.setIdProduit(detailsDevis.getIdProduit());
			DetailsDevisUpdate.setPrixTTC(detailsDevis.getPrixTTC());
			DetailsDevisUpdate.setQuantite(detailsDevis.getQuantite());
			detailsDevisRepository.save(DetailsDevisUpdate);
			return DetailsDevisUpdate;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +detailsDevis.getIdDetailsDevis());
		}
	}

	@Override
	public List<DetailsDevis> getAllDetailsDevis() {
		return this.detailsDevisRepository.findAll();
	}

	@Override
	public DetailsDevis getDetailsDevisById(long idDetailsDevis) {
		Optional<DetailsDevis> DetailsDevisDb = this.detailsDevisRepository.findById(idDetailsDevis);
		
		if(DetailsDevisDb.isPresent()) {
			return DetailsDevisDb.get();
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idDetailsDevis);
		}
	}

	@Override
	public void deleteDetailsDevis(long idDetailsDevis) {
		Optional<DetailsDevis> DetailsDevisDb = this.detailsDevisRepository.findById(idDetailsDevis);
		
		if(DetailsDevisDb.isPresent()) {
			this.detailsDevisRepository.delete(DetailsDevisDb.get()) ;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idDetailsDevis);
		}
		
		
	}

}
