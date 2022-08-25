package br.com.treinaweb.cleanarch.infra.presenters.client;

import java.util.List;

import br.com.treinaweb.cleanarch.application.services.serializer.SerializerService;
import br.com.treinaweb.cleanarch.enterprise.entities.client.Client;
import br.com.treinaweb.cleanarch.infra.presenters.OutputBoundary;

public class FindAllClientsOutputBoundary implements OutputBoundary<List<Client>> {
    private final SerializerService serializerService;

    public FindAllClientsOutputBoundary(SerializerService serializerService) {
        this.serializerService = serializerService;
    }

    @Override
    public String toJson(List<Client> data) {
        var dto = data.stream()
            .map(FindAllClientsOutputDto::of)
            .toList();
        return serializerService.serialize(dto);
    }
}


class FindAllClientsOutputDto {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String cpf;

    public static FindAllClientsOutputDto of(Client client) {
        return new FindAllClientsOutputDto(
            client.getFirstName(),
            client.getLastName(),
            client.getEmail(),
            client.getCpf()
        );
    }

    public FindAllClientsOutputDto(String firstName, String lastName, String email, String cpf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cpf = cpf;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }
}