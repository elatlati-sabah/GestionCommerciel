package com.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Societe;
import com.pfe.exception.ResourceNotFoundException;
import com.pfe.repository.SocieteRepository;
@Service
@Transactional
public class SocieteServiceImpl implements SocieteService {

	private SocieteRepository societeRepository;
	@Override
	public Societe createSociete(Societe societe) {
		return societeRepository.save(societe);
	}

	@Override
	public Societe updateSociete(Societe societe) {
		Optional<Societe> SocieteDb = this.societeRepository.findById((long) societe.getId());
		
		if(SocieteDb.isPresent()) {
			Societe SocieteUpdate = SocieteDb.get();
			SocieteUpdate.setId(societe.getId());
			SocieteUpdate.setActiver(societe.getActiver());
			SocieteUpdate.setAdresseFrancais(societe.getAdresseFrancais());
			SocieteUpdate.setCb(societe.getCb());
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
			societeRepository.save(SocieteUpdate);
			return SocieteUpdate;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +societe.getId());
		}
	}

	@Override
	public List<Societe> getAllSociete() {
		return this.societeRepository.findAll();
	}

	@Override
	public Societe getSocieteById(long idSociete) {
		Optional<Societe> SocieteDb = this.societeRepository.findById(idSociete);
		
		if(SocieteDb.isPresent()) {
			return SocieteDb.get();
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idSociete);
		}
	}

	@Override
	public void deleteSociete(long idSociete) {
Optional<Societe> SocieteDb = this.societeRepository.findById(idSociete);
		
		if(SocieteDb.isPresent()) {
			this.societeRepository.delete(SocieteDb.get()) ;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idSociete);
		}
		
	}

}
