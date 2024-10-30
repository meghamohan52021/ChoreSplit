package com.example.choresplit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // Button for viewing all chores
        Button btnViewAllChores = findViewById(R.id.btnViewAllChores);
        btnViewAllChores.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ViewAllChoresActivity.class);
            startActivity(intent);
        });

        // Buttons for each person
        setupPersonButton(R.id.btnPerson1, "MEGHA");
        setupPersonButton(R.id.btnPerson2, "MONALI");
        setupPersonButton(R.id.btnPerson3, "MUSHKAN");
        setupPersonButton(R.id.btnPerson4, "NITHYA");
    }

    private void setupPersonButton(int buttonId, String personName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PersonChoresActivity.class);
            intent.putExtra("personName", personName);
            startActivity(intent);
        });
    }
}
