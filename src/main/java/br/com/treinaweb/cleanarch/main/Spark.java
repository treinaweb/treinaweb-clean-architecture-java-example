package br.com.treinaweb.cleanarch.main;

import static spark.Spark.*;

import br.com.treinaweb.cleanarch.main.adapters.SparkAdapter;
import br.com.treinaweb.cleanarch.main.factories.ClientFactory;

public class Spark {
    public static void main(String[] args) {
        port(3000);
        get(
            "/api/clients",
            SparkAdapter.adapt(ClientFactory.getFindAllClientsController())
        );
        post(
            "/api/clients",
            SparkAdapter.adapt(ClientFactory.getCreateClientController())
        );
    }
}
