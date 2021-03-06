package com.efimchick.ifmo.collections.countwords;

import java.util.Comparator;

public class WordEntryComparator implements Comparator<WordEntry> {
    @Override
    public int compare(WordEntry o1, WordEntry o2) {
        return o2.getCounter() - o1.getCounter();
    }
}