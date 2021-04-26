package com.example.thi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cities")
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Không được để trống")
    private String name;

    @NotNull(message = "Không được để trống") @Min(value = 0L,message = "Không âm")
    private Double area;

    @NotNull(message = "Không được để trống") @Min(value = 0L,message = "Không âm")
    private Long population;

    @NotNull(message = "Không được để trống") @Min(value = 0L,message = "Không âm")
    private Double GDP;

    private String description;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}