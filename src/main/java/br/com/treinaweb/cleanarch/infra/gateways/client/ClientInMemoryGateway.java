package br.com.treinaweb.cleanarch.infra.gateways.client;

import java.util.ArrayList;
import java.util.List;

import br.com.treinaweb.cleanarch.application.gateways.client.ClientGateway;
import br.com.treinaweb.cleanarch.enterprise.entities.client.Client;

public class ClientInMemoryGateway implements ClientGateway {

    private List<Client> clients;

    public ClientInMemoryGateway() {
        clients = new ArrayList<>(List.of(
            new Client(
                "Test",
                "Test",
                "test@mail.com",
                "12345678912")
            )
        );
    }

    @Override
    public List<Client> findAll() {
        return List.copyOf(clients);
    }

    @Override
    public void create(Client client) {
        clients.add(client);
    }

}
