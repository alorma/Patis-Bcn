package com.alorma.patisbcn.data.repository.patis;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

import com.alorma.patisbcn.data.JobExecutor;
import com.alorma.patisbcn.data.PostExecutionThread;
import com.alorma.patisbcn.data.ThreadExecutor;
import com.alorma.patisbcn.data.UIThread;
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

    private final JobExecutor threadExecutor;
    private final UIThread postExecutionThread;
    private Context context;
    private RepositoryCallback<List<Acte>> callback;

    public PatisRepositoryImpl(Context context) {
        this.context = context;
        threadExecutor = JobExecutor.getInstance();
        postExecutionThread = UIThread.getInstance();
    }

    @Override
    public void loadPatis(final RepositoryCallback<List<Acte>> callback) {
        this.callback = callback;
        threadExecutor.execute(this);
    }

    @Override
    public void run() {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {
            new PatisCloudDataSource(context).loadPatis(new DatasourceCallback<List<Acte>>() {
                @Override
                public void onLoad(final List<Acte> result) {
                    postExecutionThread.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onCallback(result);
                        }
                    });
                }
            });
        } else {
            postExecutionThread.post(new Runnable() {
                @Override
                public void run() {
                    callback.onCallback(new ArrayList<Acte>());
                }
            });
        }
    }
}
