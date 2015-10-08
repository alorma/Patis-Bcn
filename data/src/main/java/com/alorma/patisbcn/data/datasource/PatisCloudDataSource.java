package com.alorma.patisbcn.data.datasource;

import android.content.Context;

import com.alorma.patisbcn.data.repository.patis.ActeParser;
import com.alorma.patisbcn.domain.data.datasource.DatasourceCallback;
import com.alorma.patisbcn.domain.data.datasource.PatisDataSource;
import com.alorma.patisbcn.domain.model.Acte;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bernat on 08/10/2015.
 */
public class PatisCloudDataSource implements PatisDataSource {
    private Context context;

    public PatisCloudDataSource(Context context) {

        this.context = context;
    }

    @Override
    public void loadPatis(DatasourceCallback<List<Acte>> callback) {
        String url = "http://w10.bcn.es/APPS/asiasiacache/peticioXmlAsia?id=207";
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            InputStream is = response.body().byteStream();

            ActeParser parser = new ActeParser();

            callback.onLoad(parser.parse(is));
        } catch (Exception e) {
            e.printStackTrace();
            callback.onLoad(new ArrayList<Acte>());
        }
    }
}
