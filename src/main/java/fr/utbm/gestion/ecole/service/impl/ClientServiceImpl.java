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
        System.out.println("Le nouveau client est: " + client);
    }

    public Client getClient(Integer id) {
        return clientRepository.getClient(id);
        
    }

    public void updateCustomer(Client client) {
        client=clientRepository.updateCustomer(client);
        System.out.println("Le client mise à jour :" + client);
    }

    public void deleteClient(Integer id) {
    	clientRepository.deleteClient(id);
        System.out.println("le client a été supprimé");
    }

    public List<Client> getAllCustomers() {
        return clientRepository.getAllClients();
    }
}
