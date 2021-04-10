package com.ml.nlp;

import opennlp.tools.stemmer.PorterStemmer;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class StemmingTest {

    @Test
    public void stemmingTest(){
        Stream<String> stream = Stream.of("bank", "banking", "banks", "banker", "banked", "bankart");
        PorterStemmer porterStemmer = new PorterStemmer();
        List<String> result = stream.map(porterStemmer::stem).collect(Collectors.toList());
        assertThat(result).isEqualTo(List.of("bank", "bank", "bank", "banker", "bank", "bankart"));
    }
}
