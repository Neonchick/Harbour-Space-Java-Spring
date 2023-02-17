package com.example.task2;

import org.springframework.stereotype.Component;

@Component
public class Document {

    private SpellChecker spellChecker;

    public Document(SpellChecker spellChecker) {
        System.out.println("Document is created!");
    }

}
