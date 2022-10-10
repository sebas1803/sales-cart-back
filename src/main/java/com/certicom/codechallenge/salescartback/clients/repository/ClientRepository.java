package com.certicom.codechallenge.salescartback.clients.repository;

import com.certicom.codechallenge.salescartback.clients.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {


}
