package com.ml.nlp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class StopWord {

    private String[] defaultStopWords = {"i", "a", "about", "an", "are", "as", "at",
            "be", "by", "com", "for", "from", "how", "in", "is", "it", "of", "on",
            "or", "that", "the", "this", "to", "was", "what", "when", "where",
            "who", "will", "with"};

    private static HashSet stopWords  = new HashSet();

    public StopWord() {
        stopWords.addAll(Arrays.asList(defaultStopWords));
    }

    public StopWord(String fileName) {
        try {
            BufferedReader bufferedreader =
                    new BufferedReader(new FileReader(fileName));
            while (bufferedreader.ready()) {
                stopWords.add(bufferedreader.readLine());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void addStopWord(String word) {
        stopWords.add(word);
    }

    public List<String> removeStopWords(String[] words) {
        List<String> tokens = Arrays.stream(words).collect(Collectors.toList());
        return tokens.stream().filter(token -> !stopWords.contains(token)).collect(Collectors.toList());
    }

    public void displayStopWords() {
        Iterator<String> iterator = stopWords.iterator();
        while(iterator.hasNext()) {
            System.out.print("[" + iterator.next() + "]  ");
        }
    }
}
