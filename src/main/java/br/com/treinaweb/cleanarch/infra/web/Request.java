package br.com.treinaweb.cleanarch.infra.web;

public class Request {
    private String body;

    public Request() {}

    public Request(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
}
