package com.alorma.patisbcn.domain.interactor;

import com.alorma.patisbcn.domain.data.factory.PatisRepositoryFactory;
import com.alorma.patisbcn.domain.data.repository.PatisRepository;
import com.alorma.patisbcn.domain.data.repository.RepositoryCallback;
import com.alorma.patisbcn.domain.model.Acte;

import java.util.List;

/**
 * Created by Bernat on 07/10/2015.
 */
public class GetPatisUseCase {

    private final PatisRepository repository;

    public GetPatisUseCase(PatisRepositoryFactory factory) {
        this.repository = factory.getPatisRepository();
    }

    public void getPatis(final InteractorCallback<List<Acte>> callback) {
        repository.loadPatis(new RepositoryCallback<List<Acte>>() {
            @Override
            public void onCallback(List<Acte> result) {
                callback.onCallback(result);
            }
        });
    }
}
