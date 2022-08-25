package br.com.treinaweb.cleanarch.infra.presenters;

public interface OutputBoundary<T> {
    String toJson(T data);
}
