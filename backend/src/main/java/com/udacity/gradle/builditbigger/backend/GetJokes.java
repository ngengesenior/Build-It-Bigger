package com.udacity.gradle.builditbigger.backend;

import java.util.List;


public class GetJokes {

    private List<String> jokes;
    private String joke;

    public void setJokes(List<String> jokes) {
        this.jokes = jokes;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}
