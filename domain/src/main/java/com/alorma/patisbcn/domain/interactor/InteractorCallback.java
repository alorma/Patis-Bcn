package com.alorma.patisbcn.domain.interactor;

public interface InteractorCallback<T> {
    public void onCallback(T value);
}