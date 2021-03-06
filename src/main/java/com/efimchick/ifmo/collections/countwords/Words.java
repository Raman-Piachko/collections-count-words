package com.efimchick.ifmo.collections.countwords;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.efimchick.ifmo.collections.countwords.WordsConstants.MIN_COUNTER;
import static com.efimchick.ifmo.collections.countwords.WordsConstants.MIN_LENGTH;
import static com.efimchick.ifmo.collections.countwords.WordsConstants.NOT_ALPHABETIC_CHAR;
import static com.efimchick.ifmo.collections.countwords.WordsConstants.SPACE;
import static com.efimchick.ifmo.collections.countwords.WordsConstants.SPACES;

public class Words {


    public String countWords(List<String> lines) {
        StringBuilder stringBuilder = new StringBuilder();

        List<String> words = getWordsFromText(lines);
        List<WordEntry> result = countEachWord(words);
        result.sort(new WordEntryComparator());

        for (WordEntry wordEntry : result) {
            if (isRightWordEntry(wordEntry)) {
                stringBuilder.append(wordEntry.toString()).append("\n");
            }
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }


    private List<String> getWordsFromText(List<String> lines) {
        List<String> words = new ArrayList<>();

        for (String line : lines) {
            line = line.replaceAll(NOT_ALPHABETIC_CHAR, SPACE);
            Collections.addAll(words, line.toLowerCase().split(SPACES));
        }

        return words;
    }


    private List<WordEntry> countEachWord(List<String> words) {
        List<WordEntry> countedWords = new ArrayList<>();
        Collections.sort(words);

        String currentWord = words.get(0);

        int counter = 0;

        for (String word : words) {
            if (word.compareTo(currentWord) == 0) {
                counter++;
            } else {
                countedWords.add(new WordEntry(currentWord, counter));
                currentWord = word;
                counter = 1;
            }
        }

        countedWords.add(new WordEntry(currentWord, counter));

        return countedWords;
    }

    private boolean isRightWordEntry(WordEntry wordEntry) {
        return wordEntry.getWord().length() >= MIN_LENGTH && wordEntry.getCounter() >= MIN_COUNTER;
    }
}