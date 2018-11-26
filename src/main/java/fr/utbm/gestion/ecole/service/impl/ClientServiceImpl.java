package fr.utbm.gestion.ecole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.utbm.gestion.ecole.entity.Client;
import fr.utbm.gestion.ecole.repository.ClientRepository;
import fr.utbm.gestion.ecole.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	
	public void addClient(Client client) {
        client = clientRepository.addClient(client);
        System.out.println("Le nouveau client est: " + client.toString());
    }

    public Client getClient(Integer id) {
    	Client client=clientRepository.findClient(id);
    	System.out.println("Le client corresppondant à "+id+ "est: " + client.toString());
        return client;
        
    }

    public void updateClient(Client client) {
        client=clientRepository.updateClient(client);
        System.out.println("Le client mise à jour :" + client.toString());
    }

    public void deleteClient(Integer id) {
    	clientRepository.deleteClient(id);
        System.out.println("le client avec pour "+id+ "a été supprimé");
    }

    public List<Client> getAllClients() {
    	List<Client> clients=clientRepository.findAllClients();
    	System.out.println("la liste des clients: " + clients.toString());
        return clients;
    }
}
