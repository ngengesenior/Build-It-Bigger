package com.udacity.gradle.jokes;

import java.util.ArrayList;
import java.util.List;

public class Joker {
    public static String getJoke() {
        return "This is totally a funny joke";
    }
    private static List<String> jokes = new ArrayList<>();

    private static void buildJokes()
    {
        jokes.add("Android is really funny when it spells out as iOS");
        jokes.add("A Java library was found in Romania selling ice cream");
        jokes.add("A random Python environment can be found in Cameroon");
    }

    public static List<String> getJokes() {
        buildJokes();
        return jokes;
    }
}
