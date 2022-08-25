package br.com.treinaweb.cleanarch.infra.services.serializer;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import br.com.treinaweb.cleanarch.application.services.serializer.SerializerException;
import br.com.treinaweb.cleanarch.application.services.serializer.SerializerService;

public class GsonSerializerService implements SerializerService {

    private final Gson gson;

    public GsonSerializerService() {
        gson = new Gson();
    }

    @Override
    public String serialize(Object data) {
        return gson.toJson(data);
    }

    @Override
    public <T> T deserialize(String json, Class<T> type) {
        try {
            return gson.fromJson(json, type);
        } catch (JsonSyntaxException e) {
            throw new SerializerException("Erro ao desserializar JSON", e);
        }
    }

}
