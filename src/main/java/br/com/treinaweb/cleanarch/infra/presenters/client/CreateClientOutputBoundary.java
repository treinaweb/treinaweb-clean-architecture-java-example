package br.com.treinaweb.cleanarch.infra.presenters.client;

import br.com.treinaweb.cleanarch.application.services.serializer.SerializerService;
import br.com.treinaweb.cleanarch.enterprise.entities.client.Client;
import br.com.treinaweb.cleanarch.infra.presenters.OutputBoundary;

public class CreateClientOutputBoundary implements OutputBoundary<Client> {

    private final SerializerService serializerService;

    public CreateClientOutputBoundary(SerializerService serializerService) {
        this.serializerService = serializerService;
    }

    @Override
    public String toJson(Client data) {
        var dto = CreateClientOutputDto.of(data);
        return serializerService.serialize(dto);
    }

}

class CreateClientOutputDto {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String cpf;

    public static CreateClientOutputDto of(Client client) {
        return new CreateClientOutputDto(
            client.getFirstName(),
            client.getLastName(),
            client.getEmail(),
            client.getCpf()
        );
    }

    public CreateClientOutputDto(String firstName, String lastName, String email, String cpf) {
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
