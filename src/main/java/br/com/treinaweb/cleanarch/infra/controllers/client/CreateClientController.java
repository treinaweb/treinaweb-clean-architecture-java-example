package br.com.treinaweb.cleanarch.infra.controllers.client;

import br.com.treinaweb.cleanarch.application.usecases.client.CreateClientUseCase;
import br.com.treinaweb.cleanarch.infra.controllers.Controller;
import br.com.treinaweb.cleanarch.infra.presenters.client.CreateClientInputBoundary;
import br.com.treinaweb.cleanarch.infra.presenters.client.CreateClientOutputBoundary;
import br.com.treinaweb.cleanarch.infra.web.Request;
import br.com.treinaweb.cleanarch.infra.web.Response;
import br.com.treinaweb.cleanarch.infra.web.StatusCodes;

public class CreateClientController implements Controller {

    private final CreateClientUseCase useCase;
    private final CreateClientInputBoundary inputBoundary;
    private final CreateClientOutputBoundary outputBoundary;

    public CreateClientController(
        CreateClientUseCase useCase,
        CreateClientInputBoundary inputBoundary,
        CreateClientOutputBoundary outputBoundary
    ) {
        this.useCase = useCase;
        this.inputBoundary = inputBoundary;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public Response handle(Request request) {
        var input = inputBoundary.fromJson(request.getBody());
        var client = useCase.execute(input);
        var body = outputBoundary.toJson(client);
        return new Response(StatusCodes.CREATED, body);
    }

}
