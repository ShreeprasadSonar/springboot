package com.example.demo;
import org.springframework.http.ResponseEntity;
public interface Query <I, O>{
    ResponseEntity<O> execute(I input);
}

/*
This code defines a generic interface Query<I, O> in a Spring Boot application.
It specifies a method execute(I input) that takes an input of type I and returns
a ResponseEntity containing a result of type O. This interface is meant to represent
a query operation in a Command Query Responsibility Segregation (CQRS) architecture,
where I represents the input parameters for the query and O represents the output/result
of the query.
 */