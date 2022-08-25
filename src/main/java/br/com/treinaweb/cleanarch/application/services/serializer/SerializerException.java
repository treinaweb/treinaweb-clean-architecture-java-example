package br.com.treinaweb.cleanarch.application.services.serializer;

public class SerializerException extends RuntimeException {

    public SerializerException(String message) {
        super(message);
    }

    public SerializerException(String message, Throwable cause) {
        super(message, cause);
    }

}
