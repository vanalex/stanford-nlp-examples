package com.ml.nlp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringOperationTest {

    @Test
    void testSplitOperation(){
        String[] result = StringOperation.split("Mr. Smith went to 123 Washington avenue.");
        assertThat(result).isNotNull();
    }
}
