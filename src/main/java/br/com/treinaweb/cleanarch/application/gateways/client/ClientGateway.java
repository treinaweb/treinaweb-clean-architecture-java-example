package br.com.treinaweb.cleanarch.application.gateways.client;

import java.util.List;

import br.com.treinaweb.cleanarch.enterprise.entities.client.Client;

public interface ClientGateway {
    List<Client> findAll();
    void create(Client client);
}
