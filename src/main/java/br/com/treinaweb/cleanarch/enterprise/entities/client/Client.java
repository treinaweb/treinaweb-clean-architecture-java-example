package br.com.treinaweb.cleanarch.enterprise.entities.client;

import br.com.treinaweb.cleanarch.enterprise.entities.Cpf;
import br.com.treinaweb.cleanarch.enterprise.entities.Email;

public class Client {

    private ClientName firstName;
    private ClientName lastName;
    private Email email;
    private Cpf cpf;

    public Client(String firstName, String lastName, String email, String cpf) {
        this.firstName = new ClientName(firstName);
        this.lastName = new ClientName(lastName);
        this.email = new Email(email);
        this.cpf = new Cpf(cpf);
    }

    public String getFirstName() {
        return firstName.getValue();
    }

    public String getLastName() {
        return lastName.getValue();
    }

    public String getEmail() {
        return email.getValue();
    }

    public String getCpf() {
        return cpf.getValue();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }
}
