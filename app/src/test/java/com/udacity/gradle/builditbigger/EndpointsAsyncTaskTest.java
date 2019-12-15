package com.udacity.gradle.builditbigger;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class EndpointsAsyncTaskTest {

    String randomJoke;
    @Test
    public void testAndRetrieveJoke() throws ExecutionException, InterruptedException {


        JokeRetrieveListener jokeRetrieveListener = new JokeRetrieveListener() {
            @Override
            public void onJokesRetrieved(String jokes) {
                randomJoke = jokes.split(",")[0];
            }
        };
        new EndpointsAsyncTask(jokeRetrieveListener).execute().get();
        assertNotNull(randomJoke);
    }

}