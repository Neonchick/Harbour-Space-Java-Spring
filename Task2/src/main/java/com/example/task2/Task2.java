package com.example.task2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Task2 {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(Task2.class);

        var oxfordDictionary = context.getBean(OxfordDictionary.class);
        System.out.println(oxfordDictionary.getClass().getSimpleName() + " from context");


        var urbanDictionary = context.getBean(UrbanDictionary.class);
        System.out.println(urbanDictionary.getClass().getSimpleName() + " from context");

        var spellChecker = context.getBean(SpellChecker.class);
        System.out.println(spellChecker.getClass().getSimpleName() + " from context");
        System.out.print("checkSpelling of context spellChecker: ");
        spellChecker.checkSpelling();

        var urbanSpellChecker = new SpellChecker(urbanDictionary);
        System.out.print("checkSpelling of new urbanSpellChecker: ");
        urbanSpellChecker.checkSpelling();

        var document = context.getBean(Document.class);
        System.out.println(document.getClass().getSimpleName() + " from context");

    }

}
