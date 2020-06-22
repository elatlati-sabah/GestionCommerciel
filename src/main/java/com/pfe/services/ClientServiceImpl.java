package com.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Client;
import com.pfe.exception.ResourceNotFoundException;
import com.pfe.repository.ClientRepository;
@Service
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public Client createClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client updateClient(Client client) {
Optional<Client> ClientDb = this.clientRepository.findById((long) client.getIdClient());
		
		if(ClientDb.isPresent()) {
			Client ClientUpdate = ClientDb.get();
			ClientUpdate.setIdClient(client.getIdClient());
			ClientUpdate.setAdresse(client.getAdresse());
			ClientUpdate.setEmail(client.getEmail());
			ClientUpdate.setIce(client.getIce());
			ClientUpdate.setNomContact(client.getNomContact());
			ClientUpdate.setRaisonSocial(client.getRaisonSocial());
			ClientUpdate.setTelephone(client.getTelephone());
			clientRepository.save(ClientUpdate);
			return ClientUpdate;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +client.getIdClient());
		}
	}

	@Override
	public List<Client> getAllClient() {
		return this.clientRepository.findAll();
	}

	@Override
	public Client getClientById(long idClient) {
		Optional<Client> ClientDb = this.clientRepository.findById(idClient);
		
		if(ClientDb.isPresent()) {
			return ClientDb.get();
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idClient);
		}
	}

	@Override
	public void deleteClient(long idClient) {
		Optional<Client> ClientDb = this.clientRepository.findById(idClient);
		
		if(ClientDb.isPresent()) {
			this.clientRepository.delete(ClientDb.get()) ;
		}
		else {
			throw new ResourceNotFoundException("record not found with id :" +idClient);
		}
		
	}

}
