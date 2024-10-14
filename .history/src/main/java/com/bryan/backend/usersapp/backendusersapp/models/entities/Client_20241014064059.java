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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="client")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    @Column(name = "identification", unique = true)
    private String identification;

    @NotBlank
    @Size(max = 30)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Size(max = 30)
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Size(max = 50)
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(max = 20)
    @Column(name = "phone_number")
    private String phone_number;


    @Column(name = "inscription_date")
    private Date inscription_date;


    @Column(name = "date_birthday")
    private Date date_birthday;


    @Size(max = 200)
    @Column(name = "address")
    private String address;
}
