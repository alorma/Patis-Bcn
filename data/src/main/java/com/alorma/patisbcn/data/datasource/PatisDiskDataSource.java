package com.alorma.patisbcn.data.datasource;

import android.content.Context;

import com.alorma.patisbcn.domain.data.datasource.DatasourceCallback;
import com.alorma.patisbcn.domain.data.datasource.PatisDataSource;
import com.alorma.patisbcn.domain.model.Acte;

import java.util.List;

/**
 * Created by Bernat on 08/10/2015.
 */
public class PatisDiskDataSource implements PatisDataSource {
    private Context context;

    public PatisDiskDataSource(Context context) {

        this.context = context;
    }

    @Override
    public void loadPatis(DatasourceCallback<List<Acte>> callback) {

    }
}
