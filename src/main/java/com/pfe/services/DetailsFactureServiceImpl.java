package com.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.DetailsFacture;
import com.pfe.exception.ResourceNotFoundException;
import com.pfe.repository.DetailsFactureRepository;
@Service
@Transactional
public class DetailsFactureServiceImpl implements DetailsFactureService {
	@Autowired
	private DetailsFactureRepository detailsFactureRepository;
	@Override
	public DetailsFacture createDetailsFacture(DetailsFacture detailsFacture) {
		return detailsFactureRepository.save(detailsFacture);
	}

	@Override
	public DetailsFacture updateDetailsFacture(DetailsFacture detailsFacture) {
		Optional<DetailsFacture> DetailsFactureDb = this.detailsFactureRepository.findById((long) detailsFacture.getIdDetailsFacture());
		
		if(DetailsFactureDb.isPresent()) {
			DetailsFacture DetailsFactureUpdate = DetailsFactureDb.get();
			DetailsFactureUpdate.setIdDetailsFacture(detailsFacture.getIdDetailsFacture());
			DetailsFactureUpdate.setIdDetailsFacture(detailsFacture.getIdDetailsFacture());
			//DetailsFactureUpdate.setIdProduit(detailsFacture.getIdProduit());
			DetailsFactureUpdate.setPrixTTC(detailsFacture.getPrixTTC());
			DetailsFactureUpdate.setQuantite(detailsFacture.getQuantite());
			detailsFactureRepository.save(DetailsFactureUpdate);
			return DetailsFactureUpdate;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +detailsFacture.getIdDetailsFacture());
		}
	}

	@Override
	public List<DetailsFacture> getAllDetailsFacture() {
		return this.detailsFactureRepository.findAll();
	}

	@Override
	public DetailsFacture getDetailsFactureById(long idDetailsFacture) {
		Optional<DetailsFacture> DetailsFactureDb = this.detailsFactureRepository.findById(idDetailsFacture);
		
		if(DetailsFactureDb.isPresent()) {
			return DetailsFactureDb.get();
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idDetailsFacture);
		}
	}

	@Override
	public void deleteDetailsFacture(long idDetailsFacture) {
		Optional<DetailsFacture> DetailsFactureDb = this.detailsFactureRepository.findById(idDetailsFacture);
		
		if(DetailsFactureDb.isPresent()) {
			this.detailsFactureRepository.delete(DetailsFactureDb.get()) ;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idDetailsFacture);
		}
		
	}

}
