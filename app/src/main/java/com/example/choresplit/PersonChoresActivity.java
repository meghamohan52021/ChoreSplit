package com.example.choresplit;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PersonChoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_chores);

        String personName = getIntent().getStringExtra("personName");
        TextView tvPersonName = findViewById(R.id.tvPersonName);
        tvPersonName.setText("Today's Chores For " + personName.toUpperCase());

        // Get today's date
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.getDefault());
        String today = sdf.format(new Date());

        // Set the date TextView
        TextView tvDate = findViewById(R.id.tvDate);
        tvDate.setText("Date: " + new SimpleDateFormat("dd MMMM yyyy (EEEE)", Locale.getDefault()).format(new Date()));

        // Get the chores for today
        ChoreManager choreManager = new ChoreManager();
        List<Chore> choresForToday = choreManager.getChoresForDay(today, personName);

        // Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ChoreAdapter choreAdapter = new ChoreAdapter(choresForToday);
        recyclerView.setAdapter(choreAdapter);
    }
}

