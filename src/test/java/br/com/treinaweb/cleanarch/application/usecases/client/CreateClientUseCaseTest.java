package br.com.treinaweb.cleanarch.application.usecases.client;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.treinaweb.cleanarch.enterprise.entities.client.Client;
import br.com.treinaweb.cleanarch.infra.gateways.client.ClientInMemoryGateway;

public class CreateClientUseCaseTest {

    @Test
    void execute_shouldCreateClient() {
        var gateway = new ClientInMemoryGateway();
        var useCase = new CreateClientUseCase(gateway);
        var client = new Client("Second", "Test", "test@mail.com", "12345678901");
        var createdClient = useCase.execute(client);
        assertEquals(client, createdClient);
    }

}
