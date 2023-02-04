package com.example.task2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SpellChecker {

    private Dictionary dictionary;

    public SpellChecker(@Qualifier("oxfordDictionary") Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void checkSpelling() {
        System.out.println(dictionary.getClass());
    }

}
