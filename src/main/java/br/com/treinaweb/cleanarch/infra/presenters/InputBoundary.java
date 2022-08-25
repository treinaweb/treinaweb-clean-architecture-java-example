package br.com.treinaweb.cleanarch.infra.presenters;

public interface InputBoundary<T> {
    T fromJson(String json);
}
