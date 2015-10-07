package com.alorma.patisbcn.domain.data.repository;

import com.alorma.patisbcn.domain.model.Acte;

import java.util.List;

/**
 * Created by Bernat on 07/10/2015.
 */
public interface PatisRepository {
    public void loadPatis(RepositoryCallback<List<Acte>> result);
}
