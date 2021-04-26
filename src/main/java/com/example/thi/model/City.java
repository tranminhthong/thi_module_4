package com.example.thi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cities")
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Not empty")
    private String name;

    @NotNull(message = "Not empty")
    private double area;

    @NotNull(message = "Not empty")
    private Long population;

    @NotNull(message = "Not empty")
    private double GDP;

    private String description;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}