package org.example.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String model;
    @Enumerated
    private CarStatus status;
}
