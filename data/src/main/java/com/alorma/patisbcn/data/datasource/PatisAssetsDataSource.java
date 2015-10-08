package com.alorma.patisbcn.data.datasource;

import android.content.Context;

import com.alorma.patisbcn.data.repository.patis.ActeParser;
import com.alorma.patisbcn.domain.data.datasource.DatasourceCallback;
import com.alorma.patisbcn.domain.data.datasource.PatisDataSource;
import com.alorma.patisbcn.domain.model.Acte;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bernat on 08/10/2015.
 */
public class PatisAssetsDataSource implements PatisDataSource {

    private Context context;

    public PatisAssetsDataSource(Context context) {
        this.context = context;
    }

    @Override
    public void loadPatis(DatasourceCallback<List<Acte>> callback) {
        ActeParser parser = new ActeParser();
        try {
            InputStream is = context.getAssets().open("dades.xml");

            callback.onLoad(parser.parse(is));
        } catch (Exception e) {
            e.printStackTrace();
            callback.onLoad(new ArrayList<Acte>());
        }
    }
}
