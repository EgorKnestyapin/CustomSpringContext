package org.example;


import org.example.context.IntensiveContext;
import org.example.entities.SomeClass1;

public class Main {
    public static void main(String[] args) {
        IntensiveContext context = new IntensiveContext("org.example");
        SomeClass1 class1 = context.getObject(SomeClass1.class);
        class1.run();
    }
}