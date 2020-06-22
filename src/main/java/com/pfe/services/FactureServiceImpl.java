package com.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Facture;
import com.pfe.exception.ResourceNotFoundException;
import com.pfe.repository.FactureRepository;
@Service
@Transactional
public class FactureServiceImpl implements FactureService {

	@Autowired
	private FactureRepository factureRepository;
	@Override
	public Facture createFacture(Facture facture) {
		return factureRepository.save(facture);
	}

	@Override
	public Facture updateFacture(Facture facture) {
		Optional<Facture> FactureDb = this.factureRepository.findById((long) facture.getId_facture());
		
		if(FactureDb.isPresent()) {
			Facture FactureUpdate = FactureDb.get();
			FactureUpdate.setId_facture(facture.getId_facture());
			//FactureUpdate.setClient(facture.getClient().getId_client());
			FactureUpdate.setDateFacturation(facture.getDateFacturation());
			FactureUpdate.setTva(facture.getTva());
			FactureUpdate.setValider(facture.getValider());
			factureRepository.save(FactureUpdate);
			return FactureUpdate;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +facture.getId_facture());
		}
	}

	@Override
	public List<Facture> getAllFacture() {
		return this.factureRepository.findAll();
	}

	@Override
	public Facture getFactureById(long idFacture) {
		Optional<Facture> FactureDb = this.factureRepository.findById(idFacture);
		
		if(FactureDb.isPresent()) {
			return FactureDb.get();
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idFacture);
		}
	}

	@Override
	public void deleteFacture(long idFacture) {
Optional<Facture> FactureDb = this.factureRepository.findById(idFacture);
		
		if(FactureDb.isPresent()) {
			this.factureRepository.delete(FactureDb.get()) ;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idFacture);
		}
		
	}

}
