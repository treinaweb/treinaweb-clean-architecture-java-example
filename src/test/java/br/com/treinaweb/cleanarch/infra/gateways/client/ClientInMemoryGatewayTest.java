package br.com.treinaweb.cleanarch.infra.gateways.client;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.treinaweb.cleanarch.enterprise.entities.client.Client;

public class ClientInMemoryGatewayTest {

    @Test
    void findAll_shouldReturnAllClients() {
        var gateway = new ClientInMemoryGateway();
        var expectedClients = List.of(new Client("Test", "Test", "test@mail.com", "12345678912"));
        var clients = gateway.findAll();
        assertEquals(1, clients.size());
        assertEquals(expectedClients, clients);
    }

    @Test
    void create_shouldAddClientToGateway() {
        var gateway = new ClientInMemoryGateway();
        var client = new Client("Second", "Test", "teste@mail.com", "12345678901");
        gateway.create(client);
        var clients = gateway.findAll();
        assertEquals(2, clients.size());
        assertTrue(clients.contains(client));
    }
}
