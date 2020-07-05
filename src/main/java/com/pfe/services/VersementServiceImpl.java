package com.pfe.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.entity.Achat;
import com.pfe.entity.Versement;
import com.pfe.exception.ResourceNotFoundException;
import com.pfe.repository.VersementRepository;
@Service
@Transactional
public class VersementServiceImpl implements VersementService {
	@Autowired
	private VersementRepository versementRepository;

	@Override
	public Versement createVersement(Versement versement) {
		
		return versementRepository.save(versement);
	}

	@Override
	public Versement updateVersement(Versement versement) {
Optional<Versement> VersementDb = this.versementRepository.findById((long) versement.getId_versement());
		
		if(VersementDb.isPresent()) {
			Versement VersementUpdate = VersementDb.get();
			VersementUpdate.setId_versement(versement.getId_versement());
			VersementUpdate.setCheque(versement.getCheque());
			VersementUpdate.setEspece(versement.getEspece());
			VersementUpdate.setType_versement(versement.getType_versement());;
			VersementUpdate.setCompteBancaire(versement.getCompteBancaire());
			versementRepository.save(VersementUpdate);
			return VersementUpdate;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +versement.getId_versement());
		}
	}

	@Override
	public List<Versement> getAllVersement() {
		return this.versementRepository.findAll();
	}

	@Override
	public Versement getVersementById(long id) {
Optional<Versement> VersementDb = this.versementRepository.findById(id);
		
		if(VersementDb.isPresent()) {
			return VersementDb.get();
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +id);
		}
	}

	@Override
	public void deleteVersement(long id) {
Optional<Versement> VersementDb = this.versementRepository.findById(id);
		
		if(VersementDb.isPresent()) {
			this.versementRepository.delete(VersementDb.get()) ;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +id);
		}
		
	}
	
	
}
