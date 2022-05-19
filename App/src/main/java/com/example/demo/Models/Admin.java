package com.example.demo.Models;

import javax.persistence.*;

@Entity(name = "Admin")
@Table(name = "admin")
public class Admin {
    @Id
    @SequenceGenerator(
            name = "admin_sequence",
            sequenceName = "admin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_sequence"
    )
    private Integer id;
}
