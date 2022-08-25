package br.com.treinaweb.cleanarch.enterprise.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    void shouldThrowExceptionWhenEmailIsNull() {
        var exception = assertThrows(
            IllegalArgumentException.class, () -> new Email(null)
        );
        assertEquals("Email cannot be null or empty", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenEmailIsEmpty() {
        var exception = assertThrows(
            IllegalArgumentException.class, () -> new Email("")
        );
        assertEquals("Email cannot be null or empty", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenEmailDoNotHaveAtSign() {
        var exception = assertThrows(
            IllegalArgumentException.class, () -> new Email("email.com")
        );
        assertEquals("Email is not valid", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenEmailDoNotHaveDot() {
        var exception = assertThrows(
            IllegalArgumentException.class, () -> new Email("email@com")
        );
        assertEquals("Email is not valid", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenEmailHasDotAfterAtSign() {
        var exception = assertThrows(
            IllegalArgumentException.class, () -> new Email("email@.com")
        );
        assertEquals("Email is not valid", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenEmailHasAtSignAfterDot() {
        var exception = assertThrows(
            IllegalArgumentException.class, () -> new Email("email.com@")
        );
        assertEquals("Email is not valid", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenEmailHasMoreThanOneAtSign() {
        var exception = assertThrows(
            IllegalArgumentException.class, () -> new Email("email@com@com")
        );
        assertEquals("Email is not valid", exception.getMessage());
    }

    @Test
    void shouldReturnTrueWhenEmailIsTheSame() {
        var email = new Email("test@mail.com");
        var otherEmail = new Email("test@mail.com");
        assertTrue(email.equals(otherEmail));
    }
}
