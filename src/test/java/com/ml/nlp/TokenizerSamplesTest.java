package com.ml.nlp;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenizerSamplesTest {

    @Test
    public void testTokenizerByScanner(){
        List<String> result = TokenizerSamples.getTokensByScanner("Let's pause, and then reflect.");
        assertThat(result).isEqualTo(List.of("Let's", "pause", "", "and", "then", "reflect"));
    }

    @Test
    public void testGetTokenizerBySplit(){
        List<String> result = TokenizerSamples.getTokensBySplitMethod("Let's pause, and then reflect.");
        assertThat(result).isEqualTo(List.of("Let's", "pause,", "and", "then", "reflect."));
    }

    @Test
    public void testGetTokensByBreakIterator(){
        List<String> result = TokenizerSamples.getTokensByBreakIterator("Let's pause, and then reflect.");
        assertThat(result).isEqualTo(List.of("Let's", " ", "pause", ",", " ", "and", " ", "then", " ", "reflect", "."));
    }

    @Test
    public void testGetTokensByStreamTokenizer(){
        Map<String, List> result = TokenizerSamples.usingTheStreamTokenizerClass("Let's pause, and then reflect.");
        assertThat(result).isNotNull();
        assertThat(result.get("strings")).isEqualTo(List.of("Let", "s", "pause", "and", "then", "reflect."));
    }

    @Test
    public void testRemoveStopWords(){
        List<String> result = TokenizerSamples.usingStopWordsClassExample("A simple approach is to create a class to hold and remove stopwords.");
        assertThat(result).isEqualTo(List.of("A", "simple", "approach", "create", "class", "hold", "and", "remove", "stopwords", "."));
    }
}
