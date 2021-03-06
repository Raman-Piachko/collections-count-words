package com.efimchick.ifmo.collections.countwords;

public class WordEntry {
    private final String word;
    private final int counter;

    public WordEntry(String word, int counter) {
        this.word = word;
        this.counter = counter;
    }

    public String getWord() {
        return word;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return word + " - " + counter;
    }
}
