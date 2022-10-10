package com.certicom.codechallenge.salescartback.clients.mapping;

import com.certicom.codechallenge.salescartback.clients.model.Client;
import com.certicom.codechallenge.salescartback.clients.resource.ClientResource;
import com.certicom.codechallenge.salescartback.clients.resource.CreateClientResource;
import com.certicom.codechallenge.salescartback.clients.resource.UpdateClientResource;
import com.certicom.codechallenge.salescartback.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientMapper {

    @Autowired
    private EnhancedModelMapper mapper;

    public ClientResource toResource(Client model) {
        return mapper.map(model, ClientResource.class);
    }

    public List<ClientResource> toResource(List<Client> model) {
        return mapper.mapList(model, ClientResource.class);
    }

    public Client toModel(CreateClientResource resource) {
        return mapper.map(resource, Client.class);
    }

    public Client toModel(UpdateClientResource resource) {
        return mapper.map(resource, Client.class);
    }
}