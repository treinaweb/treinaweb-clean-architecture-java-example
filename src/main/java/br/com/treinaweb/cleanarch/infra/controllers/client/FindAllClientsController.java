package br.com.treinaweb.cleanarch.infra.controllers.client;

import br.com.treinaweb.cleanarch.application.usecases.client.FindAllClientsUseCase;
import br.com.treinaweb.cleanarch.infra.controllers.Controller;
import br.com.treinaweb.cleanarch.infra.presenters.client.FindAllClientsOutputBoundary;
import br.com.treinaweb.cleanarch.infra.web.Request;
import br.com.treinaweb.cleanarch.infra.web.Response;
import br.com.treinaweb.cleanarch.infra.web.StatusCodes;

public class FindAllClientsController implements Controller {

    private final FindAllClientsUseCase useCase;
    private final FindAllClientsOutputBoundary outputBoundary;

    public FindAllClientsController(
        FindAllClientsUseCase useCase,
        FindAllClientsOutputBoundary outputBoundary
    ) {
        this.useCase = useCase;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public Response handle(Request request) {
        var clients = useCase.execute();
        return new Response(
            StatusCodes.OK,
            outputBoundary.toJson(clients)
        );
    }
}
