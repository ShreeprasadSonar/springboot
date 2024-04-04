package com.example.demo.Customer;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name="customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    // (cascade = CascadeType.ALL) If we update a customer who also has an address attached it will also update the address
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<Address> address;
}
