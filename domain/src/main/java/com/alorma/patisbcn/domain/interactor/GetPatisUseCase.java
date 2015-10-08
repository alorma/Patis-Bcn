package com.alorma.patisbcn.domain.interactor;

import com.alorma.patisbcn.domain.data.factory.PatisRepositoryFactory;
import com.alorma.patisbcn.domain.data.repository.PatisRepository;
import com.alorma.patisbcn.domain.data.repository.RepositoryCallback;
import com.alorma.patisbcn.domain.model.Acte;

import java.util.List;

/**
 * Created by Bernat on 07/10/2015.
 */
public class GetPatisUseCase implements Runnable {

    private final PatisRepository repository;
    private InteractorCallback<List<Acte>> callback;

    public GetPatisUseCase(PatisRepositoryFactory patisRepositoryFactory) {
        this.repository = patisRepositoryFactory.getRepository();
    }

    public void getPatis(final InteractorCallback<List<Acte>> callback) {
        this.callback = callback;
        new Thread(this).start();
    }

    @Override
    public void run() {
        repository.loadPatis(new RepositoryCallback<List<Acte>>() {
            @Override
            public void onCallback(List<Acte> result) {
                callback.onCallback(result);
            }
        });
    }
}
