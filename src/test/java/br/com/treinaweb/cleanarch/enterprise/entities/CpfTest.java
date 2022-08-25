package br.com.treinaweb.cleanarch.enterprise.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CpfTest {

    @Test
    void shouldThrowExceptionWhenCpfIsNull() {
        var exception = assertThrows(
            IllegalArgumentException.class, () -> new Cpf(null)
        );
        assertEquals("CPF cannot be null or empty", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCpfIsEmpty() {
        var exception = assertThrows(
            IllegalArgumentException.class, () -> new Cpf("")
        );
        assertEquals("CPF cannot be null or empty", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCpfHasLessThan11Digits() {
        var exception = assertThrows(
            IllegalArgumentException.class, () -> new Cpf("1234567890")
        );
        assertEquals("CPF must have 11 digits", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCpfHasMoreThan11Digits() {
        var exception = assertThrows(
            IllegalArgumentException.class, () -> new Cpf("123456789012")
        );
        assertEquals("CPF must have 11 digits", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCpfHasNonDigitCharacters() {
        var exception = assertThrows(
            IllegalArgumentException.class, () -> new Cpf("1234567890a")
        );
        assertEquals("CPF must have only digits", exception.getMessage());
    }

    @Test
    void shouldReturnTrueWhenCpfIsTheSame() {
        var cpf = new Cpf("12345678901");
        var otherCpf = new Cpf("12345678901");
        assertTrue(cpf.equals(otherCpf));
    }

    @Test
    void shouldCreateCpfWhenCpfIsValid() {
        var cpf = new Cpf("12345678901");
        assertEquals("12345678901", cpf.getValue());
    }

}
