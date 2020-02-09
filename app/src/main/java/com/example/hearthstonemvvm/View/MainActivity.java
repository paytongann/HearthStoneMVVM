package com.example.hearthstonemvvm.View;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hearthstonemvvm.Model.ResultsPojo;
import com.example.hearthstonemvvm.R;
import com.example.hearthstonemvvm.ViewModel.CustomAdapter;
import com.example.hearthstonemvvm.ViewModel.CustomViewModel;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar_cyclic);
        final RecyclerView recyclerView =findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        CustomViewModel model = ViewModelProviders.of(this).get(CustomViewModel.class);
        model.getCards().observe(this, new Observer<ResultsPojo>() {
            @Override
            public void onChanged(ResultsPojo cardPojos) {
                adapter = new CustomAdapter(MainActivity.this, cardPojos);
                recyclerView.setAdapter(adapter);
                endProgressBar();
            }
        });
    }

    public void endProgressBar(){
        ((ViewGroup)progressBar.getParent()).removeView(progressBar);
    }

}
