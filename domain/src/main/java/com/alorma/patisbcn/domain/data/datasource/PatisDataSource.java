package com.alorma.patisbcn.domain.data.datasource;

import com.alorma.patisbcn.domain.model.Acte;

import java.util.List;

/**
 * Created by Bernat on 08/10/2015.
 */
public interface PatisDataSource {
    void loadPatis(DatasourceCallback<List<Acte>> callback);
}
