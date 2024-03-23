package com.example.demo.Product.Model;
import jakarta.persistence.*;
import lombok.Data;

@Entity // Marks this class as a JPA entity, representing a table in the database.
@Data // Generates boilerplate code for getters, setters, toString, equals, and hashCode methods.
@Table(name="product") // Specifies the name of the table in the database corresponding to this entity.
public class Product {
    @Id // Marks the primary key field of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategy for the primary key.
    @Column(name ="id") // Specifies the column name in the database table for this field.
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;
}
