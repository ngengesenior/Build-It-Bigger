package com.ngenge.apps.jokes_display_library;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class JokesDisplayActivity extends AppCompatActivity{

    private TextView displayTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_display);
        displayTextView = findViewById(R.id.textViewJokes);

        Intent intent = getIntent();

        if (intent.hasExtra("JOKES")) {

            String jokes = intent.getStringExtra("JOKES");
            String[] jokesArray = Objects.requireNonNull(jokes).split(",");
            StringBuilder builder = new StringBuilder();

            for (String joke:jokesArray) {
                builder.append(joke)
                        .append("\n");
            }

            displayTextView.setText(builder);
        }


    }


}
