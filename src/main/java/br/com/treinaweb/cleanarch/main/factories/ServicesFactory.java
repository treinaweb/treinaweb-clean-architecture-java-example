package br.com.treinaweb.cleanarch.main.factories;

import br.com.treinaweb.cleanarch.application.services.serializer.SerializerService;
import br.com.treinaweb.cleanarch.infra.services.serializer.GsonSerializerService;

public class ServicesFactory {

    private static SerializerService serializerServiceInstance;

    public static SerializerService getSerializerService() {
        if (serializerServiceInstance == null) {
            serializerServiceInstance = new GsonSerializerService();
        }
        return serializerServiceInstance;
    }

}
