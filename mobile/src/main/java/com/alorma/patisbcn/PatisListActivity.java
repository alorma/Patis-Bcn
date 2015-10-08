package com.alorma.patisbcn;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.alorma.patisbcn.data.factory.PatisRepositoryFactoryImpl;
import com.alorma.patisbcn.domain.data.factory.PatisRepositoryFactory;
import com.alorma.patisbcn.domain.interactor.GetPatisUseCase;
import com.alorma.patisbcn.domain.interactor.InteractorCallback;
import com.alorma.patisbcn.domain.model.Acte;

import java.util.List;

public class PatisListActivity extends AppCompatActivity implements InteractorCallback<List<Acte>> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patis_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PatisRepositoryFactory factory = new PatisRepositoryFactoryImpl(this);
        GetPatisUseCase patisUseCase = new GetPatisUseCase(factory);
        patisUseCase.getPatis(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(PatisListActivity.this, "Actes: " + value.size(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
