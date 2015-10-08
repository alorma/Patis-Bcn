package com.alorma.patisbcn.domain.data.datasource;

/**
 * Created by Bernat on 08/10/2015.
 */
public interface DatasourceCallback<T>{
    void onLoad(T result);
}
