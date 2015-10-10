package com.alorma.patisbcn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.alorma.patisbcn.data.factory.PatisRepositoryFactoryImpl;
import com.alorma.patisbcn.domain.data.factory.PatisRepositoryFactory;
import com.alorma.patisbcn.domain.interactor.GetPatisUseCase;
import com.alorma.patisbcn.domain.interactor.InteractorCallback;
import com.alorma.patisbcn.domain.model.Acte;

import java.util.List;

public class PatisListActivity extends AppCompatActivity implements InteractorCallback<List<Acte>> {

    private PatisAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patis_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PatisAdapter(this);
        recyclerView.setAdapter(adapter);

        PatisRepositoryFactory factory = new PatisRepositoryFactoryImpl(this);
        GetPatisUseCase patisUseCase = new GetPatisUseCase(factory);
        patisUseCase.getPatis(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCallback(final List<Acte> value) {
        adapter.addAll(value);
    }
}
