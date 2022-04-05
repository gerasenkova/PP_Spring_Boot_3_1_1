package com.example.PP_Spring_Boot_3_1_1.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    String name;
    @Column
    int age;
    @Column
    String email;

}
