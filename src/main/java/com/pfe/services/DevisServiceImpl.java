package com.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Devis;
import com.pfe.exception.ResourceNotFoundException;
import com.pfe.repository.DevisRepository;
@Service
@Transactional
public class DevisServiceImpl implements DevisService {
	@Autowired
	private DevisRepository devisRepository;
	@Override
	public Devis createDevis(Devis devis) {
		return devisRepository.save(devis);
	}

	@Override
	public Devis updateDevis(Devis devis) {
		Optional<Devis> DevisDb = this.devisRepository.findById((long) devis.getIdDevis());
		
		if(DevisDb.isPresent()) {
			Devis DevisUpdate = DevisDb.get();
			//DevisUpdate.setIdClient(devis.getIdClient());
			DevisUpdate.setDateDevis(devis.getDateDevis());
			DevisUpdate.setIdDevis(devis.getIdDevis());
			DevisUpdate.setDevisCounter(devis.getDevisCounter());
			DevisUpdate.setTva(devis.getTva());
			DevisUpdate.setValider(devis.getValider());
			devisRepository.save(DevisUpdate);
			return DevisUpdate;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +devis.getIdDevis());
		}
	}

	@Override
	public List<Devis> getAllDevis() {
		return this.devisRepository.findAll();
	}

	@Override
	public Devis getDevisById(long idDevis) {
		Optional<Devis> DevisDb = this.devisRepository.findById(idDevis);
		
		if(DevisDb.isPresent()) {
			return DevisDb.get();
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idDevis);
		}
	}

	@Override
	public void deleteDevis(long idDevis) {
		Optional<Devis> DevisDb = this.devisRepository.findById(idDevis);
		
		if(DevisDb.isPresent()) {
			this.devisRepository.delete(DevisDb.get()) ;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idDevis);
		}
		
		
	}

}
