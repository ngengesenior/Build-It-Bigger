package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ngenge.apps.jokes_display_library.JokesDisplayActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Intent intent = new Intent(this, JokesDisplayActivity.class);
        startActivity(intent);*/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*public void tellJoke(View view) {
        //Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();

        Toast.makeText(this,Joker.getJokes().get(0),Toast.LENGTH_LONG).show();
    }*/


    public void tellAJoke(View view) {
        new EndpointsAsyncTask(new JokeRetrieveListener() {
            @Override
            public void onJokesRetrieved(String jokes) {
                Intent intent = new Intent(MainActivity.this, JokesDisplayActivity.class);
                intent.putExtra("JOKES",jokes);
                startActivity(intent);
            }
        }).execute();
    }
}
