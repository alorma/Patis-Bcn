package com.alorma.patisbcn.domain.data.factory;

import com.alorma.patisbcn.domain.data.datasource.PatisDataSource;

/**
 * Created by Bernat on 07/10/2015.
 */
public interface PatisRepositoryFactory {
    public PatisDataSource getAssetsPatisDataSource();

    public PatisDataSource getDiskPatisDataSource();

    public PatisDataSource getCloudPatisDataSource();
}
