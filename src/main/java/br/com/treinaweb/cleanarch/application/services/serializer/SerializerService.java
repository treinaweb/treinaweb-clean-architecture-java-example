package br.com.treinaweb.cleanarch.application.services.serializer;

public interface SerializerService {
    String serialize(Object data);
    <T> T deserialize(String json, Class<T> type);
}
