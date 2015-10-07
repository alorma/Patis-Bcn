package com.alorma.patisbcn.domain.data.repository;

public interface RepositoryCallback<T> {
    public void onCallback(T result);
}