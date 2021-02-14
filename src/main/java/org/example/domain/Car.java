package org.example.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Data
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=2, max=30)
    private String brand;
    @NotNull
    @Size(min=2, max=30)
    private String model;
    @Enumerated(EnumType.STRING)
    private CarStatus status;

}
