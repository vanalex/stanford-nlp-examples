package com.ml.nlp;

import com.aliasi.tokenizer.EnglishStopTokenizerFactory;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.Tokenizer;
import com.aliasi.tokenizer.TokenizerFactory;
import opennlp.tools.tokenize.SimpleTokenizer;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.text.BreakIterator;
import java.util.*;
import java.util.stream.Collectors;

public class TokenizerSamples {

    private static final String DELIMITER = "[ ,.]";

    public static List<String> getTokensByScanner(String sample) {
        Scanner scanner = new Scanner(sample);
        List<String> tokens = new ArrayList<>();
        // Specifying the delimiters
        scanner.useDelimiter(DELIMITER);

        while (scanner.hasNext()) {
            String token = scanner.next();
            tokens.add(token);
        }

        return tokens;
    }

    public static List<String> getTokensBySplitMethod(String sample) {
        return Arrays.stream(sample.split("\\s+")).collect(Collectors.toList());
    }

    public static List<String> getTokensByBreakIterator(String sample) {
        List<String> words = new ArrayList<>();
        BreakIterator wordIterator = BreakIterator.getWordInstance();
        wordIterator.setText(sample);
        int boundary = wordIterator.first();
        while (boundary != BreakIterator.DONE) {
            int begin = boundary;
            boundary = wordIterator.next();
            int end = boundary;
            if(end == BreakIterator.DONE) break;
            words.add(sample.substring(begin, end));
        }

        return words;
    }

    public static Map<String, List> usingTheStreamTokenizerClass(String sample) {
        Map<String, List> mapOfLists = new HashMap<>();
        ArrayList<String> listOfStrings = new ArrayList<>();
        ArrayList<Double> listOfIntegers = new ArrayList<>();
        ArrayList<Character> listOfChars = new ArrayList<>();
        try {
            StreamTokenizer tokenizer = new StreamTokenizer(
                    new StringReader(sample));
            tokenizer.ordinaryChar('\'');
            tokenizer.ordinaryChar(',');
            boolean isEOF = false;
            while (!isEOF) {

                int token = tokenizer.nextToken();
                switch (token) {
                    case StreamTokenizer.TT_EOF:
                        isEOF = true;
                        break;
                    case StreamTokenizer.TT_EOL:
                        break;
                    case StreamTokenizer.TT_WORD:
                        System.out.println(tokenizer.sval);
                        listOfStrings.add(tokenizer.sval);
                        break;
                    case StreamTokenizer.TT_NUMBER:
                        System.out.println(tokenizer.nval);
                        listOfIntegers.add(tokenizer.nval);
                        break;
                    default:
                        System.out.println((char) token);
                        listOfChars.add((char)token);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        mapOfLists.put("strings", listOfStrings);
        mapOfLists.put("integers", listOfIntegers);
        mapOfLists.put("chars", listOfChars);

        return mapOfLists;
    }

    public static List<String> usingStopWordsClassExample(String sample) {
        StopWord stopWords = new StopWord();
        SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;
        String tokens[] = simpleTokenizer.tokenize(sample);
        usingLingpipeStopWord();
        return stopWords.removeStopWords(tokens);
    }
}
