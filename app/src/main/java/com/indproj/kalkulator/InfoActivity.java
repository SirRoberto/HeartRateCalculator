package com.indproj.kalkulator;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        InfoContainer infoContainer = new InfoContainer();
        RecyclerView recyclerView = findViewById(R.id.info_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        InfoAdapter adapter = new InfoAdapter(infoContainer);
        recyclerView.setAdapter(adapter);
    }
}
