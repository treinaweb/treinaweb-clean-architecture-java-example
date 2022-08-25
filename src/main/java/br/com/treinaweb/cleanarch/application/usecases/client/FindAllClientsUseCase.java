package br.com.treinaweb.cleanarch.application.usecases.client;

import java.util.List;

import br.com.treinaweb.cleanarch.application.gateways.client.ClientGateway;
import br.com.treinaweb.cleanarch.enterprise.entities.client.Client;

public class FindAllClientsUseCase {
    private final ClientGateway clientGateway;

    public FindAllClientsUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public List<Client> execute() {
        return clientGateway.findAll();
    }

}
