package fr.utbm.gestion.ecole.service;

import java.util.List;

import fr.utbm.gestion.ecole.entity.Client;

public interface ClientService {

	public void addClient(Client client);

	public Client getClient(Integer id);

	public void updateCustomer(Client client);

	public void deleteClient(Integer id);

	List<Client> getAllCustomers();

}
