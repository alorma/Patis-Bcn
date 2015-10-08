package com.alorma.patisbcn.data.repository.patis;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

import com.alorma.patisbcn.data.datasource.PatisCloudDataSource;
import com.alorma.patisbcn.domain.data.datasource.DatasourceCallback;
import com.alorma.patisbcn.domain.data.repository.PatisRepository;
import com.alorma.patisbcn.domain.data.repository.RepositoryCallback;
import com.alorma.patisbcn.domain.model.Acte;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bernat on 08/10/2015.
 */
public class PatisRepositoryImpl implements PatisRepository {

    private Context context;

    public PatisRepositoryImpl(Context context) {
        this.context = context;
    }

    @Override
    public void loadPatis(final RepositoryCallback<List<Acte>> callback) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {
            new PatisCloudDataSource(context).loadPatis(new DatasourceCallback<List<Acte>>() {
                @Override
                public void onLoad(List<Acte> result) {
                    callback.onCallback(result);
                }
            });
        } else {
            callback.onCallback(new ArrayList<Acte>());
        }
    }
}
