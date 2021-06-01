package com.ml.nlp;

public final class StringOperation {

    private static final String REGEX_SPLIT = "\\s";

    public static String[] split(String str){
        return str.split(REGEX_SPLIT);
    }
}
