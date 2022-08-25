package br.com.treinaweb.cleanarch.application.usecases.client;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.treinaweb.cleanarch.enterprise.entities.client.Client;
import br.com.treinaweb.cleanarch.infra.gateways.client.ClientInMemoryGateway;

public class FindAllClientsUseCaseTest {

    @Test
    void execute_shouldReturnAllClients() {
        var gateway = new ClientInMemoryGateway();
        var useCase = new FindAllClientsUseCase(gateway);
        var expectedClients = List.of(new Client("Test", "Test", "test@mail.com", "12345678912"));
        var clients = useCase.execute();
        assertEquals(1, clients.size());
        assertEquals(expectedClients, clients);
    }
}
