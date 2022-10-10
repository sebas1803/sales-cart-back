package com.certicom.codechallenge.salescartback.clients.service;

import com.certicom.codechallenge.salescartback.clients.exception.ClientNotFoundException;
import com.certicom.codechallenge.salescartback.clients.model.Client;
import com.certicom.codechallenge.salescartback.clients.repository.ClientRepository;
import com.certicom.codechallenge.salescartback.sales.exception.SaleNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client findClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException("Client with id" + clientId + "was not found"));
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long clientId, Client client) {
        return clientRepository.findById(clientId).map(
                        request -> clientRepository.save(
                                request.withFirstname(client.getFirstname())
                                        .withLastname(client.getLastname())
                                        .withDni(client.getDni())
                                        .withPhone(client.getPhone())
                                        .withEmail(client.getEmail())))
                .orElseThrow(() -> new ClientNotFoundException("Client with id" + clientId + "was not found"));
    }

    public ResponseEntity<?> deleteClient(Long clientId) {
        return clientRepository.findById(clientId).map(sale -> {
            clientRepository.delete(sale);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new SaleNotFoundException("Client with id" + clientId + "was not found"));
    }
}
