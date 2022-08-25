package br.com.treinaweb.cleanarch.enterprise.entities;

public class Cpf {

    private String value;

    public Cpf(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("CPF cannot be null or empty");
        }
        if (value.length() != 11) {
            throw new IllegalArgumentException("CPF must have 11 digits");
        }
        if (!value.matches("[0-9]+")) {
            throw new IllegalArgumentException("CPF must have only digits");
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
        Cpf other = (Cpf) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
