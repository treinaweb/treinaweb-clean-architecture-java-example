package br.com.treinaweb.cleanarch.infra.controllers;

import br.com.treinaweb.cleanarch.infra.web.Request;
import br.com.treinaweb.cleanarch.infra.web.Response;

public interface Controller {
    Response handle(Request request);
}
