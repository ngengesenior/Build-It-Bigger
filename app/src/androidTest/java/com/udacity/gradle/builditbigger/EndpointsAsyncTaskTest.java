package com.udacity.gradle.builditbigger;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    String randomJoke;
    Context context;
    @Test
    public void testAndRetrieveJoke() throws ExecutionException, InterruptedException {

        final CountDownLatch countDownLatch = new CountDownLatch(1);


        context = InstrumentationRegistry.getInstrumentation().getContext();
        JokeRetrieveListener jokeRetrieveListener = new JokeRetrieveListener() {
            @Override
            public void onJokesRetrieved(String jokes) {
                randomJoke = jokes.split(",")[0];
            }
        };


        final EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(jokeRetrieveListener) {

            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                if (result != null) {
                    assertTrue(result.length() > 0);
                    countDownLatch.countDown();
                }
                super.onPostExecute(result);

            }
        };

        asyncTask.execute(context);

        countDownLatch.await();

    }

}