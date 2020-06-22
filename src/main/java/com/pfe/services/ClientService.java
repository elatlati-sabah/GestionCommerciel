package com.pfe.services;

import java.util.List;

import com.pfe.entity.Client;

public interface ClientService {

	Client createClient(Client client);
	Client updateClient(Client client);
	List<Client> getAllClient();
	Client getClientById(long id);
	void deleteClient(long id);
}
