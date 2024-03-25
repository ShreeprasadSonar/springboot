package com.example.demo;

import org.springframework.http.ResponseEntity;

// E for entity and T is generic in JAVA
public interface Command<E, T> {
    ResponseEntity<T> execute(E entity);
}

/*
This Java code defines an interface called Command in a package named com.example.demo.
The interface has a method execute that takes an object of type E (representing an entity)
and returns a ResponseEntity containing an object of type T.
In simpler terms, this interface is like a blueprint for a command. It declares a method called
execute that can be used to perform some action on an object (entity). The method returns a
response, which is wrapped inside a ResponseEntity. The types E and T are placeholders for
different types of objects that the method can handle.
 */