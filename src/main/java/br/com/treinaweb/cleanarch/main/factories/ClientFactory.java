package br.com.treinaweb.cleanarch.main.factories;

import br.com.treinaweb.cleanarch.application.gateways.client.ClientGateway;
import br.com.treinaweb.cleanarch.application.usecases.client.CreateClientUseCase;
import br.com.treinaweb.cleanarch.application.usecases.client.FindAllClientsUseCase;
import br.com.treinaweb.cleanarch.infra.controllers.client.CreateClientController;
import br.com.treinaweb.cleanarch.infra.controllers.client.FindAllClientsController;
import br.com.treinaweb.cleanarch.infra.gateways.client.ClientInMemoryGateway;
import br.com.treinaweb.cleanarch.infra.presenters.client.CreateClientInputBoundary;
import br.com.treinaweb.cleanarch.infra.presenters.client.CreateClientOutputBoundary;
import br.com.treinaweb.cleanarch.infra.presenters.client.FindAllClientsOutputBoundary;

public class ClientFactory {

    private static ClientGateway clientGatewayInstance;

    public static FindAllClientsController getFindAllClientsController() {
        return new FindAllClientsController(
            getFindAllClientsUseCase(),
            getFindAllClientsOutputBoundary()
        );
    }

    public static CreateClientController getCreateClientController() {
        return new CreateClientController(
            getCreateClientUseCase(),
            getCreateClientInputBoundary(),
            getCreateClientOutputBoundary()
        );
    }

    private static ClientGateway getClientGateway() {
        if (clientGatewayInstance == null) {
            clientGatewayInstance = new ClientInMemoryGateway();
        }
        return clientGatewayInstance;
    }

    private static FindAllClientsUseCase getFindAllClientsUseCase() {
        return new FindAllClientsUseCase(getClientGateway());
    }

    private static CreateClientUseCase getCreateClientUseCase() {
        return new CreateClientUseCase(getClientGateway());
    }

    private static FindAllClientsOutputBoundary getFindAllClientsOutputBoundary() {
        return new FindAllClientsOutputBoundary(ServicesFactory.getSerializerService());
    }

    private static CreateClientInputBoundary getCreateClientInputBoundary() {
        return new CreateClientInputBoundary(ServicesFactory.getSerializerService());
    }

    private static CreateClientOutputBoundary getCreateClientOutputBoundary() {
        return new CreateClientOutputBoundary(ServicesFactory.getSerializerService());
    }
}
