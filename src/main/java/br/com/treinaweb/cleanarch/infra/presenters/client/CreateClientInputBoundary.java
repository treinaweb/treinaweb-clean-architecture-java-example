package br.com.treinaweb.cleanarch.infra.presenters.client;

import br.com.treinaweb.cleanarch.application.services.serializer.SerializerService;
import br.com.treinaweb.cleanarch.enterprise.entities.client.Client;
import br.com.treinaweb.cleanarch.infra.presenters.InputBoundary;

public class CreateClientInputBoundary implements InputBoundary<Client> {

    private final SerializerService serializerService;

    public CreateClientInputBoundary(SerializerService serializerService) {
        this.serializerService = serializerService;
    }

    @Override
    public Client fromJson(String json) {
        var dto = serializerService.deserialize(json, CreateClientInputDto.class);
        return new Client(dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getCpf());
    }

}

class CreateClientInputDto {
    private String firstName;
    private String lastName;
    private String email;
    private String cpf;

    public CreateClientInputDto() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
