package com.example.choresplit;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewAllChoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_chores);

        ChoreManager choreManager = new ChoreManager();
        List<Chore> allChores = choreManager.getAllChores();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ChoreAdapter choreAdapter = new ChoreAdapter(allChores);
        recyclerView.setAdapter(choreAdapter);
    }
}
