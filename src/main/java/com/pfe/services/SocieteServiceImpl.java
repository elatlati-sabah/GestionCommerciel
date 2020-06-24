package com.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Societe;
import com.pfe.exception.ResourceNotFoundException;
import com.pfe.repository.SocieteRepository;
@Service
@Transactional
public class SocieteServiceImpl implements SocieteService {
	@Autowired
	private SocieteRepository societeRepo;
	
	@Override
	public Societe createSociete(Societe societe) {	
		return societeRepo.save(societe);
	}

	@Override
	public Societe updateSociete(Societe societe) {
Optional<Societe> SocieteDb = this.societeRepo.findById((long) societe.getId());
		
		if(SocieteDb.isPresent()) {
			Societe SocieteUpdate = SocieteDb.get();
			SocieteUpdate.setId(societe.getId());;
			SocieteUpdate.setAdresseFrancais(societe.getAdresseFrancais());
			SocieteUpdate.setCb(societe.getCb());;
			SocieteUpdate.setActiver(societe.getActiver());
			SocieteUpdate.setCnss(societe.getCnss());
			SocieteUpdate.setIcen(societe.getIcen());
			SocieteUpdate.setIfData(societe.getIfData());
			SocieteUpdate.setLogin(societe.getLogin());
			SocieteUpdate.setLogo(societe.getLogo());
			SocieteUpdate.setPassword(societe.getPassword());
			SocieteUpdate.setPatente(societe.getPatente());
			SocieteUpdate.setRc(societe.getRc());
			SocieteUpdate.setSerial(societe.getSerial());
			SocieteUpdate.setTelephone1(societe.getTelephone1());
			SocieteUpdate.setTelephone2(societe.getTelephone2());
			SocieteUpdate.setTitreFrancais(societe.getTitreFrancais());
			SocieteUpdate.setTVA(societe.getTVA());
			societeRepo.save(SocieteUpdate);
			return SocieteUpdate;
	}
		else {
			throw new ResourceNotFoundException("record not found with id :" +societe.getId());
		}
	}

	@Override
	public List<Societe> getAllSociete() {
		return this.societeRepo.findAll();
	}

	@Override
	public Societe getSocieteById(long id) {
     Optional<Societe> SocieteDb = this.societeRepo.findById(id);
		
		if(SocieteDb.isPresent()) {
			return SocieteDb.get();
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +id);
		}
	}

	@Override
	public void deleteSociete(long id) {
		Optional<Societe> SocieteDb = this.societeRepo.findById(id);
		
		if(SocieteDb.isPresent()) {
			this.societeRepo.delete(SocieteDb.get()) ;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +id);
		}
		
	}

}
