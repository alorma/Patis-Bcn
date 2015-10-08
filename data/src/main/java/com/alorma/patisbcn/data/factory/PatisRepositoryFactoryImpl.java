package com.alorma.patisbcn.data.factory;

import android.content.Context;

import com.alorma.patisbcn.data.repository.patis.PatisRepositoryImpl;
import com.alorma.patisbcn.domain.data.factory.PatisRepositoryFactory;
import com.alorma.patisbcn.domain.data.repository.PatisRepository;

/**
 * Created by Bernat on 08/10/2015.
 */
public class PatisRepositoryFactoryImpl implements PatisRepositoryFactory {
    private Context context;

    public PatisRepositoryFactoryImpl(Context context) {
        this.context = context;
    }

    @Override
    public PatisRepository getRepository() {
        return new PatisRepositoryImpl(context);
    }
}
