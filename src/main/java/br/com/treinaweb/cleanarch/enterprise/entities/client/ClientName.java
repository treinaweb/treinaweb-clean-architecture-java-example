package br.com.treinaweb.cleanarch.enterprise.entities.client;

public class ClientName {

    private String value;

    public ClientName(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Client name cannot be null or empty");
        }
        if (value.length() < 3) {
            throw new IllegalArgumentException("Client name must have at least 3 characters");
        }
        if (!value.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("Client name must have only letters");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        ClientName other = (ClientName) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
