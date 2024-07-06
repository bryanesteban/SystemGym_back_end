package com.bryan.backend.usersapp.backendusersapp.models.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "identification", unique = true)
    private Date identification;

    @NotBlank
    @Size(max = 30)
    @Column(name = "name", unique = true)
    private String username;

    @NotBlank
    @Size(max = 30)
    @Column(name = "last_name", unique = true)
    private String last_name;

    @NotBlank
    @Size(max = 20)
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank
    @Size(max = 20)
    @Column(name = "phone_number", unique = true)
    private String phone_number;

    @NotBlank
    @Column(name = "date_begin", unique = true)
    private Date inscription_date;

    @NotBlank
    @Column(name = "date_birthday", unique = true)
    private Date date_birthday;


}
