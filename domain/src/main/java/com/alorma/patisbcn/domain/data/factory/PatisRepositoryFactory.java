package com.alorma.patisbcn.domain.data.factory;

import com.alorma.patisbcn.domain.data.repository.PatisRepository;

/**
 * Created by Bernat on 07/10/2015.
 */
public interface PatisRepositoryFactory {
    public PatisRepository getPatisRepository();
}
