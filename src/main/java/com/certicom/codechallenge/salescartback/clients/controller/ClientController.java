package com.certicom.codechallenge.salescartback.clients.controller;

import com.certicom.codechallenge.salescartback.clients.mapping.ClientMapper;
import com.certicom.codechallenge.salescartback.clients.model.Client;
import com.certicom.codechallenge.salescartback.clients.resource.ClientResource;
import com.certicom.codechallenge.salescartback.clients.resource.CreateClientResource;
import com.certicom.codechallenge.salescartback.clients.resource.UpdateClientResource;
import com.certicom.codechallenge.salescartback.clients.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Client")
@RestController
@RequestMapping(value = "api/v1/clients", produces = {"application/json"})
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @Operation(summary = "Get all clients")
    @GetMapping()
    public List<ClientResource> getAllClients() {
        return clientMapper.toResource(clientService.getAllClients());
    }

    @Operation(summary = "Get client by id")
    @GetMapping("{id}")
    public ClientResource getClientById(@PathVariable("id") Long id) {
        return clientMapper.toResource(clientService.findClientById(id));
    }

    @Operation(summary = "Create a new client")
    @PostMapping()
    public ClientResource addClient(@RequestBody CreateClientResource resource) {
        return clientMapper.toResource(clientService.createClient(clientMapper.toModel(resource)));
    }

    @Operation(summary = "Update client by id")
    @PutMapping("{id}")
    public ClientResource updateClient(@PathVariable("id") Long id, @RequestBody UpdateClientResource resource) {
        return clientMapper.toResource(clientService.updateClient(id, clientMapper.toModel(resource)));
    }

    @Operation(summary = "Delete client by id")
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long id) {
        return clientService.deleteClient(id);
    }
}
