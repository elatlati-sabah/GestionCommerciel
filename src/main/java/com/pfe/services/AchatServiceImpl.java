package com.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.exception.ResourceNotFoundException;
import com.pfe.entity.Achat;
import com.pfe.repository.AchatRepository;
@Service
@Transactional
public class AchatServiceImpl implements AchatService {

	@Autowired
	private AchatRepository achatRepository;
	@Override
	public Achat createAchat(Achat achat) {
		
		return achatRepository.save(achat);
	}

	@Override
	public Achat updateAchat(Achat achat) {
		Optional<Achat> AchatDb = this.achatRepository.findById((long) achat.getId_achat());
		
		if(AchatDb.isPresent()) {
			Achat AchatUpdate = AchatDb.get();
			AchatUpdate.setId_achat(achat.getId_achat());
			/*for(Fournisseur fournisseur : achat.getFournisseur()) {
          	  System.out.println(fournisseur.getIdFournisseur());
            }*/
			
			AchatUpdate.setDateAchat(achat.getDateAchat());
			AchatUpdate.setRefAchat(achat.getRefAchat());
			AchatUpdate.setValider(achat.getValider());
			achatRepository.save(AchatUpdate);
			return AchatUpdate;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +achat.getId_achat());
		}
	}

	@Override
	public List<Achat> getAllAchat() {
		return this.achatRepository.findAll();
	}

	@Override
	public Achat getAchatById(long idAchat) {
		Optional<Achat> AchatDb = this.achatRepository.findById(idAchat);
		
		if(AchatDb.isPresent()) {
			return AchatDb.get();
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idAchat);
		}
	}

	@Override
	public void deleteAchat(long idAchat) {
		Optional<Achat> AchatDb = this.achatRepository.findById(idAchat);
		
		if(AchatDb.isPresent()) {
			this.achatRepository.delete(AchatDb.get()) ;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idAchat);
		}
		
	}

}
