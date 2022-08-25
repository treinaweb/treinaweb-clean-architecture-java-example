package br.com.treinaweb.cleanarch.main.adapters;

import br.com.treinaweb.cleanarch.infra.controllers.Controller;
import br.com.treinaweb.cleanarch.infra.web.Request;
import spark.Route;

public class SparkAdapter {
    public static Route adapt(Controller controller) {
        return (req, res) -> {
            var response = controller.handle(new Request(req.body()));
            res.status(response.getStatusCode());
            return response.getBody();
        };
    }
}
