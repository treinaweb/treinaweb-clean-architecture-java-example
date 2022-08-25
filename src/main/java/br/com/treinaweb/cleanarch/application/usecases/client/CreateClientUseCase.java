package br.com.treinaweb.cleanarch.application.usecases.client;

import br.com.treinaweb.cleanarch.application.gateways.client.ClientGateway;
import br.com.treinaweb.cleanarch.enterprise.entities.client.Client;

public class CreateClientUseCase {
    private final ClientGateway clientGateway;

    public CreateClientUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public Client execute(Client client) {
        clientGateway.create(client);
        return client;
    }
}
