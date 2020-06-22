package com.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Fournisseur;
import com.pfe.exception.ResourceNotFoundException;
import com.pfe.repository.FournisseurRepository;
@Service
@Transactional
public class FournisseurServiceImpl implements FournisseurService {
    @Autowired
    private FournisseurRepository fournisseurRepository;
	@Override
	public Fournisseur createFournisseur(Fournisseur fournisseur) {
		
		return fournisseurRepository.save(fournisseur);
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur fournisseur) {
		Optional<Fournisseur> FournisseurDb = this.fournisseurRepository.findById((long) fournisseur.getId_fournisseur());
		
		if(FournisseurDb.isPresent()) {
			Fournisseur FournisseurUpdate = FournisseurDb.get();
			FournisseurUpdate.setId_fournisseur(fournisseur.getId_fournisseur());
			FournisseurUpdate.setAdresse(fournisseur.getAdresse());
			FournisseurUpdate.setIdentifiant(fournisseur.getIdentifiant());
			FournisseurUpdate.setNom(fournisseur.getNom());
			FournisseurUpdate.setTelephone(fournisseur.getTelephone());
			fournisseurRepository.save(FournisseurUpdate);
			return FournisseurUpdate;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +fournisseur.getId_fournisseur());
		}
	}

	@Override
	public List<Fournisseur> getAllFournisseur() {
		return this.fournisseurRepository.findAll();
	}

	@Override
	public Fournisseur getFournisseurById(long idFournisseur) {
		Optional<Fournisseur> FournisseurDb = this.fournisseurRepository.findById(idFournisseur);
		
		if(FournisseurDb.isPresent()) {
			return FournisseurDb.get();
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idFournisseur);
		}
	}

	@Override
	public void deleteFournisseur(long idFournisseur) {
		Optional<Fournisseur> FournisseurDb = this.fournisseurRepository.findById(idFournisseur);
		
		if(FournisseurDb.isPresent()) {
			this.fournisseurRepository.delete(FournisseurDb.get()) ;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idFournisseur);
		}
		
		
	}

}
