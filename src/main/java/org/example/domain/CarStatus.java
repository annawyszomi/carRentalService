package org.example.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public enum CarStatus {

    AVAILABLE, RENTED;

    @Id
    @GeneratedValue
    private int id;

}
