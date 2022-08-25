package br.com.treinaweb.cleanarch.enterprise.entities.client;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ClientNameTest {

    @Test
    void shouldThrowExceptionWhenClientNameIsNull() {
        var exception = assertThrows(
            IllegalArgumentException.class, () -> new ClientName(null)
        );
        assertEquals("Client name cannot be null or empty", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenClientNameIsEmpty() {
        var exception = assertThrows(
            IllegalArgumentException.class, () -> new ClientName("")
        );
        assertEquals("Client name cannot be null or empty", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenClientNameHasLessThan3Characters() {
        var exception = assertThrows(
            IllegalArgumentException.class, () -> new ClientName("Jo")
        );
        assertEquals("Client name must have at least 3 characters", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenClientNameHasNumbers() {
        var exception = assertThrows(
            IllegalArgumentException.class, () -> new ClientName("João123")
        );
        assertEquals("Client name must have only letters", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenClientNameHasSpecialCharacters() {
        var exception = assertThrows(
            IllegalArgumentException.class, () -> new ClientName("João@")
        );
        assertEquals("Client name must have only letters", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenClientNameHasSpaces() {
        var exception = assertThrows(
            IllegalArgumentException.class, () -> new ClientName("João ")
        );
        assertEquals("Client name must have only letters", exception.getMessage());
    }

}
